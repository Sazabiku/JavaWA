package uust.ru.test_project.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uust.ru.test_project.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServiceCollection implements ProductService {

    private List<Product> products = new ArrayList<>();

    public ServiceCollection() {
        products.add(new Product (1, "R1000"));
        products.add(new Product (2, "R2000"));
        products.add(new Product (3, "Elbrus-16S"));
        products.add(new Product (4, "Elbrus-8S"));
        products.add(new Product (5, "Elbrus-8SV"));
    }

    public List<Product> getProducts() {return products;}

    public Product getProduct(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(new Product());
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product editProduct(int id, String name){
        return products.stream().filter(product -> product.getId() == id).findFirst().map(product -> {
            product.setName(name);
            return product;
            }).orElse(new Product());
    }

    public void deleteProduct(int id){
        products = products.stream().filter(product -> product.getId() != id).collect(Collectors.toList());
    }
}
