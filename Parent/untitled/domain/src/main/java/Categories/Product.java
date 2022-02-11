package Categories;

public class Product{

    public double rate;
    public double price;
    public String name;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public int getRate() {

        return (int) rate;
    }

    public int getPrice() {

        return (int) price;
    }

    public String getName() {

        return name;
    }
    @Override
    public String toString() {

        return name + ' ' + price + "$" + ", rate= " + rate;
    }
}