package com.zkl.taishou.service;

import com.zkl.taishou.common.VO.*;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/19-14:57
 * @Version:
 */
public interface DiagnoseService{

    void recordDiagnosis(DiagnoseRecordVO diagnoseVO);

    void recordStoreCostStructure(StoreCostStructureRecordVO storeCostStructureVO);

    void recordProfitDiagnosisRecord(ProfitDiagnosisRecordVO profitDiagnosisVO);

    void recordYearCashFlow(YearCashFlowRecordVO yearCashFlowRecordVO);

    void recordCashFlow(CashFlowRecordVO cashFlowRecordVO);

    void recordActive(ActiveRecordVO activeRecordVO);

    void recordConsumptionAbility(ConsumptionAbilityRecordVO consumptionAbilityRecordVO);

    void recordAgeGroup(AgeGroupRecordVO ageGroupRecordVO);

    void recordCustomerSource(CustomerSourceRecordVO customerSourceRecordVO);

    void recordCustomersProfessional(CustomersProfessionalRecordVO customersProfessionalRecordVO);

    void recordTraffic(TrafficRecordVO trafficRecordVO);

    void recordPerCapitaShop(PerCapitaShopRecordVO perCapitaShopRecordVO);

    void recordEffectiveRegular(EffectiveRegularRecordVO effectiveRegularRecordVO);

    void recordMonthIncreaseCustomer(MonthIncreaseCustomerRecordVO monthIncreaseCustomerRecordVO);
}
