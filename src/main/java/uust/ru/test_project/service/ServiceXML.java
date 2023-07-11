package uust.ru.test_project.service;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uust.ru.test_project.model.Product;
import uust.ru.test_project.model.ProductList;

import java.io.File;
import java.util.List;

@Service
public class ServiceXML implements ProductService {

    private static final String FILE_PATH = "C:\\dev\\test_project\\src\\main\\resources\\products.xml";

    @Override
    public List<Product> getProducts() throws Exception {
        return getProductList().getProducts();
    }

    @Override
    public Product getProduct(int id) throws Exception {
        return getProducts().stream().filter(product -> product.getId() == id)
                .findFirst().orElse(new Product());
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        ProductList productList = getProductList();
        productList.getProducts().add(product);
        save(productList);
        return product;
    }

    @Override
    public Product editProduct(int id, String name) throws Exception {

        ProductList productList = getProductList();
        Product findProduct = productList.getProducts().stream().filter(product -> product.getId() == id)
                .findFirst().orElse(null);
        if (findProduct == null) {
            return new Product();
        }
        findProduct.setName(name);
        save(productList);
        return findProduct;
    }

    @Override
    public void deleteProduct(int id) throws Exception {

        ProductList productList = getProductList();
        Product findProduct = productList.getProducts().stream().filter(product -> product.getId() == id)
                .findFirst().orElse(null);
        if (findProduct != null) {
            productList.getProducts().remove(findProduct);
            save(productList);
        }
    }

    private ProductList getProductList() throws Exception {
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(ProductList.class);
        Unmarshaller unMarshaller = context.createUnmarshaller();
        return (ProductList) unMarshaller.unmarshal(file);
    }

    private void save(ProductList productList) throws Exception {
        File file = new File(FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(ProductList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(productList, file);
    }
}
