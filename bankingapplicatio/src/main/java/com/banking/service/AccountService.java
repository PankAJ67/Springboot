package com.banking.service;



import org.springframework.stereotype.Service;

import com.banking.dto.AccountDto;



@Service
public interface  AccountService {
	
	AccountDto createAccount(AccountDto account);

}
