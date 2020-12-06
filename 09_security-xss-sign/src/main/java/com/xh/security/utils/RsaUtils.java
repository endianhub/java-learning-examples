package com.xh.security.utils;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


/**
 * <b>Title: 加密/解密/签名/验签</b>
 * <p>Description: </p>
 *
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2019年7月11日
 */
public final class RsaUtils {

    private static final String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCd7gBmZOb7jxQ7n36CdStuMKlWvKPvZjyGgjlGiagnp/iqouMT7urG2PnjuDbT1PqVtYh9ML0PfNg5By600FwrUABPKHFGEfls34MB9Gf5aBXLF+Sk8BYRYKXDibN3vd5/puvKBJd9Cxy9UYTKkF9mqi9+9LJ7+o5GoQ9LhlrcIaOZtXXfUDIURNYg2wVB3YY7ZL656tqp3rUmH4zYsry/uWZT64K4vwzg7Qq2qa2+Edxgterg5+kVaUHVJi2W/UMYNR1iXReSaOMUO0xN9xA3uM2enB7TK10+KFrlEDDEtEP8Nasp6TSE1f69TZvWtPVm+ApdD1UZHptztuKhe+v9AgMBAAECggEAG45KfZM/hkcZxal3nnWpRUmyUlMJ25ygFOwl6DvenkS9q7BOJM08I8P6HhSnZGC19Gc/UHCvnEMxSwoIyT3NxzTnSOiKkypRtgBt0Gp/tdHGc7BQkcLeZtvRMIQXT15Os0FBxPb2I7hLpHDT1bBJJRWuwd0aQ22dY494prnjoqLo7cgmFznRYPnbiC+poRqeGBor9c9EdZ35sme4dQgvvEETm73G1OfvylzgIir8jRZ/TzoOOHMXCKagt0o1Z4071qchuMI9Hjo7h9WgiTr3zQnhXq+Barm4vnMg9B3lcFowcbg5OPqv54TfoyWzZb8VJAhS2Twcvbn8QCPSZ9Iz4QKBgQDrBTBsTF9sJCI7xqwS8tfoqMndc6g65NdolJOEXEKtwdyLXCB4vDkdiGynt65++E/V1sNYpoM4LHjLKueqibuSKZ/rVhxeoZvAy0Y/+qUVV3/pq4WOFTeF6uIxnkwYYO5XfdV5eLKE8fVxvh9chte5t3TB6ZKHX1iJn7btFp+rlQKBgQCsBxjAmuPdUKoUhPYb6OKTJXuadqgfYWUSqotdVwOTC4uugriDBRSSaKw1y3zKKWzxyrqAzKSvko3LRNS3Q7u3VlleMsKSd/f3aV7jM/dx0ex+1dpdBZyKx2aAg8CuEP4qX96BUdhkhsr8+meRu336LW583rOhg5/sCQ5ufLhkyQKBgFC1RX3LdHGEryTsAye2saK6ZChikYE4GSlW7JnlvRhCnORWzOfpa4vSz82A7LG5wGDlEcyd0i42R30tzMTp67o0BTEiLzfoM76vj/5kqtB7bffm6URz0M9ybB8yB1vP3cm58td2NYgmN23KJqb1v5uNftEgzysh+Ru5923P+SFJAoGAKj6752CiIJFUkyFrxsLUEUqdJfuJodsrFQBopQ1fRVcKgFp9sT8oJCQsVjGYfZTaui4MyuB2eN9GjupiSncJvCYqYCWa/pkTfeCUersiQwNIToV50Go2XSZGl7zDLnvhzsooPB27RESNyL49fN5MO4m4nlWaS0mlljNLJfre1XECgYEAxnurK263O6Aa28kusGEYXTgA03tLkEmWRAXoiBUkpNd1uhgZVbBB/uLggZi01UISN/GzHoJ5157zQ+VeQeUCRcLYOIR/F33QiZkB3HFYusmtZLQZS/oZEx8CZa5irKqKDdMb+PsER9U1fK3qEIV5DFyFzYRE4OALR0azCI2v7Kw=";
    private static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAne4AZmTm+48UO59+gnUrbjCpVryj72Y8hoI5RomoJ6f4qqLjE+7qxtj547g209T6lbWIfTC9D3zYOQcutNBcK1AATyhxRhH5bN+DAfRn+WgVyxfkpPAWEWClw4mzd73ef6brygSXfQscvVGEypBfZqovfvSye/qORqEPS4Za3CGjmbV131AyFETWINsFQd2GO2S+ueraqd61Jh+M2LK8v7lmU+uCuL8M4O0KtqmtvhHcYLXq4OfpFWlB1SYtlv1DGDUdYl0XkmjjFDtMTfcQN7jNnpwe0ytdPiha5RAwxLRD/DWrKek0hNX+vU2b1rT1ZvgKXQ9VGR6bc7bioXvr/QIDAQAB";
    private static final String RSA_ALGORITHM = "RSA";
    private static final String RSA2_ALGORITHM = "RSA2";
    private static final Base64.Decoder DECODER = Base64.getDecoder();
    private static final Base64.Encoder ENCODER = Base64.getEncoder();

