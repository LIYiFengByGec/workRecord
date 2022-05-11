package com.raymon.workrecord.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 需求信息表
@TableName("demand")
@Data
public class Demand {
	
	@TableId("demand_id")
	private String demandId;
	
	@TableField("demand_name")
	private String demandName;
	
	@TableField("jira_address")
	private String jiraAddress;
	
	// 是否建单：0未建单、1已建单
	@TableField("is_create")
	private Integer isCreate;
	
	// 是否完成：0未完成、1已完成
	@TableField("is_finish")
	private Integer isFinish;
	
	@TableField("modify_time")
	private Date modifyTime;
	
	@TableField("schedule")
	private Integer schedule;
	
	@TableField("remark")
	private String remark;
}
