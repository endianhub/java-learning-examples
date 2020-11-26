package com.xh.learn.service.impl;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.reflect.FastClass;

import java.lang.reflect.InvocationTargetException;
// 代理对象
/* compiled from: <generated> */
public class MemberServiceImpl$$EnhancerByCGLIB$$FastClassByCGLIB extends FastClass {
    public MemberServiceImpl$$EnhancerByCGLIB$$FastClassByCGLIB(Class cls) {
        super(cls);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:786)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:130)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:696)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:825)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:130)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:88)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:50)
        */
    @Override
    public int getIndex(java.lang.String r5, java.lang.Class[] r6) {
        /*
        // Method dump skipped, instructions count: 776
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xh.learn.service.impl.MemberServiceImpl$$EnhancerByCGLIB$$FastClassByCGLIB.getIndex(java.lang.String, java.lang.Class[]):int");
    }

    @Override
    public int getIndex(Signature signature) {
        String obj = signature.toString();
        switch (obj.hashCode()) {
            case -2055565910:
                if (obj.equals("CGLIB$SET_THREAD_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 9;
                }
                break;
            case -1882565338:
                if (obj.equals("CGLIB$equals$1(Ljava/lang/Object;)Z")) {
                    return 16;
                }
                break;
            case -1457535688:
                if (obj.equals("CGLIB$STATICHOOK1()V")) {
                    return 14;
                }
                break;
            case -1411842725:
                if (obj.equals("CGLIB$hashCode$3()I")) {
                    return 19;
                }
                break;
            case -1362541243:
                if (obj.equals("CGLIB$addMember$0(Ljava/lang/String;)Ljava/lang/String;")) {
                    return 15;
                }
                break;
            case -894172689:
                if (obj.equals("newInstance(Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 5;
                }
                break;
            case -623122092:
                if (obj.equals("CGLIB$findMethodProxy(Lnet/sf/cglib/core/Signature;)Lnet/sf/cglib/proxy/MethodProxy;")) {
                    return 20;
                }
                break;
            case -508378822:
                if (obj.equals("clone()Ljava/lang/Object;")) {
                    return 3;
                }
                break;
            case -419626537:
                if (obj.equals("setCallbacks([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 10;
                }
                break;
            case 560567118:
                if (obj.equals("setCallback(ILnet/sf/cglib/proxy/Callback;)V")) {
                    return 7;
                }
                break;
            case 811063227:
                if (obj.equals("newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 6;
                }
                break;
            case 919144156:
                if (obj.equals("addMember(Ljava/lang/String;)Ljava/lang/String;")) {
                    return 8;
                }
                break;
            case 973717575:
                if (obj.equals("getCallbacks()[Lnet/sf/cglib/proxy/Callback;")) {
                    return 13;
                }
                break;
            case 1221173700:
                if (obj.equals("newInstance([Lnet/sf/cglib/proxy/Callback;)Ljava/lang/Object;")) {
                    return 4;
                }
                break;
            case 1230699260:
                if (obj.equals("getCallback(I)Lnet/sf/cglib/proxy/Callback;")) {
                    return 12;
                }
                break;
            case 1306468936:
                if (obj.equals("CGLIB$toString$2()Ljava/lang/String;")) {
                    return 17;
                }
                break;
            case 1584330438:
                if (obj.equals("CGLIB$SET_STATIC_CALLBACKS([Lnet/sf/cglib/proxy/Callback;)V")) {
                    return 11;
                }
                break;
            case 1800494055:
                if (obj.equals("CGLIB$clone$4()Ljava/lang/Object;")) {
                    return 18;
                }
                break;
            case 1826985398:
                if (obj.equals("equals(Ljava/lang/Object;)Z")) {
                    return 0;
                }
                break;
            case 1913648695:
                if (obj.equals("toString()Ljava/lang/String;")) {
                    return 1;
                }
                break;
            case 1984935277:
                if (obj.equals("hashCode()I")) {
                    return 2;
                }
                break;
        }
        return -1;
    }

    @Override
    public int getIndex(Class[] clsArr) {
        switch (clsArr.length) {
            case 0:
                return 0;
            default:
                return -1;
        }
    }

    @Override
    public int getMaxIndex() {
        return 20;
    }

    @Override
    public Object invoke(int i, Object obj, Object[] objArr) throws InvocationTargetException {
        MemberServiceImpl$$EnhancerByCGLIB memberServiceImpl$$EnhancerByCGLIB = (MemberServiceImpl$$EnhancerByCGLIB) obj;
        switch (i) {
            case 0:
                try {
                    return new Boolean(memberServiceImpl$$EnhancerByCGLIB.equals(objArr[0]));
                } catch (Throwable th) {
                    throw new InvocationTargetException(th);
                }
            case 1:
                return memberServiceImpl$$EnhancerByCGLIB.toString();
            case 2:
                return new Integer(memberServiceImpl$$EnhancerByCGLIB.hashCode());
            case 3:
                try {
                    return memberServiceImpl$$EnhancerByCGLIB.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            case 4:
                return memberServiceImpl$$EnhancerByCGLIB.newInstance((Callback[]) objArr[0]);
            case 5:
                return memberServiceImpl$$EnhancerByCGLIB.newInstance((Callback) objArr[0]);
            case 6:
                return memberServiceImpl$$EnhancerByCGLIB.newInstance((Class[]) objArr[0], (Object[]) objArr[1], (Callback[]) objArr[2]);
            case 7:
                memberServiceImpl$$EnhancerByCGLIB.setCallback(((Number) objArr[0]).intValue(), (Callback) objArr[1]);
                return null;
            case 8:
                return memberServiceImpl$$EnhancerByCGLIB.addMember((String) objArr[0]);
            case 9:
                MemberServiceImpl$$EnhancerByCGLIB.CGLIB$SET_THREAD_CALLBACKS((Callback[]) objArr[0]);
                return null;
            case 10:
                memberServiceImpl$$EnhancerByCGLIB.setCallbacks((Callback[]) objArr[0]);
                return null;
            case 11:
                MemberServiceImpl$$EnhancerByCGLIB.CGLIB$SET_STATIC_CALLBACKS((Callback[]) objArr[0]);
                return null;
            case 12:
                return memberServiceImpl$$EnhancerByCGLIB.getCallback(((Number) objArr[0]).intValue());
            case 13:
                return memberServiceImpl$$EnhancerByCGLIB.getCallbacks();
            case 14:
                try {
                    MemberServiceImpl$$EnhancerByCGLIB.CGLIB$STATICHOOK1();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return null;
            case 15:
                return memberServiceImpl$$EnhancerByCGLIB.CGLIB$addMember$0((String) objArr[0]);
            case 16:
                return new Boolean(memberServiceImpl$$EnhancerByCGLIB.CGLIB$equals$1(objArr[0]));
            case 17:
                return memberServiceImpl$$EnhancerByCGLIB.CGLIB$toString$2();
            case 18:
                try {
                    return memberServiceImpl$$EnhancerByCGLIB.CGLIB$clone$4();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            case 19:
                return new Integer(memberServiceImpl$$EnhancerByCGLIB.CGLIB$hashCode$3());
            case 20:
                return MemberServiceImpl$$EnhancerByCGLIB.CGLIB$findMethodProxy((Signature) objArr[0]);
            default:
                throw new IllegalArgumentException("Cannot find matching method/constructor");
        }
    }

    @Override
    public Object newInstance(int i, Object[] objArr) throws InvocationTargetException {
        switch (i) {
            case 0:
                try {
                    return new MemberServiceImpl$$EnhancerByCGLIB();
                } catch (Throwable th) {
                    throw new InvocationTargetException(th);
                }
            default:
                throw new IllegalArgumentException("Cannot find matching method/constructor");
        }
    }
}