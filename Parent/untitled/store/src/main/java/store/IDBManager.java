package store;

import Categories.Category;
import Categories.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDBManager {
    Connection getDBConnection();
    void dispose();

    boolean createTableIfDoesNotExist() throws Exception ;
    void insertCategoryIntoDB(String categoryName) throws SQLException;
    void insertProductIntoDB(String name, String category, int price, int rate) throws SQLException ;

    List<Category> getAllCategories() throws SQLException;
    List<Product> getProductsForCategory(String category) throws SQLException ;

}

