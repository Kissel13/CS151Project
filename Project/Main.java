package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountManager manager = new AccountManager();
        Catalog catalog = new Catalog();
        boolean loginLock = true;
        Boolean signupLock = true;

        System.out.println("Hello! Would You Like To Login or SignUp? : Login/SignUp");
        switch (scnr.next().toLowerCase()) {
            case "login":
                while (loginLock) {
                    System.out.print("Username: ");
                    String userName = scnr.next();
                    System.out.print("Password: ");
                    String passWord = scnr.next();
                    Account login = new Account(userName, passWord);
                    // Search AccountManager for match on username
                    if (manager.accountVerify(login)) {
                        // Check if password matches
                        if (manager.passwordVerify(login)) {
                            System.out.println("Welcome Back");
                            loginLock = false;
                        }
                        else {
                            System.out.println("Incorrect Password");
                        }
                    }
                    else {
                        System.out.println("Incorrect Username");
                    }
                }
                break;
                
            case "signup":
                System.out.println("Please Enter A Name and Password:");
                System.out.print("Username: ");
                String newUser = scnr.next();
                System.out.println();
                while (signupLock) {
                    System.out.println("Password must but at least 6 characters long.");
                    System.out.print("Password: ");
                    String newPass = scnr.next();
                    System.out.println();
                    if (newPass.length() >= 6) {
                        Account user = new Account(newUser, newPass);
                        manager.addAccount(user);
                        System.out.println("Thank You For Choosing MusicCatalog");
                        signupLock = false;
                    }
                    else {
                        System.out.println("Error: Please Enter A New Password.");
                    }
                    
                }
                break;
        }

        catalog.createCatalog();
        System.out.println();

        while (true) {
            System.out.println("Please Enter What Would You Like To Access: Catalog/Playlist/Exit");
            String input = scnr.next().toLowerCase();
            if (input.equals("catalog")) {
                System.out.println("Would You Like To Access A Catalog Genre or Full? : Genre/Full");
                String catalogInput = scnr.next().toLowerCase();
                if (catalogInput.equals("genre")) {
                    System.out.println();
                    System.out.println("What Genre Would You Like To View?");
                    
                    System.out.println(" Songs: ");
                    System.out.println();
                    catalog.displayCatalog();
                    System.out.println();
                } else if (catalogInput.equals("full")) {
                    System.out.println();
                    System.out.println("MusicCatalog Songs: ");
                    System.out.println();
                    catalog.displayCatalog();
                    System.out.println();
                }
                else {
                    System.out.println("Error: Input Not Accepted");
                }
            }
            else if (input.equals("playlist")) {
                System.out.println("Would You Like To Create, View, or Return? : Create/View/Return");
                switch (scnr.next().toLowerCase()) {
                    case "create" :
                        System.out.println("Plese Enter Name of Playlist: ");
                        input = scnr.next();
        
                        System.out.println();
                        break;
                    case "view" :
                    case "return" :
                        System.out.println();
                        break;
                }
            }
            else if (input.equals("exit")) {
                System.out.println("Would You Like To Exit? : Yes/No");
                String exitKey = scnr.next().toLowerCase();
                if (exitKey.equals("yes")) {
            	    System.out.println("Application Closed");
                    return;
                }
                else if (exitKey.equals("no")) {
                    System.out.println("Exit Canceled");
                }
                else {
                    System.out.println("Error: Input Not Accepted");
                }
            }
            else {
                System.out.println("Error: Input Not Accepted");
            }
        }
    }
}
