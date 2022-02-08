public class Product{

    public int rate;
    public int price;
    public String name;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public int getRate() {

        return rate;
    }

    public int getPrice() {

        return price;
    }

    public String getName() {

        return name;
    }
    @Override
    public String toString() {

        return name + ' ' + price + "$" + ", rate= " + rate;
    }
}