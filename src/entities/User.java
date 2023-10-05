package entities;

public abstract class User {
    protected String name;
    protected String password;
    protected String x;
    protected String y;

    public User(String name, String password, String x, String y) {
        this.name = name;
        this.password = password;
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getPassword() {
        return password;
    }
}
