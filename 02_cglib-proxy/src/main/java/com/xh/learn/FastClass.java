package com.xh.learn;


import com.xh.learn.service.impl.MemberServiceImpl;

/**
 * cglib 中的 fastclass 源码
 */
public class FastClass {
    /**
     * 方法的索引
     *
     * @param index
     * @param obj
     * @param args
     * @return
     */
    public static Object invoke(int index, Object obj, Object[] args) {
        MemberServiceImpl memberService = (MemberServiceImpl) obj;
        switch (index) {
            case 1:
                memberService.addMember(String.valueOf(args[0]));
        }
        return null;
    }

    /**
     * 签名 方法名称+参数类型
     *
     * @param sign
     * @return
     */
    public static int getIndex(String sign) {
        switch (sign.hashCode()) {
            case 2019430652:
                return 1;
            case 56807949:
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        String name = "addUser(String)";
//        System.out.println(name.hashCode());
        Object result = invoke(getIndex(name), new MemberServiceImpl(), new Object[]{10});
        System.out.println(result);
    }


}
