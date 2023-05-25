package com.bilibili.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilibili.dao.UserMapper;
import com.bilibili.entity.User;
import com.bilibili.service.UserService;
@Service
public class UserServiceImpl implements UserService{
@Autowired
private UserMapper userMapper;
	@Override
	public Boolean verifyUser(User user) {
		// TODO Auto-generated method stub
		// 验证用户
		String username = user.getUsername();
		String password = user.getPassword();
		User user2 = userMapper.getUser(username);
		if(user2 == null) {
			return false;
		}else if(password.equals(user2.getPassword())){
			return true;
		}else {
			return null;
		}

	}
	@Override
    public Map<String, String> getUserData(String username) {
        return userMapper.getUserData(username);
    }
	@Override
    
	public void deleteBuken(String propertyId) {
        try {
            int affectedRows = bukenMapper.deleteBuken(propertyId);
            
            if (affectedRows > 0) {
                System.out.println("成功");
            } else {

                System.out.println("失败");
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
