package com.xh.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.security.model.SysPermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author H.Yang
 * @since 2020-12-05
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermissionEntity> {

    /**
     * 查询用户的权限
     *
     * @param userName
     * @return
     */
    @Select("SELECT permission.perm_name AS permName, permission.perm_tag AS permTag, permission.url " +
            "FROM sys_user user " +
            "INNER JOIN sys_user_role user_role ON user.id = user_role.user_id " +
            "INNER JOIN sys_role_permission role_permission ON user_role.role_id = role_permission.role_id " +
            "INNER JOIN sys_permission permission ON role_permission.perm_id = permission.id " +
            "WHERE user.user_name = #{userName} ")
    List<SysPermissionEntity> listPermissionByUserName(@Param("userName") String userName);

}
