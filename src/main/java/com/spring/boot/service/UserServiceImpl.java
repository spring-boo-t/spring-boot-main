/**
 * Copyright (c) Windliven 2016 All Rights Reserved
 *
 * @author liyj
 * @date 2017年7月11日 下午4:18:55
 * @since V1.0.0
 */
package com.spring.boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.boot.dao.UserMapper;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.inter.service.UserService;

/**
 * TODO
 *
 * @author liyj
 * @date 2017年7月11日 下午4:18:55
 *
 */
@Transactional(readOnly=false)
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    /*
     * @see com.spring.boot.inter.service.UserService#insert(com.spring.boot.entity.UserEntity)
     */
    public void insert(UserEntity entity) {
        userMapper.insertOne(entity);
        System.out.println("insert");
    }

    /*
     * @see com.spring.boot.inter.service.UserService#deleteEntity(com.spring.boot.entity.UserEntity)
     */
    public void deleteEntity(UserEntity entity) {
        userMapper.delete(entity);
        System.out.println("deleteEntity");
    }

    /*
     * @see com.spring.boot.inter.service.UserService#deleteById(java.lang.String)
     */
    public void deleteById(String id) {
        userMapper.delete(new UserEntity(id));
        System.out.println("deleteById");
    }

    /*
     * @see com.spring.boot.inter.service.UserService#updateEntity(com.spring.boot.entity.UserEntity)
     */
    public void updateEntity(UserEntity entity) {
        userMapper.update(entity);
        System.out.println("updateEntity");
    }

    /*
     * @see com.spring.boot.inter.service.UserService#updateById(java.lang.String)
     */
    public void updateById(String id) {
        userMapper.update(new UserEntity(id));
        System.out.println("updateById");
    }

    /*
     * @see com.spring.boot.inter.service.UserService#getOne(java.lang.String)
     */
    @Transactional(readOnly=true)
    public UserEntity getOne(String id) {
        return userMapper.getOne(new UserEntity(id));
    }

    /*
     * @see com.spring.boot.inter.service.UserService#getList()
     */
    @Transactional(readOnly=true)
    public List<UserEntity> getList() {
        return userMapper.getList();
    }
}