    private RsaUtils() {

    }

    public static Map<String, String> getInstanceKeys(int keySize) {
        return RsaUtils.createKeys(keySize);
    }

    // 创建公钥私钥
    private static Map<String, String> createKeys(int keySize) {
        Map<String, String> keyPairMap = new HashMap<String, String>();
        try {
            // 为RSA算法创建一个KeyPairGenerator对象
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA_ALGORITHM);
            // 初始化KeyPairGenerator对象,密钥长度
            kpg.initialize(keySize);
            // 生成密匙对
            KeyPair keyPair = kpg.generateKeyPair();
            // 得到公钥
            Key publicKey = keyPair.getPublic();
            // 得到私钥
            Key privateKey = keyPair.getPrivate();

            keyPairMap.put("publicKey", ENCODER.encodeToString(publicKey.getEncoded()));
            keyPairMap.put("privateKey", ENCODER.encodeToString(privateKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPairMap;
    }

    /**
     * <b>Title: 得到公钥</b>
     * <p>Description: </p>
     *
     * @param publicKey 密钥字符串（经过base64编码）
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @author H.Yang
     */
    public static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(DECODER.decode(publicKey));
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
        return key;
    }

    /**
     * <b>Title: 得到私钥</b>
     * <p>Description: </p>
     *
     * @param privateKey 密钥字符串（经过base64编码）
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @author H.Yang
     */
    public static RSAPrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(DECODER.decode(privateKey));
        RSAPrivateKey key = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }

