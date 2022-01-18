package com.raymon.workrecord.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
// 部门信息表
@TableName("department")
@Data
public class Department {
	
	@TableId("department_id")
	private Integer departmentId;
	
	@TableField("department_name")
	private String departmentName;

}
