package Project;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountManager;

    AccountManager() {
        accountManager = new ArrayList<Account>();
    }

    public void addAccount(Account user) {
        accountManager.add(user);
    }
}
