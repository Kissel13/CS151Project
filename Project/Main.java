package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        AccountManager manager = new AccountManager();
        Catalog catalog = new Catalog();

        System.out.println("Login");
        System.out.print("Username: ");
        String userName = scnr.next();
        System.out.print("Password: ");
        String passWord = scnr.next();
        Account user = new Account(userName, passWord);
        manager.addAccount(user);

        catalog.createCatalog();
        System.out.println();

        while (true) {
            System.out.println("Would You Like To Create a Playlist?");
            String input = scnr.next();
            if (input.equals("Yes") || input.equals("yes")) {
                System.out.println();
                System.out.println("Plese Enter Name of Playlist: ");
                input = scnr.next();
                user.setPlayName(input);
            
                System.out.println();
            
            }
            else if (input.equals("No") || input.equals("no")) {
                System.out.println("Would You Like To Logout?");
                input = scnr.next();
                if (input.equals("Yes") || input.equals("yes")) {
            	    System.out.println("Application Closed");
                    break;
                }
            }
            else {
                System.out.println("Error: Input Not Accepted");
            }
        }
    }
}
