package com.raymon.workrecord.service;

import com.raymon.workrecord.entity.Account;
import com.raymon.workrecord.pojo.LoginForm;

public interface AccountService {

	Account userRegister(Account account);

	Account login(LoginForm form);

}
