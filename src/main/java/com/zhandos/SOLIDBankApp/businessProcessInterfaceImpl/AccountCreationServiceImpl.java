package com.zhandos.SOLIDBankApp.businessProcessInterfaceImpl;

import com.zhandos.SOLIDBankApp.account.Account;
import com.zhandos.SOLIDBankApp.businessProcessInterfaces.AccountCreationService;
import com.zhandos.SOLIDBankApp.account.AccountDAO;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.CheckingAccount;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.FixedAccount;
import com.zhandos.SOLIDBankApp.account.accountTypes.accountSubtypes.SavingAccount;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountCreationServiceImpl implements AccountCreationService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public void create(String accountType, long bankID, String clientID, long accountID) {
        String id = String.format("%03d%06d", bankID, accountID);
        Account account = switch (accountType) {
            case "SAVING" -> new SavingAccount(accountType, id, clientID, 0);
            case "CHECKING" -> new CheckingAccount(accountType, id, clientID, 0);
            case "FIXED" -> new FixedAccount(accountType, id, clientID, 0);
            default -> throw new IllegalStateException("Unexpected value");
        };
        accountDAO.createNewAccount(account.getId(), account.getAccountType(), account.getClientID(),
                account.getBalance(), account.isWithdrawAllowed());
    }
}
