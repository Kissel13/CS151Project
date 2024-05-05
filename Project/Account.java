package Project;

public class Account {
    private String accountName;
    private String password;
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

    public String getAccountName() {
        return this.accountName;
    }

    public String getPassword() {
        return this.password;
    }

    public void createPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}

