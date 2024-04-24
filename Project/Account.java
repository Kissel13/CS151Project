package Project;

public class Account {
    private String accountName;
    private String password;
    private String playName;
    private Playlist playlist;

    Account() {

    }

    Account(String userName, String passWord) {
        this.accountName = userName;
        this.password = passWord;
    }

    public void setAccountName(String name) {
        this.accountName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlayName(String playName) {
		this.playName = playName;
	}

    public void createPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}

