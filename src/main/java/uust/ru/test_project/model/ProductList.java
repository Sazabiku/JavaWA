package uust.ru.test_project.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList {

    @XmlElement(name = "product")
    private List<Product> products;

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products){
        this.products=products;
    }
}
