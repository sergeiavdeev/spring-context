package components;

import entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SimpleProductRepository implements ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(int id) {
        return productList.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
    }

    @PostConstruct
    private void init() {
        productList.addAll(Arrays.asList(
                new Product(1, "Капуста", 25f),
                new Product(2, "Морковь", 35f),
                new Product(3, "Свекла", 15f),
                new Product(4, "Колбаса", 40f),
                new Product(5, "Мясо", 65f)
        ));
    }
}
