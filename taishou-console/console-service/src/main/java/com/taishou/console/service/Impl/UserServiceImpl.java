package com.taishou.console.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.taishou.console.common.PO.UserEchoInfoPO;
import com.taishou.console.common.PO.AdminLoginInfoPO;
import com.taishou.console.common.VO.*;
import com.taishou.console.common.constants.CommonalityProperty;
import com.taishou.console.common.constants.RedisKeyConstants;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.constants.ResultConstants;
import com.taishou.console.common.entity.*;
import com.taishou.console.common.utils.EntityTransform;
import com.taishou.console.common.utils.FileCorrelationUtil;
import com.taishou.console.dao.AdministratorDAO;
import com.taishou.console.dao.StaffDAO;
import com.taishou.console.dao.StoreDAO;
import com.taishou.console.dao.UserDAO;
import com.taishou.console.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/2-17:46
 * @Version:
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private StoreDAO storeDAO;

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private AdministratorDAO administratorDAO;

    @Override
    public Administrator getAdminByRoot(String root) {
        return administratorDAO.selectUserByRoot(root);
    }

    @Override
    @Transactional
    public ResultBean addUser(IncreaseUserVO increaseUserVO) {
        User user = increaseUserVO.toUser();
        User userByPhone = userDAO.selectUserByPhone(user.getPhone());
        if(userByPhone!=null){
            return getFailResult(ResultConstants.ACCOUNT_REPETITION);
        }
        int i = userDAO.insertSelective(user);
        if(i<1){
            return getFailResult();
        }
        if(StringUtils.isNotBlank(increaseUserVO.getStoreName())){
            Store store = new Store();
            store.setName(increaseUserVO.getStoreName());
            store.setUserId(user.getId());
            store.setDel(CommonalityProperty.NO);
            storeDAO.insertSelective(store);
        }
        return getSuccessResult();
    }

    @Override
    public ResultBean login(String phone, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(phone, password);
        String token=null;
        Administrator administrator;
        try {
            subject.login(usernamePasswordToken);
            administrator=(Administrator)subject.getPrincipal();
            //登录  redis存储token
            token = redisService.userLogin(administrator, RedisKeyConstants.ONE_DAY);
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return getFailResult(ResultConstants.LOGIN_FAlL);
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return new ResultBean(ResultConstants.PERMISSION_DENIED);
        }
        AdminLoginInfoPO userInfo=new AdminLoginInfoPO(administrator);
        userInfo.setToken(token);
        return getSuccessResult(userInfo);
    }

    @Override
    public ResultBean getUserList(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPageNumber(),pageParam.getPageSize());
        List<UserEchoInfoPO> userEchoInfoPOS = userDAO.selectAllUserInfos();
        PageInfo<UserEchoInfoPO> result=new PageInfo<>(userEchoInfoPOS);
        return getSuccessResult(result);
    }

    @Override
    public ResultBean<List<Store>> getUserStores(Long userId) {
        return redisService.getResultFromHash(RedisKeyConstants.USER_STORE,userId).map(data->{
            return getSuccessResult(JSON.parseObject(data,new TypeReference<List<Store>>() {}));
        }).orElseGet(()->{
            List<Store> stores = storeDAO.selectStoresByUserId(userId);
            for(Store store : stores){
                store.setStaffs(staffDAO.selectStaffsByStoreIds(store.getId()));
            }
            redisService.putResultToHash(RedisKeyConstants.USER_STORE,userId, JSON.toJSONString(stores));
            return getSuccessResult(stores);
        });
    }

    @Override
    public ResultBean removeStoreById(Long storeId) {
        storeDAO.deleteByPrimaryKey(storeId);
        return getSuccessResult();
    }

    @Override
    public ResultBean removeStaffById(Long staffId) {
        staffDAO.deleteByPrimaryKey(staffId);
        return getSuccessResult();
    }

    @Override
    public ResultBean updateStoreById(StoreVO storeVo) {
        Store store = EntityTransform.Build(storeVo, Store.class).toEntity();
        storeDAO.updateByPrimaryKeySelective(store);
        return getSuccessResult();
    }

    @Override
    public ResultBean updateStaffById(StaffVO staffVo) {
        Staff staff = EntityTransform.Build(staffDAO, Staff.class).toEntity();
        staffDAO.updateByPrimaryKeySelective(staff);
        return getSuccessResult();
    }




    @Override
    public ResultBean updateUserInfo(UserUpdateVO userUpdateVO) {
        User user = userUpdateVO.toUser();
        userDAO.updateByPrimaryKeySelective(user);
        return null;
    }

    @Override
    public ResultBean addAdmin(AddAdminVO addAdminVO) {
        Administrator administrator = addAdminVO.toAministrator();
        administratorDAO.insertSelective(administrator);
        return getSuccessResult();
    }
}
