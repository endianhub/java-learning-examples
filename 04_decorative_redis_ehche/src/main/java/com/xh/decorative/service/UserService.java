package com.xh.decorative.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xh.decorative.model.UserDO;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
public interface UserService extends IService<UserDO> {

    UserDO getById(Integer userId);

    UserDO getById2(Integer userId);

    UserDO getById3(Integer userId);
}
