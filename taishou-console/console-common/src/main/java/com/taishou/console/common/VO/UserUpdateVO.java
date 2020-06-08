package com.taishou.console.common.VO;

import com.taishou.console.common.entity.User;
import com.taishou.console.common.note.PhoneNumber;
import com.taishou.console.common.utils.EncryptUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/3-10:15
 * @Version:
 */
@Data
@ApiModel("UserUpdateVO")
@Accessors(chain = true)
public class UserUpdateVO implements Serializable {

    private static final long serialVersionUID = 57132116L;

    /**
     * id
     */
    @ApiModelProperty("用户id")
    @Min(message = "id不能为空",value = 0)
    private Long userId;

    /**
     * 名字
     */
    @ApiModelProperty("名字")
    @NotBlank(message = "名字不能为空")
    private String userName;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    @Range(min=0, max=3,message = "性别取值范围超出 1男 0女")
    private Long sex;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @PhoneNumber
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    @NotBlank(message = "头像地址不能为空")
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
