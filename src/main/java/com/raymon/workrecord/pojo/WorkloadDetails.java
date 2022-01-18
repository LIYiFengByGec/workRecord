package com.raymon.workrecord.pojo;

import lombok.Data;

@Data
public class WorkloadDetails {
	private String fullName;
	private String demandName;
	private String workContent;
	private Integer workTime;
	private Integer isCreate;
}
