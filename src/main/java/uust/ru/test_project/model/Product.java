package uust.ru.test_project.model;



import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;


@Entity
@Table(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @Id
    @XmlElement(name = "id")
    private int id;

    @Column(name = "name")
    @XmlElement(name = "name")
    private String name;

    public Product() {

    }

    public Product(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id);}
}
