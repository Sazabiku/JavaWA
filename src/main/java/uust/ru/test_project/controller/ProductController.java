package uust.ru.test_project.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uust.ru.test_project.model.Product;
import uust.ru.test_project.service.ProductService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping
    public @ResponseBody
    List<Product> getProducts() throws Exception {return productService.getProducts();}

    @GetMapping("/{id}")
    public @ResponseBody
    Product getProduct(@PathVariable int id) throws Exception {return productService.getProduct(id);}

    @PostMapping
    public @ResponseBody
    Product addProduct(@RequestBody Product product) throws Exception {return productService.addProduct(product);}

    @PutMapping("/{id}")
    public @ResponseBody
    Product editProduct(@PathVariable int id, @RequestBody String name) throws Exception {return productService.editProduct(id, name);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id) throws Exception {productService.deleteProduct(id);}

}
