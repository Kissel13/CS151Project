package Project;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountManager;

    AccountManager() {
        accountManager = new ArrayList<Account>();
    }

    public Boolean accountVerify(Account user) {
        // check if account exists in account file
        return false;
    }

    public Boolean passwordVerify(Account user) {
        // check if password matches account in file
        return false;
    }

    public void addAccount(Account user) {
        // write new account to file holding accounts
        accountManager.add(user);
    }
}
