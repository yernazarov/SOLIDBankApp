package com.zhandos.SOLIDBankApp.controllers;

import com.zhandos.SOLIDBankApp.services.BankCore;
import com.zhandos.SOLIDBankApp.repositories.AccountRepository;
import com.zhandos.SOLIDBankApp.entities.AccountWithdraw;
import com.zhandos.SOLIDBankApp.dto.AccountBalanceRequest;
import com.zhandos.SOLIDBankApp.dto.AccountCreateRequest;
import com.zhandos.SOLIDBankApp.dto.AccountTransferRequest;
import com.zhandos.SOLIDBankApp.entities.Account;
import com.zhandos.SOLIDBankApp.services.AccountListingService;
import com.zhandos.SOLIDBankApp.configs.jwt.JwtProvider;
import com.zhandos.SOLIDBankApp.entities.Transaction;
import com.zhandos.SOLIDBankApp.services.TransactionDeposit;
import com.zhandos.SOLIDBankApp.repositories.TransactionRepository;
import com.zhandos.SOLIDBankApp.services.TransactionWithdraw;
import com.zhandos.SOLIDBankApp.entities.User;
import com.zhandos.SOLIDBankApp.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.*;

@RestController
@SecurityRequirement(name = "jwtauth")
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
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping
    public ResponseEntity<?> createAccount(HttpServletRequest request, @RequestBody AccountCreateRequest accountCreateRequest) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        Map<String, Object> responseMessage = new HashMap<>();
        try {
            User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
            bankCore.createNewAccount(accountCreateRequest.getAccountType(), client.getUserID());
            responseMessage.put("message", "Account successfully created");
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } catch (Exception e) {
            responseMessage.put("message", "Please enter the correct account type");
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping //()
    public List<Account> getAccounts(HttpServletRequest request) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        return accountListing.getClientAccounts(client.getUserID());
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<?> getAccount(HttpServletRequest request, @PathVariable long accountNumber) {
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String accountID = String.format("%03d%06d", client.getUserID(), accountNumber);
        Account account = accountListing.getClientAccount(client.getUserID(), accountID);
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
    public ResponseEntity<?> deleteAccount(HttpServletRequest request, @PathVariable long accountNumber) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String accountID = String.format("%03d%06d", client.getUserID(), accountNumber);
        transactionRepository.deleteTransactionsByAccountID(accountID);
        accountRepository.deleteAccountByAccountID(accountID);
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("message", String.format("Account %s deleted", accountID));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<?> withdrawMoney(HttpServletRequest request, @PathVariable("accountNumber") long accountNumber, @RequestBody AccountBalanceRequest accountWithdrawRequest) {
        double amount = accountWithdrawRequest.getAmount();
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String accountID = String.format("%03d%06d", client.getUserID(), accountNumber);
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            AccountWithdraw account = accountListing.getClientWithdrawAccount(client.getUserID(), accountID);
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
    public ResponseEntity<?> depositMoney(HttpServletRequest request, @PathVariable("accountNumber") long accountNumber, @RequestBody AccountBalanceRequest accountDepositRequest) {
        double amount = accountDepositRequest.getAmount();
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String accountID = String.format("%03d%06d", client.getUserID(), accountNumber);
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            Account account = accountListing.getClientAccount(client.getUserID(), accountID);
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
    public List<Transaction> getTransactions(HttpServletRequest request, @PathVariable long accountNumber) {
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String accountID = String.format("%03d%06d", client.getUserID(), accountNumber);
        return transactionRepository.findTransactionsByAccountID(accountID);
    }

    @PostMapping("/{accountNumber}/transfer")
    public ResponseEntity<?> transferMoney(HttpServletRequest request, @PathVariable("accountNumber") long accountNumber, @RequestBody AccountTransferRequest accountTransferRequest) {
        String destinationID = accountTransferRequest.getDestination_account_id();
        double amount = accountTransferRequest.getAmount();
        String token = request.getHeader("Authorization").replace("Bearer ", "");
        User client = userService.findByUsername(jwtProvider.getUsernameFromToken(token));
        String sourceID = String.format("%03d%06d", client.getUserID(), accountNumber);
        Map<String, Object> responseMessage = new HashMap<>();
        HttpStatus httpStatus;
        try {
            AccountWithdraw accountSource = accountListing.getClientWithdrawAccount(client.getUserID(), sourceID);
            Account accountDestination = accountListing.getAccount(destinationID);
            transactionWithdraw.execute(accountSource, amount);
            transactionDeposit.execute(accountDestination, amount);
            responseMessage.put("message", String.format("%.2f tenge was transferred to account %s", amount, destinationID));
            httpStatus = HttpStatus.OK;
        }catch (NullPointerException npe){
            responseMessage.put("message", "Account was not found");
            httpStatus = HttpStatus.NOT_FOUND;
        }catch (Exception e) {
            responseMessage.put("message", e);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(responseMessage, httpStatus);
    }
}
