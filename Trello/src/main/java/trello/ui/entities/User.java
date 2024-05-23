package trello.ui.entities;

public class User {

    private String email;
    private String name;
    private String password;

    public User(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public User() {}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
