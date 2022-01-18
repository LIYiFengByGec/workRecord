package com.raymon.workrecord.service;

import java.util.List;

import com.raymon.workrecord.entity.Demand;

public interface DemandService {

	void addDemand(Demand demand);

	List<Demand> listDemand();

	void updateDemandCreateByDemandId(String demandId);

	void updateDemandFinishByDemandId(String demandId);

	void updateDemand(Demand demand);

}
