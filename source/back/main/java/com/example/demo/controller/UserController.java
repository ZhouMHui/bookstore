package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2020-11-24
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:8081")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public Object GETAll(){
        return userService.list();
    }

    @GetMapping("/login")
    public Object login(String username,String password)
    {
        Map<String,Object>map=new HashMap<>();
        List<User> list=userService.list();
        List<User> list2 = new ArrayList();
        for(User c:list){
            if (c.getUsername().equals(username)&&c.getPassword().equals(password))
            {

                Map<String,String>playload=new HashMap<>();
                String token= jwt.getToken(playload);
                map.put("token",token);
                map.put("username",c.getUsername());
                map.put("password",c.getPassword());
                map.put("id",c.getId());
                return map;
            }
        }
        return map;

    }
}

