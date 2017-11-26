package com.globot.hmi.attendance.util;/**
 * Created by lixiaoliang on 2017/11/18.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: lixiaoliang
 * Date: 2017/11/18
 * Time: 上午9:31
 */
public class MD5Util {

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String getMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        //加密后的字符串
        return bytesToHex(md5.digest(str.getBytes("utf-8")));
    }

    /**
     * 二进制转十六进制
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    /**判断加密前后的字符串是否相等
     * @param str  待比较字符串
     * @param md5Str  md5加密后的摘要
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean equals(String str, String md5Str) {
        try {
            if (getMD5(str).equals(md5Str))
                return true;
            else
                return false;
        }catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(MD5Util.getMD5("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
