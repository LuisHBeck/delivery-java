package entities;

public class Sandwich {
    protected Integer id;
    protected String name;
    protected Double price;

    public Sandwich() {
    }

    public Sandwich(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Id= %d, Name= %s, Price= R$%.2f", this.id, this.name, this.price);
    }
}
