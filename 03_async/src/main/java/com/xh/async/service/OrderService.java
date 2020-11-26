package com.xh.async.service;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/24
 */
public interface OrderService {

    String addOrder();

    // 如果当前接口中没有该方法，则不会走代理类（jdk动态代理是基于接口）
    void addOrderLog();
}
