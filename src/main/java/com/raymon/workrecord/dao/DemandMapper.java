package com.raymon.workrecord.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raymon.workrecord.entity.Demand;

@Mapper
public interface DemandMapper extends BaseMapper<Demand> {

	List<Demand> listDemandByTimeRange(Date beginTime, Date endTime);

	List<Demand> listDemandByTimeRangeByUserId(String userId, Date beginTime, Date endTime);

}
