package com.bootsrc.crypto.app;

import java.security.*;
import java.util.Base64;

public class DigitalSignatureMain {
    public static void main(String[] args) throws Exception {
        String content = "study hard and make progress everyday";
        System.out.println("content :" + content);

        KeyPair keyPair = getKeyPair();
        // 获取公钥对象
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥对象
        PrivateKey privateKey = keyPair.getPrivate();

        String md5Sign = getMd5Sign(content, privateKey);
        System.out.println("MD5withRSA算法的签名 :" + md5Sign);
        boolean md5Verifty = verifyWhenMd5Sign(content, md5Sign, publicKey);
        System.out.println("MD5withRSA算法的签名验签结果 :" + md5Verifty);

        String sha1Sign = getSha1Sign(content, privateKey);
        System.out.println("SHA1withRSA算法的签名 :" + sha1Sign);
        boolean sha1Verifty = verifyWhenSha1Sign(content, sha1Sign, publicKey);
        System.out.println("SHA1withRSA算法的签名验签结果 :" + sha1Verifty);

    }

    // 生成密钥对
    static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512); //这是生成的秘钥长度，此处的值也可以是1024或2048。秘钥越大加密后的密文长度也越大，加密解密越慢。加密的原文要比秘钥小些。一般1024足够用了。
        KeyPair keyPair = keyGen.generateKeyPair();
        return keyPair;
    }

    // 用md5生成内容摘要，再用RSA的私钥加密，进而生成数字签名
    static String getMd5Sign(String content, PrivateKey privateKey) throws Exception {
        byte[] contentBytes = content.getBytes("utf-8");
        // 返回MD5withRSA签名算法的 Signature对象
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(privateKey);
        signature.update(contentBytes);
        byte[] signs = signature.sign();
        return Base64.getEncoder().encodeToString(signs);
    }

    // 对用md5和RSA私钥生成的数字签名进行验证
    static boolean verifyWhenMd5Sign(String content, String sign, PublicKey publicKey) throws Exception {
        byte[] contentBytes = content.getBytes("utf-8");
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(contentBytes);
//        return signature.verify(Base64.decodeBase64(sign));
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    // 用sha1生成内容摘要，再用RSA的私钥加密，进而生成数字签名
    static String getSha1Sign(String content, PrivateKey privateKey) throws Exception {
        byte[] contentBytes = content.getBytes("utf-8");
        // 返回SHA1WithRsa签名算法的 Signature对象
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(contentBytes);
        byte[] signs = signature.sign();
//        return Base64.encodeBase64String(signs);
        return Base64.getEncoder().encodeToString(signs);
    }

    // 对用md5和RSA私钥生成的数字签名进行验证
    static boolean verifyWhenSha1Sign(String content, String sign, PublicKey publicKey) throws Exception {
        byte[] contentBytes = content.getBytes("utf-8");
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(contentBytes);
//        return signature.verify(Base64.decodeBase64(sign));
        return signature.verify(Base64.getDecoder().decode(sign));
    }
}
