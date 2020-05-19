package com.zkl.taishou.common.VO;

import com.zkl.taishou.common.entity.CalculateRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.Min;
import java.io.Serializable;


/**
 * @ClassName: 测算第一步页面数据接收类
 * @Author ：lishixiang
 * @Date：2020/5/9-10:05
 * @Version:
 */
@Data
@ApiModel("CalculateStepOne")
@Accessors(chain = true)
public class CalculateStepOneVO implements Serializable {

    private static final long serialVersionUid = -1L;

    @ApiModelProperty(value = "单店营业面积",required = true,example = "0")
    @Min(value = 0)
    private Long area;//单店营业面积

    @ApiModelProperty(value = "单店房间数",required = true,example = "0")
    @Min(value = 0)
    private Long roomNum;//单店房间数

    @ApiModelProperty(value = "有效床位数",required = true,example = "0")
    @Min(value = 0)
    private Long bedNum;//有效床位数

    @ApiModelProperty(value = "员工数",required = true,example = "0")
    @Min(value = 0)
    private Long staffNum;//员工数

    @ApiModelProperty(value = "预估客户数",required = true,example = "0")
    @Min(value = 0)
    private Long clientNum;//预估/月客户数

    private Long userId;//用户id

    public CalculateRecord toCalculateRecord(){
        return new CalculateRecord()
                .setArea(this.area)
                .setBedNum(this.bedNum)
                .setClientNum(this.clientNum)
                .setRoomNum(this.roomNum)
                .setStaffNum(this.staffNum)
                .setUserId(this.userId);
    }

}
