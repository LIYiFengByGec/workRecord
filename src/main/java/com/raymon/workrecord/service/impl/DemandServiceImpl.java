package com.raymon.workrecord.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raymon.workrecord.dao.DemandMapper;
import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.exception.BusinessException;
import com.raymon.workrecord.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService {

	@Autowired
	private DemandMapper demandMapper;
	
	@Override
	public void addDemand(Demand demand) {
		demand.setModifyTime(new Date());
		demandMapper.insert(demand);
	}

	@Override
	public List<Demand> listDemand() {
		QueryWrapper<Demand> query = new QueryWrapper<>();
		query.orderByDesc("modify_time");
		return demandMapper.selectList(query);
	}

	@Override
	public void updateDemandCreateByDemandId(String demandId) {
		Demand demand = demandMapper.selectById(demandId);
		if(demand == null) 
			throw new BusinessException("找不到此需求单！");
		int isCreate = demand.getIsCreate() == 1 ? 0 : 1;
		demand.setIsCreate(isCreate);
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

	@Override
	public void updateDemandFinishByDemandId(String demandId) {
		Demand demand = demandMapper.selectById(demandId);
		if(demand == null) 
			throw new BusinessException("找不到此需求单！");
		int isFinish = demand.getIsFinish() == 1 ? 0 : 1;
		demand.setIsFinish(isFinish);
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

	@Override
	public void updateDemand(Demand demand) {
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

}
