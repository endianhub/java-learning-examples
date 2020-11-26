package com.xh.decorative.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xh.decorative.annotation.ExtCache;
import com.xh.decorative.decorate.impl.RedisDecorate1;
import com.xh.decorative.mapper.UserMapper;
import com.xh.decorative.model.UserDO;
import com.xh.decorative.service.UserService;
import com.xh.decorative.utils.JvmMapCacheUtils;
import com.xh.decorative.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title:
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private RedisDecorate1 redisDecorate1;

    /**
     * 传统写法(在没有二级缓存的场景下)
     *
     * @param userId
     * @return
     */
    @Override
    public UserDO getById(Integer userId) {
        String key = "USER_" + userId;

        // 二级缓存
        UserDO redisEntity = redisUtils.getEntity(key, UserDO.class);
        if (redisEntity != null) {
            return redisEntity;
        }

        // 一级缓存
        UserDO jvmEntity = JvmMapCacheUtils.getEntity(key, UserDO.class);
        if (jvmEntity != null) {
            // 将缓存放入二级缓存中
            redisUtils.putEntity(key, jvmEntity);
            return jvmEntity;
        }

        UserDO userDO = userMapper.selectById(userId);
        if (userDO == null) {
            return null;
        }
        JvmMapCacheUtils.putEntity(key, userDO);
        return userDO;
    }

    /**
     * 对一级缓存增强
     *
     * @param userId
     * @return
     */
    @Override
    public UserDO getById2(Integer userId) {
        return redisDecorate1.getCacheEntity("USER_" + userId);
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    @ExtCache
    public UserDO getById3(Integer userId) {
        return userMapper.selectById(userId);
    }
}
