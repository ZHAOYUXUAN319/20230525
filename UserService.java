package com.bilibili.service;

import java.util.Map;

import com.bilibili.entity.User;

public interface UserService {
Boolean verifyUser(User user);

Map<String, String> getUserData(String username);

boolean deleteTableData();

}
