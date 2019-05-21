package com.neuedu.servlet;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws IOException {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "12345";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));


//        final BASE64Encoder encoder = new BASE64Encoder();
//        final BASE64Decoder decoder = new BASE64Decoder();
//        final String text = "字串文字";
//        final byte[] textByte = text.getBytes("UTF-8");
////编码
//        final String encodedText = encoder.encode(textByte);
//        System.out.println(encodedText);
//
////解码
//        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
    }
}