package com.raymon.workrecord.pojo;

import java.io.Serializable;
import java.util.List;

import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.entity.WorkLoad;

import lombok.Builder;
import lombok.Data;

/**
 * 自动生成周报信息封装
 * @author LYF
 *
 */
@Data
@Builder
public class WordInfo implements Serializable{

	private static final long serialVersionUID = -1949809860957951190L;

	private String mettingTime;
	
	private String recordPerson;
	
	private List<Demand> demandList;
	
	private List<PersonWorkload> personWorkloadList;
	
	@Data
	public static class PersonWorkload{
		private String fullName;
		
		private List<WorkloadContent> workloadContentList;
	}
	
	@Data
	public static class WorkloadContent{
		private String demandName;
		
		List<WorkLoad> workloadList;
	}
}
