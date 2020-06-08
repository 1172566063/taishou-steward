package com.taishou.console.common.utils;

import com.taishou.console.common.constants.CommonalityProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/12-14:56
 * @Version:
 */
@Slf4j
public class CommonUtils {

    /**
     * 判断double是否是整数
     *
     * @param dob
     * @return
     */
    public static boolean isIntegerForDouble(double dob) {
        double eps = 1e-10;  // 精度范围
        return dob - Math.floor(dob) < eps;
    }


    /**
     * 获取当前系统路径
     */
    public static String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/upload/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }
}
