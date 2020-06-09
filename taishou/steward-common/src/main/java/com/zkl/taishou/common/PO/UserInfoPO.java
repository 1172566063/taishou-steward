package com.zkl.taishou.common.PO;

import com.zkl.taishou.common.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: 用户展示数据
 * @Author ：lishixiang
 * @Date：2020/5/11-15:26
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("头像图片地址")
    private String headPortraitImg;

    @ApiModelProperty("店铺名字")
    private String name;

    @ApiModelProperty("生成的token")
    private String token;

    public UserInfoPO(User user){
        this.headPortraitImg=user.getHeadPortraitImg();
        this.name=user.getName();
    }
}
