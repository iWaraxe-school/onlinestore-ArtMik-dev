package store.populators;

import Categories.Category;
import Categories.CategoryEnum;
import Categories.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import store.SHttpServer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class HttpPopulator implements IHttpPopulator{

    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";

    SHttpServer server;
    HttpClient client;
    ObjectMapper mapper = new ObjectMapper();

    public HttpPopulator() {
        server = new SHttpServer();
        createClient();
    }

    @Override
    public List<Category> getCategories() {

        try {

            HttpGet forRequest = new HttpGet(server.CATEGORIES_URL);
            HttpResponse response = client.execute(forRequest);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            List<Category> list = mapper.readValue(result, new TypeReference<List<Category>>() {});

            return list;

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Product> getProductsForCategory(CategoryEnum category) {

        try {
            HttpGet request = new HttpGet(String.format(server.PRODUCTS_URL + "/%s", category.name()));
            HttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            List<Product> list = mapper.readValue(result, new TypeReference<List<Product>>() {});

            return list;

        } catch (IOException e) {
            System.out.println(String.format(category.name()) + e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public void addSoppingCart(String productName) throws Exception {

        HttpPost httppost = new HttpPost(String.format(server.CART_URL));

        try {
            httppost.setEntity(new StringEntity(mapper.writeValueAsString(server.addProductToCart(productName))));

        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Exception();
        }
    }
     @Override
        public List<Product> getProductsInCart() throws Exception {

            try {
                HttpGet request = new HttpGet(String.format(server.CART_URL));
                HttpResponse response = client.execute(request);

                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);

                List<Product> list = mapper.readValue(result, new TypeReference<List<Product>>() {
                });

                return list;

            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                throw new Exception();
            }
        }

    private void createClient(){
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
        provider.setCredentials(AuthScope.ANY, credentials);

        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
    }
}

