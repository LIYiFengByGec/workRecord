package com.raymon.workrecord.pojo;

import lombok.Data;

@Data
public class WorkloadDetails {
	private String userId;
	private String fullName;
	private String demandId;
	private String demandName;
	private String workContent;
	private Double workTime;
	private Integer isCreate;
}
