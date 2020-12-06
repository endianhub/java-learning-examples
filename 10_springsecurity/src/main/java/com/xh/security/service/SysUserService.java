package com.xh.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xh.security.model.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author H.Yang
 * @since 2020-12-05
 */
public interface SysUserService extends IService<SysUserEntity>, UserDetailsService {

}
