package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountManager manager = new AccountManager();
        Catalog catalog = new Catalog();
        Boolean lock = true;

        System.out.println("Hello! Would You Like To Login or SignUp?");
        switch (scnr.next()) {
            case "Login":
                System.out.print("Username: ");
                String userName = scnr.next();
                System.out.print("Password: ");
                String passWord = scnr.next();
                Account login = new Account(userName, passWord);
                // Search AccountManager for match on username
                // Check if password matches
                break;
                
            case "SignUp":
                System.out.println("Please Enter A Name and Password:");
                System.out.print("Username: ");
                String newUser = scnr.next();
                System.out.println();
                while (lock) {
                    System.out.println("Password must but at least 6 characters long.");
                    System.out.print("Password: ");
                    String newPass = scnr.next();
                    System.out.println();
                    if (newPass.length() >= 6) {
                        Account user = new Account(newUser, newPass);
                        manager.addAccount(user);
                        System.out.println("Thank You For Choosing MusicCatalog");
                        lock = false;
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
            System.out.println("Please Enter What Would You Like To Access: Catalog, Playlist, Exit");
            String input = scnr.next();
            if (input.equals("catalog") || input.equals("Catalog")) {
                System.out.println();
                System.out.println("MusicCatalog Songs: ");
                System.out.println();
                catalog.displayCatalog();
            }
            else if (input.equals("playlist") || input.equals("Playlist")) {
                System.out.println("Would You Like To Create, View, or Return?");
                switch (scnr.next()) {
                    case "Create" :
                        System.out.println("Plese Enter Name of Playlist: ");
                        input = scnr.next();
                        //user.setPlayName(input);
        
                        System.out.println();
                        break;
                    case "View" :
                    case "Return" :
                        System.out.println();
                        break;
                }
            }
            else if (input.equals("exit") || input.equals("Exit")) {
                System.out.println("Would You Like To Logout?");
                if (scnr.next().equals("Yes") || scnr.next().equals("yes")) {
            	    System.out.println("Application Closed");
                    return;
                }
                else if (scnr.next().equals("no") || scnr.next().equals("No")) {
                    
                }
            }
            else {
                System.out.println("Error: Input Not Accepted");
            }
        }
    }
}
