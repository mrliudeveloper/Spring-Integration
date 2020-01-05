package com.mrliu.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "tbl_user")
public class User {
	@TableId(value = "id",type = IdType.AUTO)
	private Integer idInteger;
	@TableField(value = "name")
	private String nameString;
	@TableField(value = "logic_flag")
	private Integer logicFlagInteger;

	public Integer getIdInteger() {
		return idInteger;
	}

	public void setIdInteger(Integer idInteger) {
		this.idInteger = idInteger;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Integer getLogicFlagInteger() {
		return logicFlagInteger;
	}

	public void setLogicFlagInteger(Integer logicFlagInteger) {
		this.logicFlagInteger = logicFlagInteger;
	}
	
	
}
