package com.raymon.workrecord.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raymon.workrecord.dao.DemandMapper;
import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.exception.BusinessException;
import com.raymon.workrecord.pojo.DemandSearchParams;
import com.raymon.workrecord.service.DemandService;

@Service
public class DemandServiceImpl implements DemandService {

	@Autowired
	private DemandMapper demandMapper;
	
	@Override
	public void addDemand(Demand demand) {
		demand.setModifyTime(new Date());
		demand.setSchedule(0);
		demandMapper.insert(demand);
	}

	@Override
	public List<Demand> listDemand(DemandSearchParams params) {
		QueryWrapper<Demand> query = new QueryWrapper<>();
		query.orderByDesc("modify_time");
		if(!StringUtils.isEmpty(params.getDemandName())) 
			query.like("demand_name", params.getDemandName());
		if(params.getIsFinish() != null)
			query.eq("is_finish", params.getIsFinish());
		if(params.getIsCreate() != null)
			query.eq("jira_address", "").or().eq("jira_address", null);
		if(params.getBeginTime()!= null && params.getEndTime() != null)
			query.between("modify_time", params.getBeginTime(), params.getEndTime());
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
		demand.setSchedule(100);
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

	@Override
	public void updateDemand(Demand demand) {
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

	@Override
	public List<Demand> listDemandByTimeRange(Date beginTime, Date endTime) {
		return demandMapper.listDemandByTimeRange(beginTime, endTime);
	}

	@Override
	public List<Demand> listDemandByTimeRangeByUserId(String userId, Date beginTime, Date endTime) {
		return demandMapper.listDemandByTimeRangeByUserId(userId, beginTime, endTime);
	}

	@Override
	public void updateDemandScheduleByDemandId(String demandId, int schedule) {
		Demand demand = demandMapper.selectById(demandId);
		if(demand == null) 
			throw new BusinessException("找不到此需求单！");
		demand.setSchedule(schedule);
		demand.setModifyTime(new Date());
		demandMapper.updateById(demand);
	}

}
