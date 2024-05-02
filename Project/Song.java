package Project;

public class Song {
    private String songName;
    private String artist;
    private String genre;
    private String album;
    private double songLength;

    Song() {

    }

    Song(String sngName, String artist, String album, double length) {
    	this.songName = sngName;
        this.artist = artist;
        this.album = album;
        this.songLength = length;
    }

    Song(String sngName, String artist, String genre, String album, double length) {
        this.songName = sngName;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.songLength = length;
    }

    public void setSongName(String sngName) {
        this.songName = sngName;
    }

    public String getSongName(){
        return this.songName;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setSongLength(double length) {
        this.songLength = length;
    }

    public String toString() {
        return songName + ": " + artist + ", " + album + ", " + genre + ", " + songLength;
    }

}
