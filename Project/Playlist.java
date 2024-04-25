package Project;

import java.util.ArrayList;

public class Playlist extends Catalog {
    private ArrayList<Song> listSongs;

    Playlist() {
        listSongs = new ArrayList<Song>();
    }

    @Override
    public void addSong(Song song){
        listSongs.add(song);
    }

    @Override
    public void removeSong(Song song){
        listSongs.remove(song);
    }

    public void playSong(Song song)
    {
        System.out.println("Now playing: " + song.getSongName());
    }

    public void displayPlaylist() {
        for (int i = 0; i < listSongs.size(); i++) {
            System.out.println(listSongs.get(i).toString());
        }
    }
}
