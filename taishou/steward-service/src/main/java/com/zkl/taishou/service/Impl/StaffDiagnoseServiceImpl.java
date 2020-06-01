package com.zkl.taishou.service.Impl;

import com.alibaba.fastjson.JSON;
import com.zkl.taishou.common.VO.StaffVO;
import com.zkl.taishou.common.constants.CommonalityProperty;
import com.zkl.taishou.common.constants.RedisKeyConstants;
import com.zkl.taishou.common.entity.diagnose.Staff;
import com.zkl.taishou.common.utils.EntityTransform;
import com.zkl.taishou.dao.diagnose.StaffDAO;
import com.zkl.taishou.dao.user.StoreDAO;
import com.zkl.taishou.service.StaffDiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 员工指标诊断
 * @Author ：lishixiang
 * @Date：2020/5/29-11:41
 * @Version:
 */
@Service
public class StaffDiagnoseServiceImpl extends BaseService implements StaffDiagnoseService {

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private StoreDAO storeDAO;

    @Override
    public void addStaff(List<StaffVO> staffVOs, Long userId) {
        Long storeId = storeDAO.selectStoreByUserId(userId).getId();
        List<Staff> staffs=new ArrayList<>();
        staffVOs.forEach(staffVO -> {
            Staff staff = EntityTransform.Build(staffVO,Staff.class).toEntity();
            staff.setStoreId(storeId);
            staff.setDel(CommonalityProperty.NO);
            staffs.add(staff);
        });
        staffDAO.insertBatchSelective(staffs);
    }


    @Override
    public void joinStaff(List<Long> staffIds, String token) {
        List<Staff> staff = staffDAO.selectByIdList(staffIds);
        redisService.set(RedisKeyConstants.STAFF_INDEX+token,staff,RedisKeyConstants.THIRTY_MINUTE);
    }
}
