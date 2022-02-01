import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.io.IOException;
import java.util.List;

public interface command {
    void execute(List<Product> products) throws IOException, InstantiationException, IllegalAccessException;
}
