package com.fanxan.accounts.mapper;

import com.fanxan.accounts.dto.AccountsDto;
import com.fanxan.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto){
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts){
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accounts.getBranchAddress());
        return accounts;
    }
}
