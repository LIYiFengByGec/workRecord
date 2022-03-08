package com.raymon.workrecord.service;

import java.util.List;

import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.pojo.DemandSearchParams;

public interface DemandService {

	void addDemand(Demand demand);

	List<Demand> listDemand(DemandSearchParams params);

	void updateDemandCreateByDemandId(String demandId);

	void updateDemandFinishByDemandId(String demandId);

	void updateDemand(Demand demand);

}
