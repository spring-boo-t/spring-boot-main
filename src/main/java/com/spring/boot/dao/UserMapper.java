/**
 * Copyright (c) Windliven 2016 All Rights Reserved
 *
 * @author liyj
 * @date 2017年7月11日 下午6:24:35
 * @since V1.0.0
 */
package com.spring.boot.dao;

import java.util.List;
import com.spring.boot.entity.UserEntity;

/**
 * TODO
 *
 * @author liyj
 * @date 2017年7月11日 下午6:24:35
 *
 */
//@Configuration
public interface UserMapper {
    
    public void insertOne(UserEntity entity);
    
    public void delete(UserEntity entity);
    
    public void update(UserEntity entity);
    
    public UserEntity getOne(UserEntity entity);
    
    public List<UserEntity> getList();
}
