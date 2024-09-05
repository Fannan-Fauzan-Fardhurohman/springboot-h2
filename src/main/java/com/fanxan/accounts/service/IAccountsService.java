package com.fanxan.accounts.service;

import com.fanxan.accounts.dto.CustomerDto;

public interface IAccountsService {



    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
}
