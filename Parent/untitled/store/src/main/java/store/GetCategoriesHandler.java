package store;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class GetCategoriesHandler extends SHttpHandler{

    SHttpServer server;

    public GetCategoriesHandler(SHttpServer server){
        this.server = server;
    }

    public void handle(HttpExchange httpExchange) throws IOException {

        super.handle(httpExchange, server.getCategories());
    }
}
