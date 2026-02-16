package org.example.Product;

import org.example.entity.Product;
import java.util.List;

public interface ProductDAO {
    void createTable();
    void add(Product product);
    void deleteById(int pid);
    List<Product> findAll();
    Product findById(int pid);
    void updatePriceById(int pid, double newPrice);
    List<Product> filterByBrand(String brand);
    List<Product> filterByCategory(String category);
    List<Product> filterByPriceRange(double minPrice, double maxPrice);
    List<Product> filterByRating(int rating);
    List<Product> sortByPriceAsc();
    List<Product> sortByPriceDesc();
    boolean existsById(int pid);
    int countByBrand(String brand);
    Product findMostExpensive();
    Product findCheapest();
    List<Product> searchByName(String keyword);
    void deleteByBrand(String brand);
}
