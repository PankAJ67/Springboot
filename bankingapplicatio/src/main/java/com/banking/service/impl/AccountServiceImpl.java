package com.banking.service.impl;

import org.springframework.stereotype.Service;

import com.banking.dto.AccountDto;
import com.banking.entity.Account;
import com.banking.mapper.AccountMapper;
import com.banking.repository.AccountRepository;
import com.banking.service.AccountService;


@Service
public class AccountServiceImpl  implements AccountService{

	
	private AccountRepository accountRepository;
	
	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto); 
	    Account SavedAccount = accountRepository.save(account);
		return  AccountMapper.mapToAccountDto(SavedAccount);
	}

}
