package com.bankapp.service;

import org.springframework.stereotype.Service;

import com.bankapp.dto.AccountDto;
import com.bankapp.entity.Account;
import com.bankapp.mapper.AccountMapper;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}

}
