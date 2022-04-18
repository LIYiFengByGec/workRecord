package com.raymon.workrecord.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raymon.workrecord.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

	List<Account> listWorkAccountByTimeRange(Date beginTime, Date endTime);

}
