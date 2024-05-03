package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist extends Catalog implements SongList {

    private String playListName;
    private ArrayList<Song> listSongs;
    private File playlistFile;

    Playlist() {
        playListName = "";
        listSongs = new ArrayList<Song>();
    }

    Playlist(String name){
        playListName = name;
        listSongs = new ArrayList<Song>();
        playlistFile = new File(name);
    }

    @Override
    public void addSong(String song) {
        Song temp = new Song();
        Song added = new Song();
        for (int i = 0; i < songCatalog.size(); i++) {
            temp = songCatalog.get(i);
            if (temp.getSongName().trim().equalsIgnoreCase(song.trim())) {
                System.out.println("If Condition");
                added = temp;
                break;
            }
        }
        //add given song to file containing user playlist
        try {
            FileWriter fileWriter = new FileWriter(playlistFile,true);
            BufferedWriter writer = new BufferedWriter(fileWriter);    

            writer.write(added.toString());
            writer.newLine();
            writer.close();            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        listSongs.add(added);
    }

    @Override
    public void removeSong(String song){
        //remove given song 
        listSongs.remove(song);
    }

    public void setPlaylistName(String newName){
        playListName = newName;
    }

    public String getPlaylistName(){
        return playListName;
    }

    public void playSong(String songTitle)
    {
        for (int i = 0; i < listSongs.size(); i++)
        {
            if (listSongs.get(i).getSongName() == songTitle)
            {
                System.out.println("Now playing: " + listSongs.get(i).getSongName());
                break;
            }
            else if (i == listSongs.size() - 1)
                System.out.println("Song not found");
        }
    }

    public static void displayPlaylist(String playlist) {
        try {
            FileReader fileReader = new FileReader(playlist+".txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
