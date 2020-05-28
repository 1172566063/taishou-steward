package com.zkl.taishou.service;

import com.zkl.taishou.common.VO.*;


/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/28-15:37
 * @Version:
 */
public interface CustomerConsumptionService {

    void recordConsumptionAbility(ConsumptionAbilityRecordVO consumptionAbilityRecordVO);

    void recordConsumerSpendingPotential(ConsumerSpendingPotentialVO consumerSpendingPotentialVO);

    void recordConsumerYearSpending(ConsumerYearSpendingRecordVO consumerYearSpendingRecordVO);

    void recordYearConsumptionCard(YearConsumptionCardRecordVO yearConsumptionCardRecordVO);

    void recordCustomerServiceCard(CustomerServiceCardRecordVO customerServiceCardRecordVO);

    void recordCustomerCardBalanceRecord(CustomerCardBalanceRecordVO customerCardBalanceRecordVO);

    void recordCustomerYearPerformance(CustomerYearPerformanceVO customerYearPerformanceVO);

    void recordMonthConsumeCustomerRecord(MonthConsumeCustomerRecordVO monthConsumeCustomerRecordVO);

    void recordMonthField(MonthFieldRecordVO monthFieldRecordVO);
}
