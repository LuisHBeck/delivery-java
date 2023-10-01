package entities;

public abstract class User {
    protected String name;
    private String password;
    protected Integer cep;
    protected Integer addressNumber;

    public User(String name, String password, Integer cep, Integer addressNumber) {
        this.name = name;
        this.password = password;
        this.cep = cep;
        this.addressNumber = addressNumber;
    }
}
