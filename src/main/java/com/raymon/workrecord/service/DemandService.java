package com.raymon.workrecord.service;

import java.util.Date;
import java.util.List;

import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.pojo.DemandSearchParams;

public interface DemandService {

	void addDemand(Demand demand);

	List<Demand> listDemand(DemandSearchParams params);

	void updateDemandCreateByDemandId(String demandId);

	void updateDemandFinishByDemandId(String demandId);

	void updateDemand(Demand demand);
	
	// 查询一段时间内有工作记录的需求信息
	List<Demand> listDemandByTimeRange(Date beginTime, Date endTime);
	
	// 查询一段时间内某个员工有工作记录的需求信息
	List<Demand> listDemandByTimeRangeByUserId(String userId, Date beginTime, Date endTime);
}
