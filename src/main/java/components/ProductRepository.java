package components;

import entities.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();
    Product getById(int id);

}
