package com.raymon.workrecord.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raymon.workrecord.dao.AccountMapper;
import com.raymon.workrecord.entity.Account;
import com.raymon.workrecord.exception.BusinessException;
import com.raymon.workrecord.pojo.LoginForm;
import com.raymon.workrecord.service.AccountService;
import com.raymon.workrecord.utils.EncryptAesUtil;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public Account userRegister(Account account) {
		String username = account.getUsername();
		QueryWrapper<Account> query = new QueryWrapper<>();
		query.eq("username", username);
		Integer integer = accountMapper.selectCount(query);
		if(integer <= 0) {
			account.setPassword(EncryptAesUtil.aesEncrypt(account.getPhoneNumber()));
			accountMapper.insert(account);
		}else {
			throw new BusinessException("该用户已存在");
		}
		return account;
	}

	@Override
	public Account login(LoginForm form) {
		QueryWrapper<Account> query = new QueryWrapper<>();
		query.eq("username", form.getUsername());
		Account account = accountMapper.selectOne(query);
		if(account == null) {
			throw new BusinessException("用户名不存在");
		}else if(!account.getPassword().equals(EncryptAesUtil.aesEncrypt(form.getPassword()))){
			throw new BusinessException("密码错误");
		}else {
			return account;
		}
	}

	@Override
	public List<Account> listWorkAccountByTimeRange(Date beginTime, Date endTime) {
		return accountMapper.listWorkAccountByTimeRange(beginTime, endTime);
	}
	
}
