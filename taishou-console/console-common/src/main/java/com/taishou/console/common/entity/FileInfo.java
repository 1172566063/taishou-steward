package com.taishou.console.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/8-11:43
 * @Version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FileInfo implements Serializable {

    private static final long serialVersionUID =1L;

    private byte[] fileBytes;

    private String fileName;

}
