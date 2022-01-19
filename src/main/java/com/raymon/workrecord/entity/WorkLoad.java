package com.raymon.workrecord.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

// 工作记录表
@TableName("workload")
@Data
public class WorkLoad {
	
	@TableId("workload_id")
	private String workloadId;
	
	@TableField("demand_id")
	private String demandId;
	
	@TableField("work_content")
	private String workContent;
	
	// 工作时长
	@TableField("work_time")
	private Double workTime;
	
	@TableField("user_id")
	private String userId;
	
	// 工作日期
	@TableField("work_date")
	private Date workDate;
	
	@TableField(exist=false)
	private String demandName;
	
}
