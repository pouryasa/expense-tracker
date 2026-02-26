package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.AccountRequest;
import com.financial.expensetracker.dto.response.AccountResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.Account;
import com.financial.expensetracker.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Account createAccount(AccountRequest accountRequest) {
        return Account.builder()
                .name(accountRequest.getName())
                .type(accountRequest.getType())
                .balance(accountRequest.getBalance())
                .build();
    }

    @Override
    public AccountResponse save(AccountRequest accountRequest) {

        Optional<Account> thisName = accountRepository.findByName(accountRequest.getName());

        if (thisName.isPresent()) {
            throw new RuleException("account.is.exist");
        } else {
            return createAccountResponse(accountRepository.save(createAccount(accountRequest)));
        }
    }

    private AccountResponse createAccountResponse(Account thisAccount) {
        return AccountResponse.builder()
                .accountId(thisAccount.getAccountId())
                .name(thisAccount.getName())
                .balance(thisAccount.getBalance())
                .type(thisAccount.getType())
                .build();
    }

}
