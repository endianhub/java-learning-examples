package com.xh.security.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

/**
 * <b>Title: 微信加密方式</b>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @email xhaimail@163.com
 * @date 2019年7月11日
 */
public final class EncrUtils {
	
	private EncrUtils() {

	}

	// 获取终端Ip
	public static String GetIp() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
			String localip = ia.getHostAddress();
			return localip;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <b>Title: 方法用途: 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序），并且生成url参数串</b>
	 * <p>Description: </p>
	 * 
	 * @author H.Yang
	 * 
	 * @param paraMap 要排序的Map对象  
	 * @param urlEncode 是否需要URLENCODE  
	 * @param keyToLower 是否需要将Key转换为全小写：true:key转化成小写，false:不转化  
	 * @return
	 */
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower) {
		if (paraMap == null) {
			return "";
		}
		String buff = "";
		Map<String, String> tmpMap = paraMap;
		try {
			List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());
			// 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
			Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
				@Override
				public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
					return (o1.getKey()).toString().compareTo(o2.getKey());
				}
			});
			// 构造URL 键值对的格式
			StringBuilder buf = new StringBuilder();
			for (Map.Entry<String, String> item : infoIds) {
				String key = item.getKey();
				String val = item.getValue();
				if (urlEncode) {
					val = URLEncoder.encode(val, "utf-8");
				}
				if (keyToLower) {
					buf.append(key.toLowerCase() + "=" + val);
				} else {
					buf.append(key + "=" + val);
				}
				buf.append("&");
			}
			buff = buf.toString();
			if (buff.isEmpty() == false) {
				buff = buff.substring(0, buff.length() - 1);
			}
		} catch (Exception e) {
			return null;
		}
		return buff;
	}

	/**
	 * <b>Title: 生成签名</b>
	 * <p>Description: 注意，若含有sign_type字段，必须和signType参数保持一致。参数值为空，则不参与签名</p>
	 * 
	 * @author H.Yang
	 * 
	 * @param data 待签名数据
	 * @param key API密钥
	 * @param signType 签名方式
	 * @return
	 * @throws Exception
	 */
	public static String generateSignature(final Map<String, String> data, String key, String signType) throws Exception {
		Set<String> keySet = data.keySet();
		String[] keyArray = keySet.toArray(new String[keySet.size()]);
		Arrays.sort(keyArray);
		StringBuilder sb = new StringBuilder();
		for (String k : keyArray) {
			if (k.equals("sign")) {
				continue;
			}
			if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
				sb.append(k).append("=").append(data.get(k).trim()).append("&");
		}
		sb.append("key=").append(key);
		if ("MD5".equals(signType)) {
			return MD5(sb.toString()).toUpperCase();
		} else if ("HMACSHA256".equals(signType)) {
			return HMACSHA256(sb.toString(), key);
		} else {
			throw new Exception(String.format("Invalid sign_type: %s", signType));
		}
	}

	/**
	 * <b>Title: MD5签名</b>
	 * <p>Description: </p>
	 * 
	 * @author H.Yang
	 * 
	 * @param data
	 * @param key
	 * @return
	 */
	public static String sign(Map<String, String> data, String key) {
		try {
			return generateSignature(data, key, "MD5");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * <b>Title: 生成 MD5</b>
	 * <p>Description: </p>
	 * 
	 * @author H.Yang
	 * 
	 * @param data 待处理数据
	 * @return
	 * @throws Exception
	 */
	public static String MD5(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * <b>Title: 生成 HMACSHA256</b>
	 * <p>Description: </p>
	 * 
	 * @author H.Yang
	 * 
	 * @param data 待处理数据
	 * @param key 密钥
	 * @return 加密结果
	 * @throws Exception
	 */
	public static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	public static void main(String[] args) {

	}

}
