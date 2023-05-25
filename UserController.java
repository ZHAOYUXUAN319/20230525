package com.bilibili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.entity.ReturnObj;
import com.bilibili.entity.User;
import com.bilibili.service.UserService;
@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public ReturnObj login(@RequestBody JSONObject params) {
    	String username = params.getString("username");
        String password = params.getString("password");
        User user = new User(username, password);
        Boolean result = userService.verifyUser(user);
        
        if (result) {
   
            ReturnObj returnObj = ReturnObj.buildSuccess();
            returnObj.setStatuS(200);
            return returnObj;
        } else {
            return ReturnObj.buildFault();
        }
    }
    @GetMapping("/deleteData")
    @ResponseBody
    public ReturnObj deleteData() {
        // 在这里执行删除数据库表数据的操作
        boolean deleteResult = userService.deleteTableData();

        if (deleteResult) {
            ReturnObj returnObj = ReturnObj.buildSuccess();
            returnObj.setStatus(200);
            return returnObj;
        } else {
            return ReturnObj.buildFault();
        }
    }
    @PostMapping("/deleteBuken")
    @ResponseBody
    public ReturnObj deleteBuken(@RequestBody JSONObject params) {
        String propertyId = params.getString("propertyId");

        try {
            bukenService.deleteBuken(propertyId);
            ReturnObj returnObj = ReturnObj.buildSuccess();
            returnObj.setStatus(200);
            return returnObj;
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnObj.buildFault();
        }
    }
}

