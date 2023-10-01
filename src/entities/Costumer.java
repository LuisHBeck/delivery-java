package entities;

public class Costumer extends User{
    private String cpf;

    public Costumer(String name, String password, Integer cep, Integer addressNumber, String cpf) {
        super(name, password, cep, addressNumber);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
