
import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;
import populators.IPopulator;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public List<Category> categories = new ArrayList<>();
    public static List<Product> purchasedProductList = new ArrayList<>();
    public void printAllCategoriesAndProduct() {

        for (Category category : categories) {
            category.setProducts(getAllProducts());
        }
    }
    public void fillStore(IPopulator populator) {

        List<Category> categories = populator.getCategories();
        categories.addAll(categories);

        for (Category category : categories) {

            List<Product> products = populator.getProductsForCategory(CategoryEnum.valueOf(category.getName()));
            category.setProducts(products);
        }
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

    public List<Product> getListOfAllProducts() {

        List<Product> allProducts = new ArrayList<>();

        for (Category category : this.categories) {
            allProducts.addAll(category.getProducts());
        }

        return allProducts;
    }
}


         /*   List<Categories.Product> tempProducts = new ArrayList<>();
            for (Categories.Category category : getCategories()) {
                tempProducts.addAll(category.getProducts());
            }
            List<Categories.Product> tempProductList = new ArrayList<>(tempProducts);
            Comparator<Categories.Product> comp = new ProductComparator().thenComparing(new ProductComparator());
            tempProductList.sort(comp);
            for (Categories.Product p : tempProductList) {
                System.out.println("--------------------------------------------");
                System.out.println("NAME: " + p.getName() + " PRODUCTS: " + p.getPrice());*/


/*            public void productTop() throws InstantiationException, IllegalAccessException {
                List<Categories.Product> tempProductsTop5 = new ArrayList<>();
                for (Categories.Category category : getCategories()) {
                    tempProductsTop5.addAll(category.getProducts());
                }
                List<Categories.Product> tempProductListTop5 = new ArrayList<>(tempProductsTop5);
                Comparator<Categories.Product> compTop5 = new ProductComparator().thenComparing(new ProductComparator()).reversed();
                tempProductListTop5.sort(compTop5);
                for (int i = 0; i < 5 && tempProductListTop5.get(i) != null; i++) {
                    System.out.println("--------------------------------------------");
                    System.out.println(" NAME: " + tempProductListTop5.get(i).getName() + " PRODUCTS: " + tempProductListTop5.get(i).getPrice());

                }
            }*/


