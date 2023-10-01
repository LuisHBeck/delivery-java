package entities;

public class Costumer extends User{
    private String cpf;

    public Costumer(String name, String password, String cep, String addressNumber, String cpf) {
        super(name, password, cep, addressNumber);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", this.name, this.cep, this.addressNumber, this.cpf);
    }
}
