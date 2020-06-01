package com.zkl.taishou.service;

import com.zkl.taishou.common.VO.StaffVO;

import java.util.List;

/**
 * @ClassName: 员工指标诊断
 * @Author ：lishixiang
 * @Date：2020/5/29-11:41
 * @Version:
 */
public interface StaffDiagnoseService {

    void addStaff(List<StaffVO> staffVO, Long userId);

    void joinStaff(List<Long> staffIds,String token);
}
