package com.raymon.workrecord.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raymon.workrecord.dao.WorkLoadMapper;
import com.raymon.workrecord.entity.WorkLoad;
import com.raymon.workrecord.pojo.WorkLoadForm;
import com.raymon.workrecord.pojo.WorkloadDetails;
import com.raymon.workrecord.service.WorkLoadService;

@Service
public class WorkLoadServiceImpl implements WorkLoadService {

	@Autowired
	private WorkLoadMapper workLoadMapper;
	
	@Override
	public void addWorkLoad(WorkLoad workload) {
		workLoadMapper.insert(workload);
	}

	@Override
	public void updateWorkLoad(WorkLoad workLoad) {
		workLoadMapper.updateById(workLoad);
	}

	@Override
	public List<WorkLoad> listWorkLoadByUserIdByTime(WorkLoadForm form) {
		return workLoadMapper.listWorkLoadByUserIdByTime(form.getUserId(), form.getSearchTime());
	}

	@Override
	public void deleteById(String workloadId) {
		workLoadMapper.deleteById(workloadId);
	}

	@Override
	public List<WorkloadDetails> listWorkLoadByTimeByDepartmentId(Date time, String departmentId) {
		return workLoadMapper.listWorkLoadByTimeByDepartmentId(time, departmentId);
	}

	@Override
	public List<WorkloadDetails> listWorkLoadByDepartmentIdByTimeRange(String departmentId, Date beginTime,
			Date endTime) {
		return workLoadMapper.listWorkLoadByDepartmentIdByTimeRange(departmentId, beginTime, endTime);
	}

}
