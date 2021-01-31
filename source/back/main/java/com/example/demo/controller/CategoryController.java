package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CategoryService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2020-11-21
 */
@RestController
@RequestMapping("/category")
@CrossOrigin(origins="http://localhost:8081")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public Object all() {
        return categoryService.list();
    }
}

