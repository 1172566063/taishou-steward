package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.*;
import com.zkl.taishou.common.entity.diagnose.*;
import com.zkl.taishou.common.utils.EntityTransform;
import com.zkl.taishou.dao.diagnose.theCustomerConsumption.CustomerCardBalanceRecordDAO;
import com.zkl.taishou.dao.diagnose.theCustomerConsumption.CustomerYearPerformanceDAO;
import com.zkl.taishou.dao.diagnose.theCustomerConsumption.*;
import com.zkl.taishou.service.CustomerConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: 客户消费诊断
 * @Author ：lishixiang
 * @Date：2020/5/28-15:37
 * @Version:
 */
@Service
public class CustomerConsumptionServiceImpl extends BaseService implements CustomerConsumptionService {

    @Autowired
    private ConsumptionAbilityRecordDAO consumptionAbilityRecordDAO;
    
    @Autowired
    private ConsumerSpendingPotentialDAO consumerSpendingPotentialDAO;

    @Autowired
    private ConsumerYearSpendingRecordDAO consumerYearSpendingRecordDAO;

    @Autowired
    private YearConsumptionCardRecordDAO yearConsumptionCardRecordDAO;

    @Autowired
    private CustomerCardBalanceRecordDAO customerCardBalanceRecordDAO;

    @Autowired
    private CustomerServiceCardRecordDAO customerServiceCardRecordDAO;

    @Autowired
    private CustomerYearPerformanceDAO customerYearPerformanceDAO;

    @Autowired
    private MonthConsumeCustomerRecordDAO monthConsumeCustomerRecordDAO;

    @Autowired
    private MonthFieldRecordDAO monthFieldRecordDAO;


    /**
     * 功能描述：顾客年度产品消费诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 16:06
     */
    @Override
    public void recordConsumptionAbility(ConsumptionAbilityRecordVO consumptionAbilityRecordVO) {
        ConsumptionAbilityRecord consumptionAbilityRecord = consumptionAbilityRecordVO.toConsumptionAbilityRecord();
        consumptionAbilityRecordDAO.insertSelective(consumptionAbilityRecord);
    }

    /**
     * 功能描述：顾客消费潜力诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/28 15:48
     */
    @Override
    public void recordConsumerSpendingPotential(ConsumerSpendingPotentialVO consumerSpendingPotentialVO) {
        ConsumerSpendingPotential consumerSpendingPotential = EntityTransform.Build(consumerSpendingPotentialVO, new ConsumerSpendingPotential()).toEntity();
        consumerSpendingPotentialDAO.insertSelective(consumerSpendingPotential);
    }

    /**
     * 功能描述：顾客年度项目消费诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 17:05
     */
    @Override
    public void recordConsumerYearSpending(ConsumerYearSpendingRecordVO consumerYearSpendingRecordVO) {
        ConsumerYearSpendingRecord consumerYearSpendingRecord = EntityTransform.Build(consumerYearSpendingRecordVO, new ConsumerYearSpendingRecord()).toEntity();
        consumerYearSpendingRecordDAO.insertSelective(consumerYearSpendingRecord);
    }


    /**
     * 功能描述：年度服务卡消费诊断记录
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 17:27
     */
    @Override
    public void recordCustomerServiceCard(CustomerServiceCardRecordVO customerServiceCardRecordVO) {
        CustomerServiceCardRecord customerServiceCardRecord = EntityTransform.Build(customerServiceCardRecordVO, new CustomerServiceCardRecord()).toEntity();
        customerServiceCardRecordDAO.insertSelective(customerServiceCardRecord);
    }

    /**
     * 功能描述：顾客年度服务卡耗诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/28 17:49
     */
    @Override
    public void recordYearConsumptionCard(YearConsumptionCardRecordVO yearConsumptionCardRecordVO) {
        YearConsumptionCardRecord yearConsumptionCardRecord = EntityTransform.Build(yearConsumptionCardRecordVO, new YearConsumptionCardRecord()).toEntity();
        yearConsumptionCardRecordDAO.insertSelective(yearConsumptionCardRecord);
    }

    /**
     * 功能描述：顾客年度服务卡余额诊断记录
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 18:05
     */
    @Override
    public void recordCustomerCardBalanceRecord(CustomerCardBalanceRecordVO customerCardBalanceRecordVO) {
        CustomerCardBalanceRecord customerCardBalanceRecord = EntityTransform.Build(customerCardBalanceRecordVO, new CustomerCardBalanceRecord()).toEntity();
        customerCardBalanceRecordDAO.insertSelective(customerCardBalanceRecord);
    }

    /**
     * 功能描述：顾客全年消耗业绩诊断记录
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 18:58
     */
    @Override
    public void recordCustomerYearPerformance(CustomerYearPerformanceVO customerYearPerformanceVO) {
        CustomerYearPerformance customerServiceCardRecord=EntityTransform.Build(customerYearPerformanceVO, new CustomerYearPerformance()).toEntity();
        customerYearPerformanceDAO.insertSelective(customerServiceCardRecord);
    }


    /**
     * 功能描述：顾客每月消耗业绩诊断记录
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 19:10
     */
    @Override
    public void recordMonthConsumeCustomerRecord(MonthConsumeCustomerRecordVO monthConsumeCustomerRecordVO) {
        MonthConsumeCustomerRecord monthConsumeCustomerRecord = EntityTransform.Build(monthConsumeCustomerRecordVO, new MonthConsumeCustomerRecord()).toEntity();
        monthConsumeCustomerRecordDAO.insertSelective(monthConsumeCustomerRecord);
    }


    /**
     * 功能描述：顾客每月实操客数诊断记录表
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/28 19:19
     */
    @Override
    public void recordMonthField(MonthFieldRecordVO monthFieldRecordVO) {
        MonthFieldRecord monthFieldRecord = EntityTransform.Build(monthFieldRecordVO, new MonthFieldRecord()).toEntity();
        monthFieldRecordDAO.insertSelective(monthFieldRecord);

    }
}
