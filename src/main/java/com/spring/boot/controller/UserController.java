/**
 * Copyright (c) Windliven 2016 All Rights Reserved
 *
 * @author liyj
 * @date 2017年7月11日 下午6:08:00
 * @since V1.0.0
 */
package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.boot.entity.UserEntity;
import com.spring.boot.inter.service.UserService;

/**
 * TODO
 *
 * @author liyj
 * @date 2017年7月11日 下午6:08:00
 *
 */
//@SpringBootApplication(scanBasePackages = {"com.spring.boot"})
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String sayHello() {
        return "hello spring boot";
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId("111");
        userEntity.setName("liyj");
        userEntity.setPass("123456");
        userEntity.setEmail("704603154@qq.com");
        userEntity.setIphone("18211140412");
        userService.insert(userEntity);
        return "success";
    }
    
    @RequestMapping(value = "/one/get", method = RequestMethod.GET)
    public UserEntity getOne(@RequestParam String id) {
        return userService.getOne(id);
    }
}
