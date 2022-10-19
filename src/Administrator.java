package src;

public class Administrator {

    private final String name;

    private final String user;

    private String password;

    Administrator(String name, String user, String password) {
        this.name = name;
        this.user = user;
        this.password = password;
    }

    public String getName() { return this.name; }
    public String getUser () { return this.user; }
    public String getPassword() { return this.password; }


}
