package Project;

import java.io.File;
import java.util.Scanner;

public class Main extends Playlist{
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Account currentUser = new Account();
        AccountManager manager = new AccountManager();
        Catalog catalog = new Catalog();
        boolean loginLock = true;
        boolean userNameLock = true;
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
                while (userNameLock) {
                    currentUser.setAccountName(newUser);
                    if (manager.accountVerify(currentUser)) {
                        System.out.println("Username Already Exists");
                        System.out.print("Username: ");
                        newUser = scnr.next();
                    }
                    else {
                        userNameLock = false;
                    }
                }
                System.out.println();
                while (signupLock) {
                    System.out.println("Password must but at least 6 characters long.");
                    System.out.print("Password: ");
                    String newPass = scnr.next();
                    System.out.println();
                    if (newPass.length() >= 6) {
                        //currentUser.setAccountName(newUser);
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
            
            default : 
                System.out.println("Invalid input");
                scnr.close();
                return;
        }

        catalog.createCatalog();
        System.out.println();

        while (true) {
            System.out.println("Please Enter What Would You Like To Access: Catalog/Playlist/Exit");
            String input = scnr.next().toLowerCase();
            if (input.equals("catalog")) {
                System.out.println();
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
                    System.out.println();
                    //Print all songs that match genre
                    catalog.displayGenreCatalog(genreInput);
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
                System.out.println();
                System.out.println("Would You Like To Create, View, or Return? : Create/View/Return");
                switch (scnr.next().toLowerCase()) {
                    case "create" :
                        System.out.println();
                        System.out.println("Plese Enter Name of Playlist: ");
                        String name = scnr.next();
                        Playlist userList = new Playlist(name);
                        currentUser.createPlaylist(userList);
                        System.out.println();
                        while (playListLock) {
                            System.out.println("Actions : Add/Remove/Return");
                            String action = scnr.next();
                            System.out.println();
                            scnr.nextLine();
                            switch (action.toLowerCase()) {
                                case "add" :
                                    addSong(scnr, catalog, userList);
                                    System.out.println();
                                    break;

                                case "remove" :
                                    removeSong(scnr, userList);
                                    System.out.println();
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
                        System.out.println();
                        System.out.println("Please Enter Name of Playlist: ");
                        String name2 = scnr.next();
                        if (!new File(name2 + ".txt").exists()) {
                            System.out.println("PlayList file not found.");
                            System.out.println();
                        } else {
                            Playlist playlist = Playlist.loadFromFile(name2);
                            System.out.println();
                            playlist.display();
                            System.out.println();
                            //Give users option to play a song, add a song, remove a song
                            while (userLock) {
                                System.out.println("Would You Like To Play, Add, Remove or Return? : Play/Add/Remove/Return");
                                String userAction = scnr.next();
                                System.out.println();
                                scnr.nextLine();
                                switch (userAction.toLowerCase()) {
                                    case "play" :
                                        playSong(scnr, playlist);
                                        break;
                                    case "add":
                                        addSong(scnr, catalog, playlist);
                                        break;
                                    case "remove":
                                        removeSong(scnr, playlist);
                                        break;
                                    case "return" :
                                        userLock = false;
                                        System.out.println();
                                        break;
                                }
                            }
                        }
                        break;

                    case "return" :
                        System.out.println();
                        break;

                    default : 
                        System.out.println("Invalid Input");
                        break;
                }
            }
            else if (input.equals("exit")) {
                System.out.println();
                System.out.println("Would You Like To Exit? : Yes/No");
                String exitKey = scnr.next().toLowerCase();
                if (exitKey.equals("yes")) {
            	    System.out.println("Application Closed");
                    return;
                }
                else if (exitKey.equals("no")) {
                    System.out.println("Exit Canceled");
                    System.out.println();
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

    private static void addSong(Scanner sc, Catalog catalog, Playlist playlist) {
        System.out.print("Enter Song Title: ");
        String title = sc.nextLine();
        Song find = catalog.getSongByName(title);
        if (find == null) {
            System.out.println("This Song Is Not In The Catalog");
            System.out.println();
        } else {
            if (!playlist.addSong(find)) {
                System.out.println("This Song Is Already In The Playlist");
                System.out.println();
            } else {
                System.out.println("Successfully Added To Playlist");
                System.out.println();
            }
        }
    }

    private static void removeSong(Scanner sc, Playlist playlist) {
        System.out.print("Enter Song Title: ");
        String rTitle = sc.nextLine();
        if (!playlist.removeSong(rTitle)) {
            System.out.println("This Song Is Not In The Playlist");
            System.out.println();
        } else {
            System.out.println("Successfully Removed From Playlist");
            System.out.println();
        }
    }

    private static void playSong(Scanner sc, Playlist playlist) {
        System.out.print("Enter song to play: ");
        String songName = sc.nextLine();
        playlist.playSong(songName);
    }

}
