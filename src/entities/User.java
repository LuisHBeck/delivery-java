package entities;

public abstract class User {
    protected String name;
    protected String password;
    protected String cep;
    protected String addressNumber;

    public User(String name, String password, String cep, String addressNumber) {
        this.name = name;
        this.password = password;
        this.cep = cep;
        this.addressNumber = addressNumber;
    }

    public String getPassword() {
        return password;
    }
}
