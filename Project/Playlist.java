package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist implements SongList {

    private String playListName;
    private ArrayList<Song> listSongs;

    Playlist() {
        playListName = "";
        listSongs = new ArrayList<Song>();
    }

    Playlist(String name){
        playListName = name;
        listSongs = new ArrayList<Song>();
    }

    public Song getSongByName(String songName) {
        for (Song song : listSongs) {
            if (song.getSongName().equalsIgnoreCase(songName)) {
                return song;
            }
        }
        return null;
    }

    public boolean addSong(Song song) {
        if (getSongByName(song.getSongName()) != null) {
            return false;
        }

        listSongs.add(song);
        saveFile();
        return true;
    }

    public boolean removeSong(String songName){
        Song find = getSongByName(songName);
        if (find != null) {
            listSongs.remove(find);
            saveFile();
            return true;
        }
        return false;
    }

    public void setPlaylistName(String newName){
        playListName = newName;
    }

    public String getPlaylistName(){
        return playListName;
    }

    public void playSong(String songTitle) {
        Song find = getSongByName(songTitle);
        if (find != null) {
            System.out.println("Now playing: " + songTitle);
            System.out.println();
        } else {
            System.out.println("Song not found");
            System.out.println();
        }
    }

    public void display() {
        for (Song song : listSongs) {
            System.out.println(song);
        }
    }

    public static Playlist loadFromFile(String playListName) {
        Playlist playlist = new Playlist(playListName);
        try {
            FileReader fileReader = new FileReader(playListName + ".txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                String[] part = line.split(", ");
                playlist.addSong(new Song(part[0], part[1], part[2], part[3], Double.parseDouble(part[4])));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return playlist;
    }

    private void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(playListName + ".txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Song song : listSongs) {
                writer.write(song.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
