package com.taishou.console.common.utils;

import com.taishou.console.common.constants.CommonalityProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName: 文件相关工具类
 * @Author ：lishixiang
 * @Date：2020/6/6-14:47
 * @Version:
 */
@Slf4j
public class FileCorrelationUtil {

    /**
     * 功能描述：
     *
     * @Param： filePath:文件输出地址 fileName：文件名称 MultipartFile 文件
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/6/6 9:59
     */
    public static boolean filesUpload(String filePath, String fileName, MultipartFile mfile) {
        if (mfile.isEmpty()) {
            return false;
        }
        try (BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File(filePath + File.separator + fileName)))) {
            bos.write(mfile.getBytes());
            bos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }


    /**
     * 文件名后缀前添加一个时间戳
     */
    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String substring = UUID.randomUUID().toString().substring(0,5);
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        StringBuilder sb=new StringBuilder();
        sb.append(CommonalityProperty.头像).append("_").append(nowTimeStr).append(substring).append(fileName.substring(index));
        return sb.toString();
    }


    /**
     * 判断文件大小
     *
     * @param len
     *            文件长度
     * @param size
     *            限制大小
     * @param unit
     *            限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
//        long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }
}
