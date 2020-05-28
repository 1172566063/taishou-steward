package com.zkl.taishou.common.VO;

import com.zkl.taishou.common.note.PhoneNumber;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/22-19:32
 * @Version:
 */

@Data
@ApiModel("RegisterVO")
@Accessors(chain = true)
public class RegisterVO implements Serializable {

    private static final long serialVersionUID = -1L;

    @PhoneNumber(message = "手机号格式不正确")
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "用户手机号",required = true, example = "13169918865")
    private String phone;

    @NotBlank(message = "请设置值密码")
    @ApiModelProperty(value = "用户密码",required = true, example = "666666")
    private String password;

    @NotBlank(message = "店铺名称不能为空")
    @ApiModelProperty(value = "店铺名称",required = true, example = "雅美变性美容店")
    private String storeName;
}
