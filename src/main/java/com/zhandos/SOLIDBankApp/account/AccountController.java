package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.BankCore;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountBalanceRequest;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountCreateRequest;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.transaction.Transaction;
import com.zhandos.SOLIDBankApp.transaction.TransactionDeposit;
import com.zhandos.SOLIDBankApp.transaction.TransactionRepository;
import com.zhandos.SOLIDBankApp.transaction.TransactionWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private BankCore bankCore;
    @Autowired
    private AccountListingService accountListing;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionWithdraw transactionWithdraw;
    @Autowired
    private TransactionDeposit transactionDeposit;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountCreateRequest accountCreateRequest) {
        Map<String, Object> responseMessage = new HashMap<>();
        try {
            bankCore.createNewAccount(accountCreateRequest.getAccountType(), "1");
            responseMessage.put("message", "Account successfully created");
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            responseMessage.put("message", "Please enter the correct account type");
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping //()
    public List<Account> getAccounts() {
        return accountListing.getClientAccounts("1");
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable long accountNumber) {
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        String accountID = String.format("%03d%06d", 1, accountNumber);
        Account account = accountListing.getClientAccount("1", accountID);
        if (account!=null) {
            responseMessage.put("message", account);
            httpStatus = HttpStatus.OK;
        } else {
            responseMessage.put("message", "Account was not found");
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable long accountNumber) {
        String accountID = String.format("%03d%06d", 1, accountNumber);
        transactionRepository.deleteTransactionsByAccountID(accountID);
        accountRepository.deleteAccountByAccountID(accountID);
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("message", String.format("Account %s deleted", accountID));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<?> withdrawMoney(@PathVariable("accountNumber") long accountNumber, @RequestBody AccountBalanceRequest accountWithdrawRequest) {
        double amount = accountWithdrawRequest.getAmount();
        String accountID = String.format("%03d%06d", 1, accountNumber);
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            AccountWithdraw account = accountListing.getClientWithdrawAccount("1", accountID);
            transactionWithdraw.execute(account, amount);
            responseMessage.put("message", String.format("%.2f tenge was withdrawn from account %s", amount, accountID));
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            responseMessage.put("message", "Error, impossible to withdraw");
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<?> depositMoney(@PathVariable("accountNumber") long accountNumber, @RequestBody AccountBalanceRequest accountDepositRequest) {
        double amount = accountDepositRequest.getAmount();
        String accountID = String.format("%03d%06d", 1, accountNumber);
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            Account account = accountListing.getClientAccount("1", accountID);
            transactionDeposit.execute(account, amount);
            responseMessage.put("message", String.format("%.2f tenge was deposited to account %s", amount, accountID));
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            responseMessage.put("message", "Error, impossible to deposit");
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @GetMapping("/{accountNumber}/transactions")
    public List<Transaction> getTransactions(@PathVariable long accountNumber) {
        String accountID = String.format("%03d%06d", 1, accountNumber);
        return transactionRepository.findTransactionsByAccountID(accountID);
    }
}