package com.zhandos.SOLIDBankApp;

import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl.AccountCreationServiceImpl;
import com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl.AccountDepositServiceImpl;
import com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl.AccountListingServiceImpl;
import com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl.AccountWithdrawServiceImpl;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountCreationService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountDepositService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountListingService;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountWithdrawService;
import com.zhandos.SOLIDBankApp.cli.AccountBasicCLI;
import com.zhandos.SOLIDBankApp.cli.TransactionDepositCLI;
import com.zhandos.SOLIDBankApp.cli.TransactionWithdrawCLI;
import com.zhandos.SOLIDBankApp.transaction.TransactionDAO;
import com.zhandos.SOLIDBankApp.transaction.TransactionDeposit;
import com.zhandos.SOLIDBankApp.transaction.TransactionWithdraw;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyCLI myCLI() {
        return new MyCLI();
    }

    @Bean
    public AccountCreationService accountCreation() {
        return new AccountCreationServiceImpl();
    }

    @Bean
    public AccountListingService accountListing() {
        return new AccountListingServiceImpl();
    }

    @Bean
    public AccountWithdrawService accountWithdrawService() {
        return new AccountWithdrawServiceImpl();
    }

    @Bean
    public AccountDepositService accountDepositService() {
        return new AccountDepositServiceImpl();
    }

    @Bean
    public BankCore bankCore() {
        return new BankCore(accountCreation());
    }

    @Bean
    public AccountBasicCLI accountBasicCLI() {
        return new AccountBasicCLI(myCLI(), bankCore(), accountListing());
    }


    @Bean
    public TransactionWithdraw transactionWithdraw() {
        return new TransactionWithdraw(accountWithdrawService());
    }

    @Bean
    public TransactionWithdrawCLI transactionWithdrawCLI() {
        return new TransactionWithdrawCLI(transactionWithdraw(), myCLI(), accountListing());
    }

    @Bean
    public TransactionDeposit transactionDeposit() {
        return new TransactionDeposit(accountDepositService());
    }

    @Bean
    public TransactionDepositCLI transactionDepositCLI() {
        return new TransactionDepositCLI(transactionDeposit(), myCLI(), accountListing());
    }

}
