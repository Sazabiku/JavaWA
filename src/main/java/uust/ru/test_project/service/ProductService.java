package uust.ru.test_project.service;

import uust.ru.test_project.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts() throws Exception;

    Product getProduct(int id) throws Exception;

    Product addProduct(Product product) throws Exception;

    Product editProduct(int id, String name) throws Exception;

    void deleteProduct(int id) throws Exception;
}
