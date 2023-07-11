package uust.ru.test_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uust.ru.test_project.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
