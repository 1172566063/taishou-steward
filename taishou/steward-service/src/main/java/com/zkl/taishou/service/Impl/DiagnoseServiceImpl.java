package com.zkl.taishou.service.Impl;

import com.zkl.taishou.common.VO.*;
import com.zkl.taishou.common.entity.diagnose.*;
import com.zkl.taishou.common.utils.EntityTransform;
import com.zkl.taishou.dao.diagnose.*;
import com.zkl.taishou.dao.diagnose.theCustomerConsumption.ConsumptionAbilityRecordDAO;
import com.zkl.taishou.service.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/19-14:58
 * @Version:
 */
@Service
public class DiagnoseServiceImpl  extends BaseService implements DiagnoseService {

    @Autowired
    private DiagnoseRecordDAO diagnoseRecordMapper;
    @Autowired
    private StoreCostStructureRecordDAO storeCostStructureRecordMapper;
    @Autowired
    private ProfitDiagnosisRecordDAO profitDiagnosisRecordDAO;
    @Autowired
    private CashFlowRecordDAO cashFlowRecordDAO;
    @Autowired
    private YearCashflowRecordDAO yearCashflowRecordDAO;
    @Autowired
    private ActiveRecordDAO activeRecordDAO;

    @Autowired
    private AgeGroupRecordDAO ageGroupRecordDAO;
    @Autowired
    private CustomerSourceRecordDAO customerSourceRecordDAO;
    @Autowired
    private CustomersProfessionalRecordDAO customersProfessionalRecordDAO;
    @Autowired
    private TrafficRecordDAO trafficRecordDAO;
    @Autowired
    private PerCapitaShopRecordDAO perCapitaShopRecordDAO;
    @Autowired
    private EffectiveRegularRecordDAO effectiveRegularRecordDAO;
    @Autowired
    private MonthIncreaseCustomerRecordDAO monthIncreaseCustomerRecordDAO;
    /**
     * 功能描述：运营环境诊断、营销业绩诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 14:39
     */
    @Override
    public void recordDiagnosis(DiagnoseRecordVO diagnoseVO) {
        DiagnoseRecord diagnoseRecord = diagnoseVO.toDiagnoseRecord();
        diagnoseRecordMapper.insertSelective(diagnoseRecord);
    }

    /**
     * 功能描述：门店结构诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 14:40
     */
    @Override
    public void recordStoreCostStructure(StoreCostStructureRecordVO storeCostStructureVO) {
        StoreCostStructureRecord storeCostStructureRecord = storeCostStructureVO.toStoreCostStructure();
        storeCostStructureRecordMapper.insertSelective(storeCostStructureRecord);
    }

    /**
     * 功能描述：每月毛利润诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 14:40
     */
    @Override
    public void recordProfitDiagnosisRecord(ProfitDiagnosisRecordVO profitDiagnosisVO) {
        ProfitDiagnosisRecord profitDiagnosisRecord = profitDiagnosisVO.toProfitDiagnosisRecord();
        profitDiagnosisRecordDAO.insertSelective(profitDiagnosisRecord);
    }

    /**
     * 功能描述：全年现金流诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 14:41
     */
    @Override
    public void recordYearCashFlow(YearCashFlowRecordVO yearCashFlowRecordVO) {
        YearCashFlowRecord yearCashFlowRecord = yearCashFlowRecordVO.toYearCashFlowRecord();
        yearCashflowRecordDAO.insertSelective(yearCashFlowRecord);
    }

    /**
     * 功能描述：每月现金流诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 14:41
     */
    @Override
    public void recordCashFlow(CashFlowRecordVO cashFlowRecordVO) {
        CashFlowRecord cashFlowRecord = cashFlowRecordVO.toCashFlowRecord();
        cashFlowRecordDAO.insertSelective(cashFlowRecord);
    }

    /**
     * 功能描述：顾客活跃度诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 15:11
     */
    @Override
    public void recordActive(ActiveRecordVO activeRecordVO) {
        ActiveRecord activeRecord = activeRecordVO.toActiveRecord();
        activeRecordDAO.insertSelective(activeRecord);
    }



    /**
     * 功能描述：各科年龄结构诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 16:44
     */
    @Override
    public void recordAgeGroup(AgeGroupRecordVO ageGroupRecordVO) {
        AgeGroupRecord ageGroupRecord=EntityTransform.Build(ageGroupRecordVO, new AgeGroupRecord()).toEntity();
        ageGroupRecordDAO.insertSelective(ageGroupRecord);
    }

    /**
     * 功能描述：顾客来源诊断
     * 
     * @Param：
     * @Return: 
     * @Author: LisShiXiang
     * @Date：2020/5/22 18:02
     */
    @Override
    public void recordCustomerSource(CustomerSourceRecordVO customerSourceRecordVO) {
        CustomerSourceRecord customerSourceRecord = EntityTransform.Build(customerSourceRecordVO, new CustomerSourceRecord()).toEntity();
        customerSourceRecordDAO.insertSelective(customerSourceRecord);
    }

    /**
     * 功能描述：顾客职业结构诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 18:02
     */
    @Override
    public void recordCustomersProfessional(CustomersProfessionalRecordVO customersProfessionalRecordVO) {
        CustomersProfessionalRecord customersProfessionalRecord = EntityTransform.Build(customersProfessionalRecordVO, new CustomersProfessionalRecord()).toEntity();
        customersProfessionalRecordDAO.insertSelective(customersProfessionalRecord);
    }

    /**
     * 功能描述：全年客流量诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 18:02
     */
    @Override
    public void recordTraffic(TrafficRecordVO trafficRecordVO) {
        TrafficRecord trafficRecord = EntityTransform.Build(trafficRecordVO, new TrafficRecord()).toEntity();
        trafficRecordDAO.insertSelective(trafficRecord);
    }

    /**
     * 功能描述：人均到店次数诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 18:02
     */
    @Override
    public void recordPerCapitaShop(PerCapitaShopRecordVO perCapitaShopRecordVO) {
        PerCapitaShopRecord perCapitaShopRecord = EntityTransform.Build(perCapitaShopRecordVO, new PerCapitaShopRecord()).toEntity();
        perCapitaShopRecordDAO.insertSelective(perCapitaShopRecord);
    }

    /**
     * 功能描述：有效客户粘性诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 19:19
     */
    @Override
    public void recordEffectiveRegular(EffectiveRegularRecordVO effectiveRegularRecordVO) {
        EffectiveRegularRecord effectiveRegularRecord = EntityTransform.Build(effectiveRegularRecordVO, new EffectiveRegularRecord()).toEntity();
        effectiveRegularRecordDAO.insertSelective(effectiveRegularRecord);
    }

    /**
     * 功能描述：每月新增顾客诊断
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/22 19:19
     */
    @Override
    public void recordMonthIncreaseCustomer(MonthIncreaseCustomerRecordVO monthIncreaseCustomerRecordVO) {
        MonthIncreaseCustomerRecord monthIncreaseCustomerRecord = EntityTransform.Build(monthIncreaseCustomerRecordVO, new MonthIncreaseCustomerRecord()).toEntity();
        monthIncreaseCustomerRecordDAO.insertSelective(monthIncreaseCustomerRecord);
    }
}
