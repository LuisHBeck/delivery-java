package entities;

import java.util.ArrayList;
import java.util.List;

public class Costumer extends User{
    private String cpf;

    protected static List<Sandwich> shoppingCart = new ArrayList<>();

    public Costumer(String name, String password, String cep, String addressNumber, String cpf) {
        super(name, password, cep, addressNumber);
        this.cpf = cpf;
    }

    public void addToShoppingCart (Sandwich sandwich) {
        shoppingCart.add(sandwich);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static List<Sandwich> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", this.name, this.cep, this.addressNumber, this.cpf);
    }
}
