package org.example.Phone.phoneServices;

import org.example.entity.Phone;

import java.util.List;

public interface PhoneService {
    void createTable();
    void add(Phone phone);
    void deleteById(int phoneId);
    List<Phone> findAll();
    Phone findById(int phoneId);
    void updatePriceByModel(String model, double newPrice);
    List<Phone> filterByBrand(String brand);
    List<Phone> filterByPriceRange(double minPrice, double maxPrice);
    List<Phone> filterByStorage(int storageCapacity);
    List<Phone> sortByPriceAsc();
    List<Phone> sortByPriceDesc();
    boolean existsById(int phoneId);
    int countByBrand(String brand);
    Phone findMostExpensive();
    Phone findCheapest();
    List<Phone> searchByModel(String keyword);
    void updateStock(int phoneId, int quantity);
    void deleteByBrand(String brand);

}
