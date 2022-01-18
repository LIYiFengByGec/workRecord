package com.raymon.workrecord.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.raymon.workrecord.entity.Account;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
