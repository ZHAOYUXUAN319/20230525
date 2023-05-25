package com.bilibili.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.bilibili.entity.User;

@Mapper
//dbと関係
public interface UserMapper {
//インタフェースのメソッド（接口的方法）
	User getUser(String username);
	Map<String, String> getUserData(String username);
	List<Map<String, String>> getBuken(String username);
	@Delete("DELETE FROM Property WHERE property_id = #{propertyId}")
    int deleteBuken(String propertyId);
}
