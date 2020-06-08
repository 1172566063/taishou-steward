package com.taishou.console.common.VO;

import com.taishou.console.common.entity.User;
import com.taishou.console.common.utils.EncryptUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/3-10:15
 * @Version:
 */
@Data
@ApiModel("IncreaseUserVO")
@Accessors(chain = true)
public class IncreaseUserVO implements Serializable {

    private static final long serialVersionUID = 57132116L;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String userName;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Long sex;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号还是要填的")
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String headPortraitImg;

    /**
     * 店铺名称
     */
    @ApiModelProperty("店铺名称")
    private String storeName;

    public User toUser(){
        User user = new User()
                .setName(userName)
                .setPhone(phone)
                .setPassword(EncryptUtil.PawEncryption(phone,password))
                .setHeadPortraitImg(headPortraitImg)
                .setSex(sex);
        return user;
    }
}
