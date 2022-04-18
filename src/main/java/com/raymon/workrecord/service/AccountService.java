package com.raymon.workrecord.service;

import java.util.Date;
import java.util.List;

import com.raymon.workrecord.entity.Account;
import com.raymon.workrecord.pojo.LoginForm;

public interface AccountService {

	Account userRegister(Account account);

	Account login(LoginForm form);

	// 查询一段时间内有工作记录的员工
	List<Account> listWorkAccountByTimeRange(Date beginTime, Date endTime);
}
