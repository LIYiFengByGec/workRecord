package com.raymon.workrecord.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class WorkLoadForm {
	
	private Date searchTime;

	private Date beginTime;
	
	private Date endTime;
	
	private Integer pageSize;
	
	private Integer currentPage;
	
	private String userId;
	
	private String fullName;
	
	private String departmentId;
	
	private String demandId;
}
