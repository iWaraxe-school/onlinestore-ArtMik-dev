package store;

import Categories.CategoryEnum;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class GetProductsHandler extends SHttpHandler{
    CategoryEnum categoryName;
    SHttpServer server;

    public GetProductsHandler(CategoryEnum category, SHttpServer server){
        categoryName = category;
        this.server = server;
    }

    public void handle(HttpExchange httpExchange) throws IOException {
        super.handle(httpExchange, server.getProductsForCategory(categoryName));
    }
}
