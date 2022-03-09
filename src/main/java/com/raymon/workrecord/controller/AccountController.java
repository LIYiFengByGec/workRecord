package com.raymon.workrecord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raymon.workrecord.common.R;
import com.raymon.workrecord.entity.Account;
import com.raymon.workrecord.pojo.LoginForm;
import com.raymon.workrecord.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	// 注册
	@PostMapping("/register")
	public R userRegister(@RequestBody Account account) {
		accountService.userRegister(account);
		return R.ok();
	}
	
	// 登录
	@PostMapping("/login")
	public R login (@RequestBody LoginForm form) {
		Account account = accountService.login(form);
		return R.ok().put(account);
	}
	
	
}
