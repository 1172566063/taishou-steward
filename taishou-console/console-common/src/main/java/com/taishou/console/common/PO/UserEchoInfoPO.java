package com.taishou.console.common.PO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taishou.console.common.entity.Store;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: 用户信息回显
 * @Author ：lishixiang
 * @Date：2020/6/3-16:18
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserEchoInfoPO implements Serializable {

    private static final long serialVersionUID = 166358143L;

    private Long id;

    @ApiModelProperty("性别")
    private Long sex;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("手机号")
    private String phone;

    @JsonIgnore
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty(value = "头像地址")
    private String headPortraitImg;

}
