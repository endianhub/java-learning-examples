//package com.xh.security.service.test;
//
//import com.alibaba.fastjson.JSON;
//import com.xh.security.mapper.SysPermissionMapper;
//import com.xh.security.model.SysPermissionEntity;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
///**
// * Title:
// * Description:
// *
// * @author H.Yang
// * @date 2020/12/5
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SysPermissionServiceTest {
//
//    @Autowired
//    private SysPermissionMapper permissionMapper;
//
//    @Test
//    public void loadUserByUsername() {
//        String userName = "mayikt_admin";
//        List<SysPermissionEntity> listPermission = permissionMapper.listPermissionByUserName(userName);
//        System.out.println(JSON.toJSONString(listPermission));
//    }
//}