    /**
     * <b>Title: 公钥解密</b>
     * <p>Description: </p>
     *
     * @param data
     * @param publicKey
     * @return
     * @author H.Yang
     */
    public static String publicDecrypt(String data, RSAPublicKey publicKey, String charset) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] bytes = RsaUtils.rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, DECODER.decode(data), publicKey.getModulus().bitLength());
            return new String(bytes, charset);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <b>Title: 私钥加密</b>
     * <p>Description: </p>
     *
     * @param data
     * @param privateKey
     * @return
     * @author H.Yang
     */
    public static String privateEncrypt(String data, RSAPrivateKey privateKey, String charset) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            byte[] bytes = RsaUtils.rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(charset), privateKey.getModulus().bitLength());
            return ENCODER.encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <b>Title: 公钥加密</b>
     * <p>Description: </p>
     *
     * @param data
     * @param publicKey
     * @return
     * @author H.Yang
     */
    public static String publicEncrypt(String data, RSAPublicKey publicKey, String charset) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = RsaUtils.rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(charset), publicKey.getModulus().bitLength());
            return ENCODER.encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException("加密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <b>Title: 私钥解密</b>
     * <p>Description: </p>
     *
     * @param data
     * @param privateKey
     * @return
     * @author H.Yang
     */
    public static String privateDecrypt(String data, RSAPrivateKey privateKey, String charset) {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytes = RsaUtils.rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, DECODER.decode(data), privateKey.getModulus().bitLength());
            return new String(bytes, charset);
        } catch (Exception e) {
            throw new RuntimeException("解密字符串[" + data + "]时遇到异常", e);
        }
    }

    /**
     * <b>Title: 签名:RSA/RSA2</b>
     * <p>Description: </p>
     *
     * @param content    明文
     * @param privateKey 私钥
     * @param signType   签名类型：RSA/RSA2
     * @param charset    编码
     * @return
     * @author H.Yang
     */
    public static String getSign(String content, RSAPrivateKey privateKey, String signType, String charset) {
        if ("RSA".equals(signType)) {
            return RsaUtils.rsaSign(content, privateKey, charset);
        }
        if ("RSA2".equals(signType)) {
            return RsaUtils.rsa256Sign(content, privateKey, charset);
        }
        return null;
    }

    /**
     * <b>Title: 签名验证:RSA/RSA2</b>
     * <p>Description: </p>
     *
     * @param content   明文
     * @param publicKey 公钥
     * @param sign      签名信息
     * @param signType  签名类型：RSA/RSA2
     * @param charset   编码
     * @return
     * @author H.Yang
     */
    public static boolean signChecker(String content, RSAPublicKey publicKey, String sign, String signType, String charset) {
        if ("RSA".equals(signType)) {
            return RsaUtils.rsaCheckContent(content, publicKey, sign, charset);
        }
        if ("RSA2".equals(signType)) {
            return RsaUtils.rsa256CheckContent(content, publicKey, sign, charset);
        }
        return false;
    }

    private static boolean rsaCheckContent(String content, RSAPublicKey publicKey, String sign, String charset) {
        try {
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(publicKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            return signature.verify(DECODER.decode(sign.getBytes()));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String rsaSign(String content, RSAPrivateKey privateKey, String charset) {
        try {
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(privateKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            byte[] signed = signature.sign();
            return ENCODER.encodeToString(signed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String rsa256Sign(String content, RSAPrivateKey privateKey, String charset) {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(privateKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            byte[] signed = signature.sign();
            return ENCODER.encodeToString(signed);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean rsa256CheckContent(String content, RSAPublicKey publicKey, String sign, String charset) {
        try {
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initVerify(publicKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            return signature.verify(DECODER.decode(sign));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize) throws IOException {
        int maxBlock = 0;
        if (opmode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (datas.length > offSet) {
                if (datas.length - offSet > maxBlock) {
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(datas, offSet, datas.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        out.close();
        return resultDatas;
    }

    public static void main(String[] args) throws Exception {
        // Map<String, String> keyPairMap = getInstanceKeys(2048);
        // System.out.println(keyPairMap.get("publicKey"));
        // System.out.println(keyPairMap.get("privateKey"));

        // String centext = "Hello Word";
        // RsaUtils rsa = new RsaUtils();
        //
        // String encodedData = rsa.publicEncrypt(centext, rsa.getPublicKey(publicKey), "UTF-8");
        // System.out.println("密文：\r\n" + encodedData);
        //
        // String sign = rsa.getSign(encodedData, rsa.getPrivateKey(privateKey), "RSA2", "UTF-8");
        // System.out.println(sign);
        // boolean flag = rsa.signChecker(encodedData, rsa.getPublicKey(publicKey), sign, "RSA2", "UTF-8");
        // System.out.println(flag);
        //
        // String decodedData = rsa.privateDecrypt(encodedData, rsa.getPrivateKey(privateKey), "UTF-8");
        // System.out.println("解密后文字: \r\n" + decodedData);
        // //
        // System.out.println();
        // //
        // encodedData = rsa.privateEncrypt(centext, rsa.getPrivateKey(privateKey), "UTF-8");
        // System.out.println("密文：\r\n" + encodedData);
        //
        // sign = rsa.getSign(encodedData, rsa.getPrivateKey(privateKey), "RSA2", "UTF-8");
        // System.out.println(sign);
        // flag = rsa.signChecker(encodedData, rsa.getPublicKey(publicKey), sign, "RSA2", "UTF-8");
        // System.out.println(flag);
        //
        // decodedData = rsa.publicDecrypt(encodedData, rsa.getPublicKey(publicKey), "UTF-8");
        // System.out.println("解密后文字: \r\n" + decodedData);

        Map<String, String> keyPairMap = getInstanceKeys(2048);
        System.out.println(keyPairMap.get("publicKey"));
        System.out.println(keyPairMap.get("privateKey"));

        String centext = "Hello Word";
        String encodedData = RsaUtils.publicEncrypt(centext, RsaUtils.getPublicKey(PUBLIC_KEY), "UTF-8");
        System.out.println("密文：\r\n" + encodedData);

        String sign = RsaUtils.getSign(encodedData, RsaUtils.getPrivateKey(PRIVATE_KEY), RSA2_ALGORITHM, "UTF-8");
        System.out.println(sign);
        boolean flag = RsaUtils.signChecker(encodedData, RsaUtils.getPublicKey(PUBLIC_KEY), sign, RSA2_ALGORITHM, "UTF-8");
        System.out.println(flag);

        String decodedData = RsaUtils.privateDecrypt(encodedData, RsaUtils.getPrivateKey(PRIVATE_KEY), "UTF-8");
        System.out.println("解密后文字: \r\n" + decodedData);
        //
        System.out.println();
        //
        encodedData = RsaUtils.privateEncrypt(centext, RsaUtils.getPrivateKey(PRIVATE_KEY), "UTF-8");
        System.out.println("密文：\r\n" + encodedData);

        sign = RsaUtils.getSign(encodedData, RsaUtils.getPrivateKey(PRIVATE_KEY), RSA2_ALGORITHM, "UTF-8");
        System.out.println(sign);
        flag = RsaUtils.signChecker(encodedData, RsaUtils.getPublicKey(PUBLIC_KEY), sign, RSA2_ALGORITHM, "UTF-8");
        System.out.println(flag);

        decodedData = RsaUtils.publicDecrypt(encodedData, RsaUtils.getPublicKey(PUBLIC_KEY), "UTF-8");
        System.out.println("解密后文字: \r\n" + decodedData);

    }

}
