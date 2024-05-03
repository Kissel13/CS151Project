package Project;

import java.util.Scanner;

public class Main extends Playlist{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Account currentUser = new Account();
        AccountManager manager = new AccountManager();
        Catalog catalog = new Catalog();
        boolean loginLock = true;
        boolean signupLock = true;
        boolean playListLock = true;
        boolean userLock = true;

        System.out.println("Hello! Would You Like To Login or SignUp? : Login/SignUp");
        switch (scnr.next().toLowerCase()) {
            case "login":
                while (loginLock) {
                    System.out.print("Username: ");
                    String userName = scnr.next();
                    System.out.print("Password: ");
                    String passWord = scnr.next();
                    //currentUser = new Account(userName, passWord);
                    currentUser.setAccountName(userName);
                    currentUser.setPassword(passWord);
                    // Search AccountManager for match on username
                    if (manager.accountVerify(currentUser)) {
                        // Check if password matches
                        if (manager.passwordVerify(currentUser)) {
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
                        //currentUser = new Account(newUser, newPass);
                        currentUser.setAccountName(newUser);
                        currentUser.setPassword(newPass);
                        manager.addAccount(currentUser);
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
                    catalog.displayGenre();
                    System.out.println();
                    //Take user Input 
                    System.out.println("Genre: ");
                    String genreInput = scnr.next().toLowerCase();
                    //Print all songs that match genre
                    catalog.displayGenreCatalog(genreInput);
                    
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
                        String name = scnr.next();
                        Playlist userList = new Playlist(name);
                        currentUser.setPlayName(name);
                        System.out.println();
                        while (playListLock) {
                            System.out.println("Actions : Add/Remove/Return");
                            String action = scnr.next();
                            scnr.nextLine();
                            switch (action.toLowerCase()) {
                                case "add" :
                                    System.out.print("Enter Song Title: ");
                                    //Make way for users to select songs to add to their playlists
                                    String title = scnr.nextLine();
                                    userList.addSong(title);
                                    break;

                                case "remove" :
                                    System.out.print("Enter Song Title: ");
                                    //Make way for users to select songs to add to their playlists
                                    String rTitle = scnr.next();
                                    userList.removeSong(rTitle);
                                    break;

                                case "return" :
                                    playListLock = false;
                                    System.out.println();
                                    break;
                            }
                        }
                        break;
                    case "view" :
                        //Read users playlist from playlist file
                        System.out.println("Please Enter Name of Playlist: ");
                        String name2 = scnr.next();
                        displayPlaylist(name2);
                        //Give users option to play a song, add a song, remove a song
                        while (userLock) {
                            System.out.println("Would You Like To Play, Add, Remove, or Return? : Play/Add/Remove/Return");
                            String userAction = scnr.next();
                            switch (userAction.toLowerCase()) {
                                case "play" :
                                case "add" :
                                case "remove" :
                                case "return" :
                                    userLock = false;
                                    System.out.println();
                                    break;
                            }
                        }
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
