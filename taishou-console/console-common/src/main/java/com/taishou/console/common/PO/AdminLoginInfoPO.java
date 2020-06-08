package com.taishou.console.common.PO;

import com.taishou.console.common.entity.Administrator;
import com.taishou.console.common.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: 用户登录展示数据
 * @Author ：lishixiang
 * @Date：2020/5/11-15:26
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdminLoginInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("店铺名字")
    private String name;

    @ApiModelProperty("生成的token")
    private String token;

    public AdminLoginInfoPO(Administrator user){
        this.name=user.getName();
    }
}
