package uust.ru.test_project.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uust.ru.test_project.model.Product;
import uust.ru.test_project.repository.ProductRepository;

import java.util.List;

@Primary
@Service
public class ServiceDB implements ProductService{

    private final ProductRepository productRepo;

    public ServiceDB (ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() throws Exception {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(int id) throws Exception {
        return productRepo.findById(id).orElse(new Product());
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        return productRepo.save(product);
    }

    @Override
    public Product editProduct(int id, String name) throws Exception {
        Product findProduct = getProduct(id);
        findProduct.setName(name);
        return productRepo.save(findProduct);
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        productRepo.deleteById(id);
    }
}
