package Project;

import java.util.ArrayList;

public class Playlist extends Catalog {

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

    @Override
    public void addSong(Song song){
        listSongs.add(song);
    }

    @Override
    public void removeSong(Song song){
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

    public void displayPlaylist() {
        for (int i = 0; i < listSongs.size(); i++) {
            System.out.println(listSongs.get(i).toString());
        }
    }
}
