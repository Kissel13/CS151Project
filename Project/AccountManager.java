package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accountManager;

    AccountManager() {
        accountManager = new ArrayList<Account>();
    }

    public Boolean accountVerify(Account user) {
        // check if account exists in account file
        try {
            FileReader fileReader = new FileReader("account.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = reader.readLine();
            while (line != null) {
                String[] info = line.split(" ");
                if (info[0].equals(user.getAccountName())) {
                    reader.close();
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();;
        }
        return false;
    }

    public Boolean passwordVerify(Account user) {
        // check if password matches account in file
        try {
            FileReader fileReader = new FileReader("account.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = reader.readLine();
            while (line != null) {
                String[] info = line.split(" ");
                if (info[1].equals(user.getPassword())) {
                    reader.close();
                    return true;
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();;
        }
        return false;
    }

    public void addAccount(Account user) {
        accountManager.add(user);
        try {
            FileWriter fileWriter = new FileWriter("account.txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(user.getAccountName());
            writer.write(" ");
            writer.write(user.getPassword());
            writer.newLine();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
