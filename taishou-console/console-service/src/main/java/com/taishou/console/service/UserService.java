package com.taishou.console.service;

import com.taishou.console.common.PO.AdminLoginInfoPO;
import com.taishou.console.common.VO.*;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.entity.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/2-17:46
 * @Version:
 */
public interface UserService {

    Administrator getAdminByRoot(String phone);

    ResultBean addUser(IncreaseUserVO increaseUserVO);

    ResultBean<AdminLoginInfoPO> login(String phone, String password);

    ResultBean<PageInfo> getUserList(PageParam pageParam);

    ResultBean<List<Store>> getUserStores(Long userId);

    ResultBean removeStoreById(Long storeId);

    ResultBean removeStaffById(Long staffId);

    ResultBean updateStoreById(StoreVO store);

    ResultBean updateStaffById(StaffVO staff);

    //ResultBean pictureUpload(MultipartFile file, HttpServletRequest request);

    ResultBean updateUserInfo(UserUpdateVO userUpdateVO);

    ResultBean addAdmin(AddAdminVO addAdminVO);
}
