package com.xh.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/12/4
 */
public class EncoderDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "http://127.0.0.1:8080/toPay?amount=10000&mayikt+meite&sign=99710018ab7d58026b49e37811d53f8d&timestamp=1591106807273";

        String encode = URLEncoder.encode(url, "UTF-8");
        System.out.println(encode);
        String decode = URLDecoder.decode(encode, "UTF-8");
        System.out.println(decode);
    }
}
