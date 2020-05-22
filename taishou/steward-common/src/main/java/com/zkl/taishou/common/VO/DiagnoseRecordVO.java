package com.zkl.taishou.common.VO;

import com.zkl.taishou.common.entity.diagnose.DiagnoseRecord;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: 环境诊断、业绩诊断
 * @Author ：lishixiang
 * @Date：2020/5/9-10:19
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DiagnoseRecordVO implements Serializable {
    private static final long serialVersionUID = -1L;

    @NotNull
    @Min(value = 0, message = "basicItem值不能能小于0")
    @ApiModelProperty(value = "基本品项每月业绩",required = true,example = "0")
    private Double basicItem;
    @NotNull
    @Min(value = 0, message = "featuresItem值不能能小于0")
    @ApiModelProperty(value = "特色品项每月业绩",required = true,example = "0")
    private Double featuresItem;
    @NotNull
    @Min(value = 0, message = "bigItem值不能能小于0")
    @ApiModelProperty(value = "大项目每月业绩",required = true,example = "0")
    private Double bigItem;
    @NotNull
    @Min(value = 0, message = "homeAndOutside值不能能小于0")
    @ApiModelProperty(value = "居家外带每月业绩",required = true,example = "0")
    private Double homeAndOutside;
    @Min(value = 0, message = "type值不能能小于0")
    @ApiModelProperty(value = "诊断类型 1运营环境检测  2营销业绩诊断" ,required = true,example = "0")
    private Long type;

    private Long userId;

    public DiagnoseRecord toDiagnoseRecord(){
        DiagnoseRecord diagnoseRecord=new DiagnoseRecord()
                .setBasicItem(this.basicItem)
                .setBigItem(this.bigItem)
                .setFeaturesItem(this.featuresItem)
                .setHomeAndOutside(this.homeAndOutside)
                .setType(this.type)
                .setUserId(this.userId);
        return diagnoseRecord;
    }
}
