
import java.util.ArrayList;
import java.util.List;

public class Store {

    RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public Store() throws InstantiationException, IllegalAccessException {
        this.categories = randomStorePopulator.getCategories();
    }

    public void printListProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    public List<Product> getAllProducts() {
        List<Product> allProductsFromAllCategories = new ArrayList<>();
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                allProductsFromAllCategories.add(product);
            }
        }
        return allProductsFromAllCategories;
    }
}


         /*   List<Product> tempProducts = new ArrayList<>();
            for (Category category : getCategories()) {
                tempProducts.addAll(category.getProducts());
            }
            List<Product> tempProductList = new ArrayList<>(tempProducts);
            Comparator<Product> comp = new ProductComparator().thenComparing(new ProductComparator());
            tempProductList.sort(comp);
            for (Product p : tempProductList) {
                System.out.println("--------------------------------------------");
                System.out.println("NAME: " + p.getName() + " PRODUCTS: " + p.getPrice());*/


/*            public void productTop() throws InstantiationException, IllegalAccessException {
                List<Product> tempProductsTop5 = new ArrayList<>();
                for (Category category : getCategories()) {
                    tempProductsTop5.addAll(category.getProducts());
                }
                List<Product> tempProductListTop5 = new ArrayList<>(tempProductsTop5);
                Comparator<Product> compTop5 = new ProductComparator().thenComparing(new ProductComparator()).reversed();
                tempProductListTop5.sort(compTop5);
                for (int i = 0; i < 5 && tempProductListTop5.get(i) != null; i++) {
                    System.out.println("--------------------------------------------");
                    System.out.println(" NAME: " + tempProductListTop5.get(i).getName() + " PRODUCTS: " + tempProductListTop5.get(i).getPrice());

                }
            }*/


