package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.BankCore;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountCreateRequest;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private BankCore bankCore;
    @Autowired
    private AccountListingService accountListing;
    @Autowired
    private AccountDepositService accountDeposit;
    @Autowired
    private AccountWithdrawService accountWithdraw;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public void createAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        bankCore.createNewAccount(accountCreateRequest.getAccountType(), "1");
    }

    @GetMapping //()
    public List<Account> getAccounts() {
        return accountListing.getClientAccounts("1");
    }

    @GetMapping("/{accountID}")
    public Account getAccount(@PathVariable long accountID) {
        return accountListing.getClientAccount("1", accountID);
    }

    @DeleteMapping("/{accountID}")
    public void deleteAccount(@PathVariable long accountID) {
        accountRepository.deleteAccountById(accountID);
    }
}
