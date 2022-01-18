package com.raymon.workrecord.service;

import java.util.Date;
import java.util.List;

import com.raymon.workrecord.entity.WorkLoad;
import com.raymon.workrecord.pojo.WorkLoadForm;
import com.raymon.workrecord.pojo.WorkloadDetails;

public interface WorkLoadService {

	void addWorkLoad(WorkLoad workload);

	void updateWorkLoad(WorkLoad workLoad);

	List<WorkLoad> listWorkLoadByUserIdByTime(WorkLoadForm form);

	void deleteById(String workloadId);

	List<WorkloadDetails> listWorkLoadByTimeByDepartmentId(Date time, String departmentId);

	List<WorkloadDetails> listWorkLoadByDepartmentIdByTimeRange(String departmentId, Date beginTime, Date endTime);

}
