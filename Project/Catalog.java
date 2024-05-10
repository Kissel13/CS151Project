package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
         try {
            FileReader fileReader = new FileReader("catalogData.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                String[] part = line.split(", ");
                Song song = new Song(part[0], part[1], part[2], part[3], Double.parseDouble(part[4]));
                songCatalog.add(song);
                genreList.add(song.getGenre());
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
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
