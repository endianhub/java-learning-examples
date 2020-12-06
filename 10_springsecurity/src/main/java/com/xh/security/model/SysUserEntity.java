package com.xh.security.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author H.Yang
 * @since 2020-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("real_name")
    private String realName;

    @TableField("password")
    private String password;

    @TableField("create_date")
    private Date createDate;

    @TableField("last_login_time")
    private Date lastLoginTime;

    @TableField("enabled")
    private Integer enabled;

    @TableField("account_non_expired")
    private Integer accountNonExpired;

    @TableField("account_non_locked")
    private Integer accountNonLocked;

    @TableField("credentials_non_expired")
    private Integer credentialsNonExpired;

}
