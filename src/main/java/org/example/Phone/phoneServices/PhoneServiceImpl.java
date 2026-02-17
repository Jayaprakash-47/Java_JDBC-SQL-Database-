package org.example.Phone.phoneServices;

import org.example.Phone.PhoneDAO;
import org.example.entity.Phone;

import java.util.List;

public class PhoneServiceImpl implements PhoneService{
    PhoneDAO phoneDAO;

    public PhoneServiceImpl(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public void createTable() {
        phoneDAO.createTable();
    }

    @Override
    public void add(Phone phone) {
        if(phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }
        if(phone.getBrand() == null || phone.getBrand().trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        if(phone.getModel() == null || phone.getModel().trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        if(phone.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        phoneDAO.add(phone);
    }

    @Override
    public void deleteById(int phoneId) {
        if(phoneId <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if(!phoneDAO.existsById(phoneId)) {
            throw new IllegalArgumentException("Phone with ID " + phoneId + " does not exist");
        }
        phoneDAO.deleteById(phoneId);
    }

    @Override
    public List<Phone> findAll() {
        return phoneDAO.findAll();
    }

    @Override
    public Phone findById(int phoneId) {
        if(phoneId <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        return phoneDAO.findById(phoneId);
    }

    @Override
    public void updatePriceByModel(String model, double newPrice) {
        if(model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        if(newPrice <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        phoneDAO.updatePriceByModel(model, newPrice);
    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        return phoneDAO.filterByBrand(brand);
    }

    @Override
    public List<Phone> filterByPriceRange(double minPrice, double maxPrice) {
        if(minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Prices cannot be negative");
        }
        if(minPrice > maxPrice) {
            throw new IllegalArgumentException("Min price cannot be greater than max price");
        }
        return phoneDAO.filterByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Phone> filterByStorage(int storageCapacity) {
        if(storageCapacity <= 0) {
            throw new IllegalArgumentException("Storage capacity must be positive");
        }
        return phoneDAO.filterByStorage(storageCapacity);
    }

    @Override
    public List<Phone> sortByPriceAsc() {
        return phoneDAO.sortByPriceAsc();
    }

    @Override
    public List<Phone> sortByPriceDesc() {
        return phoneDAO.sortByPriceDesc();
    }

    @Override
    public boolean existsById(int phoneId) {
        if(phoneId <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        return phoneDAO.existsById(phoneId);
    }

    @Override
    public int countByBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        return phoneDAO.countByBrand(brand);
    }

    @Override
    public Phone findMostExpensive() {
        return phoneDAO.findMostExpensive();
    }

    @Override
    public Phone findCheapest() {
        return phoneDAO.findCheapest();
    }

    @Override
    public List<Phone> searchByModel(String keyword) {
        if(keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be empty");
        }
        return phoneDAO.searchByModel(keyword);
    }

    @Override
    public void updateStock(int phoneId, int quantity) {
        if(phoneId <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        phoneDAO.updateStock(phoneId, quantity);
    }

    @Override
    public void deleteByBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        phoneDAO.deleteByBrand(brand);
    }
}
