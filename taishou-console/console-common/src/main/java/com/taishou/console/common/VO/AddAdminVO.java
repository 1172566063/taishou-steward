/* https://github.com/orange1438 */
package com.taishou.console.common.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taishou.console.common.entity.Administrator;
import com.taishou.console.common.utils.EncryptUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 添加管理员 administrator
 *
 * @author orange1438 code generator
 * date:2020-06-06 15:56:30
 */
@Data
@ApiModel("AddAdminVO")
@Accessors(chain = true)
public class AddAdminVO implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = -8965375343037747555L;

    /**
     * 用户名称
     */
    @NotBlank(message = "用户名称不能为空")
    @ApiModelProperty("用户名称")
    private String name;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户名")
    private String root;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 角色  默认：0
     */
    //TODO 暂时不需要角色
    @ApiModelProperty("角色id")
    @JsonIgnore
    private Long roleId;

    public Administrator toAministrator() {
        Administrator administrator = new Administrator().setName(name)
                .setRoot(root)
                .setPassword(EncryptUtil.PawEncryption(root, password))
                .setRoleId(roleId);
        return administrator;
    }

}