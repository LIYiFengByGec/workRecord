package com.raymon.workrecord.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 账号信息表
@TableName("account")
@Data
public class Account {
	
	@TableId("user_id")
	private String userId;
	
	@TableField("username")
	private String username;
	
	@TableField("full_name")
	private String fullName;
	
	@TableField("password")
	private String password;
	
	@TableField("phone_number")
	private String phoneNumber;
	
	@TableField("level")
	private String level;
	
	@TableField("department_id")
	private Integer departmentId;
}
