package com.xh.security.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("sys_role_permission")
public class SysRolePermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("role_id")
    private Integer roleId;

    @TableField("perm_id")
    private Integer permId;


}
