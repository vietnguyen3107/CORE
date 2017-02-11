package com.lb.jwitter.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
*
* @author ku
*/
public class Encrypt {
    //Hàm mã hóa 'sha' gồm :
    //     'text' chuỗi giá trị cần mã hóa
    //     'method' phương thức muốn mã hóa: SHA-256, SHA-1
    public static String sha(String text,String method) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(method);
        md.update(text.getBytes());//----- Bắt đầu việc băm giá trị của mảng byte
        byte byteData[] = md.digest();//-- Hoàn tất băm giá trị
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {//--- Lặp theo giá trị của mảng byte để gán vào StringBuffer sb
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
}

