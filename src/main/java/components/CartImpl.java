package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartImpl implements Cart{

    private final List<Integer> productList = new ArrayList<>();
    private ProductRepository productRepository;

    @Override
    public void add(int id) {
        productList.add(id);
    }

    @Override
    public void remove(int id) {
        productList.removeIf(p -> p == id);
    }

    @Override
    public void printCart() {
        productList.forEach(id -> System.out.println(productRepository.getById(id)));
    }

    @Autowired
    public void setProductRepository(ProductRepository repository) {
        productRepository = repository;
    }
}
