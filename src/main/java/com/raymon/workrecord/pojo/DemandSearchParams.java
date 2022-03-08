package com.raymon.workrecord.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class DemandSearchParams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String demandId;
	
	private String demandName;
	
	private Integer pageSize;
	
	private Integer pageNo;
	
	private Integer isFinish;
	
	private Integer isCreate;
	
	private Date beginTime;
	
	private Date endTime;

}
