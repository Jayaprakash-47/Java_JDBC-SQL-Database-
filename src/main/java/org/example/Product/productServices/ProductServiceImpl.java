package org.example.Product.productServices;

import org.example.Product.ProductDAO;
import org.example.entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void createTable() {
        productDAO.createTable();
    }

    @Override
    public void add(Product product) {
        productDAO.add(product);
    }

    @Override
    public void deleteById(int pid) {
        productDAO.deleteById(pid);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int pid) {
        return productDAO.findById(pid);
    }

    @Override
    public void updatePriceById(int pid, double newPrice) {
        productDAO.updatePriceById(pid, newPrice);
    }

    @Override
    public List<Product> filterByBrand(String brand) {
        return productDAO.filterByBrand(brand);
    }

    @Override
    public List<Product> filterByCategory(String category) {
        return productDAO.filterByCategory(category);
    }

    @Override
    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        return productDAO.filterByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> filterByRating(int rating) {
        return productDAO.filterByRating(rating);
    }

    @Override
    public List<Product> sortByPriceAsc() {
        return productDAO.sortByPriceAsc();
    }

    @Override
    public List<Product> sortByPriceDesc() {
        return productDAO.sortByPriceDesc();
    }

    @Override
    public boolean existsById(int pid) {
        return productDAO.existsById(pid);
    }

    @Override
    public int countByBrand(String brand) {
        return productDAO.countByBrand(brand);
    }

    @Override
    public Product findMostExpensive() {
        return productDAO.findMostExpensive();
    }

    @Override
    public Product findCheapest() {
        return productDAO.findCheapest();
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productDAO.searchByName(keyword);
    }

    @Override
    public void deleteByBrand(String brand) {
        productDAO.deleteByBrand(brand);
    }
}
