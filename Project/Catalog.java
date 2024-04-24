package Project;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Song> songCatalog;

    Catalog() {
        songCatalog = new ArrayList<Song>();
    }

    public void createCatalog() {
        Song song1 = new Song("Blinding Lights", "The Weeknd", "Pop", "After Hours", 3.20);
	    Song song2 = new Song("Glimpse of Us", "Joji", "Alternative", "Smithereens", 3.53);
	    Song song3 = new Song("Stayin' Alive", "Bee Gees", "Disco", 4.10);
	    Song song4 = new Song("Heaven Can Wait", "Michael Jackson", "R&B", "Invincible", 4.48);
	    Song song5 = new Song("Needed Me", "Rihanna", "R&B", "Anti", 3.09);
	        
	    songCatalog.add(song1);
	    songCatalog.add(song2);
        songCatalog.add(song3);
        songCatalog.add(song4);
	    songCatalog.add(song5);
    }

    public void addSong(Song song) {
        songCatalog.add(song);
    }

    public void removeSong(Song song) {
        songCatalog.remove(song);
    }

    public void displayCatalog() {
        for (int i = 0; i < songCatalog.size(); i++) {
            System.out.println(songCatalog.get(i).toString());
        }
    }
}
