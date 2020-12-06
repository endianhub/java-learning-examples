package com.xh.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.security.mapper.SysPermissionMapper;
import com.xh.security.mapper.SysUserMapper;
import com.xh.security.model.SysPermissionEntity;
import com.xh.security.model.SysUserEntity;
import com.xh.security.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author H.Yang
 * @since 2020-12-05
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysPermissionMapper permissionMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity userEntity = userMapper.selectOne(new QueryWrapper<SysUserEntity>().lambda()
                .eq(SysUserEntity::getUserName, username)
        );
        if (userEntity == null) {
            return null;
        }

        // 2.查询对应的用户权限
        List<SysPermissionEntity> listPermission = permissionMapper.listPermissionByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        listPermission.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
        });
        log.info(">>> authorities:{} <<<", authorities);

        // 3.将该权限添加到security
        return new User(userEntity.getUserName(), userEntity.getPassword(), authorities);
    }
}
