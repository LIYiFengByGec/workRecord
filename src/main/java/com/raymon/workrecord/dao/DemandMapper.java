package com.raymon.workrecord.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raymon.workrecord.entity.Demand;

@Mapper
public interface DemandMapper extends BaseMapper<Demand> {

}
