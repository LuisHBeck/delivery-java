package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User{
    protected String cnpj;
    protected static List<Sandwich> menu = new ArrayList<>();

    public Restaurant(String name, String password, String x, String y, String cnpj) {
        super(name, password, x, y);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Sandwich> getMenu() {
        return menu;
    }

//    public void getMenu() {
//        for (Sandwich sandwich : menu){
//            System.out.println(sandwich);
//        }
//    }

    public void addToMenu(Sandwich sandwich) {
        this.menu.add(sandwich);
    }

    public void removeFromMenu(Integer id) {
        for (Sandwich sandwich : menu) {
            if (sandwich.id == id) {
                menu.remove(sandwich);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", name, x, y, cnpj);
    }
}
