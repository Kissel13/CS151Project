package Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Catalog implements SongList {
    protected ArrayList<Song> songCatalog;
    private Set<String> genreList;

    Catalog() {
        songCatalog = new ArrayList<Song>();
        genreList = new HashSet<String>();
    }

    public void createCatalog() {
        Song song1 = new Song("Blinding Lights", "The Weeknd", "Pop", "After Hours", 3.20);
        genreList.add(song1.getGenre());
	    Song song2 = new Song("Glimpse of Us", "Joji", "Alternative", "Smithereens", 3.53);
        genreList.add(song2.getGenre());
	    Song song3 = new Song("Stayin' Alive", "Bee Gees", "Funk", "Disco", 4.10);
        genreList.add(song3.getGenre());
	    Song song4 = new Song("Heaven Can Wait", "Michael Jackson", "R&B", "Invincible", 4.48);
        genreList.add(song4.getGenre());
	    Song song5 = new Song("Needed Me", "Rihanna", "R&B", "Anti", 3.09);
        genreList.add(song5.getGenre());
	        
	    songCatalog.add(song1);
	    songCatalog.add(song2);
        songCatalog.add(song3);
        songCatalog.add(song4);
	    songCatalog.add(song5);
    }

    public Song getSongByName(String songName) {
        for (Song song : songCatalog) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null;
    }

    public void displayGenre() {
        // If genre was already printed, do not reprint
        for (String genre : genreList) {
            System.out.println(genre);
        }
    }
    
    public void displayGenreCatalog(String genreInput) {
        for (int i = 0; i < songCatalog.size(); i++) {
            if (songCatalog.get(i).getGenre().equalsIgnoreCase(genreInput)) {
                System.out.println(songCatalog.get(i).toString());
            }
        }
    }

    public void displayCatalog() {
        for (int i = 0; i < songCatalog.size(); i++) {
            System.out.println(songCatalog.get(i).toString());
        }
    }
}
