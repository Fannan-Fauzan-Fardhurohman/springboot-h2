package com.fanxan.accounts.controller;

import com.fanxan.accounts.constants.AccountsConstants;
import com.fanxan.accounts.dto.AccountsDto;
import com.fanxan.accounts.dto.CustomerDto;
import com.fanxan.accounts.dto.ResponseDto;
import com.fanxan.accounts.entity.Accounts;
import com.fanxan.accounts.entity.Customer;
import com.fanxan.accounts.exception.ResourceNotFoundException;
import com.fanxan.accounts.mapper.AccountsMapper;
import com.fanxan.accounts.mapper.CustomerMapper;
import com.fanxan.accounts.repository.AccountsRepository;
import com.fanxan.accounts.repository.CustomerRepository;
import com.fanxan.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private final CustomerRepository customerRepository;
    private final AccountsRepository accountsRepository;
    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetail(@RequestParam String mobileNumber) {
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDto);
    }
}
