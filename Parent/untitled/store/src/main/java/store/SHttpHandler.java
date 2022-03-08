package store;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class SHttpHandler implements HttpHandler {

    protected void handle(HttpExchange httpExchange, Object responseObject) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(responseObject);
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println();
    }
}
