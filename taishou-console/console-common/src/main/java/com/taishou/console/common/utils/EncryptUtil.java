package com.taishou.console.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类
 *
 * @author LiShiXiang
 * @date: 2017年7月7日 0:54:16
 */
public class EncryptUtil {

    /**
     * 功能描述：用户密码加密
     *
     * @Param：
     * @Return:
     * @Author: LisShiXiang
     * @Date：2020/5/9 18:15
     */
    public static String PawEncryption(String account,String password){
        Object simpleHash = new SimpleHash("MD5", password, ByteSource.Util.bytes(account),1024 );
        return simpleHash.toString();
    }

    /**
     * MD5加密
     *
     * @param text
     * @return
     * @author LiShiXiang
     */
    public static String MD5(String text) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        return DigestUtils.md5Hex(text);
    }

    /**
     * MD5加密
     * 将多个字符串拼接起来加密
     *
     * @param texts
     * @return
     */
    public static String MD5(String... texts) {
        if (ArrayUtils.isEmpty(texts)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (String text : texts) {
            if (StringUtils.isBlank(text)) {
                continue;
            }
            sb.append(text);
        }
        return MD5(sb.toString());
    }

    /**
     * 比较md5密文与字符串拼接是否相等
     *
     * @param md5Text
     * @param texts
     * @return
     */
    public static boolean equalsMD5(String md5Text, String... texts) {
        return !StringUtils.isBlank(md5Text) && StringUtils.equals(md5Text, MD5(texts));
    }

    /**
     * 散列
     *
     * @param text
     * @return
     */
    public static String SHA(String text) {
        return DigestUtils.sha1Hex(text);
    }
}
