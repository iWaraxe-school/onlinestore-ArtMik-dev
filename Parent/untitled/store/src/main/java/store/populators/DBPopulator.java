package store.populators;

import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;
import store.DBManager;
import store.IDBManager;

import java.sql.SQLException;
import java.util.List;

public class DBPopulator implements IPopulator {

    public IDBManager dbManager;

    public DBPopulator() {
        this.dbManager = new DBManager();
    }

    @Override
    public List<Category> getCategories() {

        try {
            if (dbManager.createTableIfDoesNotExist()) {
                fillByFaker();
            }

            return dbManager.getAllCategories();

        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            dbManager.dispose();

            return (new RandomStorePopulator()).getCategories();
        }
    }


    @Override
    public List<Product> getProductsForCategory(CategoryEnum categoryName) {

        try {
            return dbManager.getProductsForCategory(categoryName.name());

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            dbManager.dispose();

            return (new RandomStorePopulator()).getProductsForCategory(categoryName);
        }
    }
        private void fillByFaker() {

            try {
                RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
                List<Category> categories = randomStorePopulator.getCategories();

                for (Category category: categories) {
                    dbManager.insertCategoryIntoDB(category.getName());

                    List<Product> products = randomStorePopulator.getProductsForCategory(CategoryEnum.valueOf(category.getName()));

                    for (Product p: products) {
                        dbManager.insertProductIntoDB(p.name, category.getName(), p.price, p.rate);
                    }
                }

            } catch (SQLException e) {
                System.out.println(e.getLocalizedMessage());
                dbManager.dispose();
            }
        }
    }
