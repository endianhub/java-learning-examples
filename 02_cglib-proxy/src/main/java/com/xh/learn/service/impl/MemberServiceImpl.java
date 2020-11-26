package com.xh.learn.service.impl;

import com.xh.learn.service.MemberService;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/20
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public String addMember(String userName) {
        System.out.println("...目标方法....");
        return "cglib:"+userName;
    }
}
