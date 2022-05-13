package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountCreationService;
import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.AccountType;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.CheckingAccount;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.FixedAccount;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.SavingAccount;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService {
    private AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String id = String.format("%03d%06d", bankID, accountID);
        Account account = switch (accountType.name) {
            case "SAVING" -> new SavingAccount(accountType, id, clientID, 0);
            case "CHECKING" -> new CheckingAccount(accountType, id, clientID, 0);
            case "FIXED" -> new FixedAccount(accountType, id, clientID, 0);
            default -> throw new IllegalStateException("Unexpected value");
        };
        accountDAO.createNewAccount(account);
    }
}
