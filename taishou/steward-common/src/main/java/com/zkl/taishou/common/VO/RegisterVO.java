package com.zkl.taishou.common.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/22-19:32
 * @Version:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class RegisterVO implements Serializable {

    private static final long serialVersionUID = -1L;

    private String phone;

    private String password;

    private String storeName;
}
