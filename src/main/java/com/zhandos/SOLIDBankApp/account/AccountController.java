package com.zhandos.SOLIDBankApp.account;

import com.zhandos.SOLIDBankApp.BankCore;
import com.zhandos.SOLIDBankApp.account.accountTypes.AccountWithdraw;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountCreateRequest;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountDepositRequest;
import com.zhandos.SOLIDBankApp.accountHttpRequests.AccountWithdrawRequest;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import com.zhandos.SOLIDBankApp.transaction.Transaction;
import com.zhandos.SOLIDBankApp.transaction.TransactionDeposit;
import com.zhandos.SOLIDBankApp.transaction.TransactionRepository;
import com.zhandos.SOLIDBankApp.transaction.TransactionWithdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
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
    private AccountDepositService accountDeposit;
    @Autowired
    private AccountWithdrawService accountWithdraw;
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
            responseMessage.put("message", String.format("Account successfully created"));
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            responseMessage.put("message", String.format("Please enter the correct account type"));
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping //()
    public List<Account> getAccounts() {
        return accountListing.getClientAccounts("1");
    }

    @GetMapping("/{accountID}")
    public ResponseEntity<?> getAccount(@PathVariable long accountID) {
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        Account account = accountListing.getClientAccount("1", accountID);
        if (account!=null) {
            responseMessage.put("message", account);
            httpStatus = HttpStatus.OK;
        } else {
            responseMessage.put("message", String.format("Account was not found"));
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @DeleteMapping("/{accountID}")
    public ResponseEntity<?> deleteAccount(@PathVariable long accountID) {
        transactionRepository.deleteTransactionsByAccountID(accountID);
        accountRepository.deleteAccountByAccountID(accountID);
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("message", String.format("Account %d deleted", accountID));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/{accountID}/withdraw")
    public ResponseEntity<?> withdrawMoney(@RequestBody AccountWithdrawRequest accountWithdrawRequest) {
        double amount = accountWithdrawRequest.getAmount();
        long accountID = accountWithdrawRequest.getAccountID();
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            AccountWithdraw account = accountListing.getClientWithdrawAccount("1", accountID);
            transactionWithdraw.execute(account, amount);
            responseMessage.put("message", String.format("%.2f tenge was withdrawn from account %d", amount, accountID));
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            responseMessage.put("message", String.format("Error, impossible to withdraw", amount, accountID));
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @PostMapping("/{accountID}/deposit")
    public ResponseEntity<?> depositMoney(@RequestBody AccountDepositRequest accountDepositRequest) {
        double amount = accountDepositRequest.getAmount();
        long accountID = accountDepositRequest.getAccountID();
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            Account account = accountListing.getClientAccount("1", accountID);
            transactionDeposit.execute(account, amount);
            responseMessage.put("message", String.format("%.2f tenge was deposited to account %d", amount, accountID));
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            responseMessage.put("message", String.format("Error, impossible to deposit", amount, accountID));
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

    @GetMapping("/{accountID}/transactions")
    public List<Transaction> getTransactions(@PathVariable long accountID) {
        return transactionRepository.findTransactionsByAccountID(accountID);
    }
}
