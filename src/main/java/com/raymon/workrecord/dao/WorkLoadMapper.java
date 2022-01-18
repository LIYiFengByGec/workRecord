package com.raymon.workrecord.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raymon.workrecord.entity.WorkLoad;
import com.raymon.workrecord.pojo.WorkloadDetails;

@Mapper
public interface WorkLoadMapper extends BaseMapper<WorkLoad>{

	List<WorkLoad> listWorkLoadByUserIdByTime(String userId, Date searchTime);
	
	List<WorkloadDetails> listWorkLoadByTimeByDepartmentId(Date searchTime, String departmentId);

	List<WorkloadDetails> listWorkLoadByDepartmentIdByTimeRange(String departmentId, Date beginTime, Date endTime);
}
