package com.xh.decorative.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserDO {

    private Integer id;
    private String name;
}
