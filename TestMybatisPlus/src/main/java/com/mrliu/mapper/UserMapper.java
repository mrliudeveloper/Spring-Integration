package com.mrliu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mrliu.po.User;
@Mapper
public interface UserMapper extends BaseMapper<User>{

}
