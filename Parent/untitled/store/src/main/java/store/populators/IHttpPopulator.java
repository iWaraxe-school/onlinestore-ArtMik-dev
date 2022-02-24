package store.populators;

import Categories.Product;

import java.util.List;

public interface IHttpPopulator extends IPopulator{
    void addSoppingCart(String productName) throws Exception;
    List<Product> getProductsInCart() throws Exception;
}
