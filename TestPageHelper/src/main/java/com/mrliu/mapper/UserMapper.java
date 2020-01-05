package com.mrliu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mrliu.po.User;
@Mapper
public interface UserMapper {
	
	@Select("select * from tbl_user")
	public List<User> selectAll();

}
