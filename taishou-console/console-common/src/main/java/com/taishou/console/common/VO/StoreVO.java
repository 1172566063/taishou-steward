/* https://github.com/orange1438 */
package com.taishou.console.common.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taishou.console.common.entity.Staff;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/** 店铺信息表
 * @author orange1438 code generator
 * date:2020-06-03 09:49:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StoreVO implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = -3869618836829099232L;

    /**
     *
     */
    @ApiModelProperty("id")
    @Min(value = 0,message = "id不能为空")
    private Long id;

    /**
     * 店铺名称
     */
    @ApiModelProperty("店铺名称")
    @NotBlank(message = "店铺名字不能为空")
    private String name;
    
    
}
