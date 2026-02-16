package org.example.Phone;

import org.example.entity.Phone;
import java.util.List;
import java.util.Scanner;

public class PhoneUI {
    static void main() {
        PhoneDAO dao = new PhoneDAOImpl();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n1.Create Table\n2.Add Phone\n3.Delete Phone\n4.Find All\n5.Find By Id\n6.Update Price By Model\n7.Filter By Brand\n8.Filter By Price Range\n9.Filter By Storage\n10.Sort By Price Asc\n11.Sort By Price Desc\n12.Exists By Id\n13.Count By Brand\n14.Find Most Expensive\n15.Find Cheapest\n16.Search By Model\n17.Delete By Brand");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1:
                dao.createTable();
                System.out.println("Table created successfully");
                break;
            case 2:
                System.out.print("Enter brand: ");
                String brand = sc.next();
                System.out.print("Enter model: ");
                String model = sc.next();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter storage: ");
                int storage = sc.nextInt();
                System.out.print("Enter color: ");
                String color = sc.next();
                System.out.print("Enter screen size: ");
                double screen = sc.nextDouble();
                System.out.print("Enter battery: ");
                int battery = sc.nextInt();
                dao.add(new Phone(brand, model, price, storage, color, screen, battery));
                System.out.println("Phone added successfully");
                break;
            case 3:
                System.out.print("Enter phone id: ");
                int id = sc.nextInt();
                dao.deleteById(id);
                System.out.println("Phone deleted successfully");
                break;
            case 4:
                List<Phone> all = dao.findAll();
                for(Phone p : all) {
                    System.out.println(p);
                }
                break;
            case 5:
                System.out.print("Enter phone id: ");
                int fid = sc.nextInt();
                Phone phone = dao.findById(fid);
                System.out.println(phone);
                break;
            case 6:
                System.out.print("Enter model: ");
                String umodel = sc.next();
                System.out.print("Enter new price: ");
                double nprice = sc.nextDouble();
                dao.updatePriceByModel(umodel, nprice);
                System.out.println("Price updated successfully");
                break;
            case 7:
                System.out.print("Enter brand: ");
                String fbrand = sc.next();
                List<Phone> brandList = dao.filterByBrand(fbrand);
                for(Phone p : brandList) {
                    System.out.println(p);
                }
                break;
            case 8:
                System.out.print("Enter min price: ");
                double min = sc.nextDouble();
                System.out.print("Enter max price: ");
                double max = sc.nextDouble();
                List<Phone> priceList = dao.filterByPriceRange(min, max);
                for(Phone p : priceList) {
                    System.out.println(p);
                }
                break;
            case 9:
                System.out.print("Enter storage: ");
                int stor = sc.nextInt();
                List<Phone> storList = dao.filterByStorage(stor);
                for(Phone p : storList) {
                    System.out.println(p);
                }
                break;
            case 10:
                List<Phone> ascList = dao.sortByPriceAsc();
                for(Phone p : ascList) {
                    System.out.println(p);
                }
                break;
            case 11:
                List<Phone> descList = dao.sortByPriceDesc();
                for(Phone p : descList) {
                    System.out.println(p);
                }
                break;
            case 12:
                System.out.print("Enter phone id: ");
                int eid = sc.nextInt();
                System.out.println("Exists: " + dao.existsById(eid));
                break;
            case 13:
                System.out.print("Enter brand: ");
                String cbrand = sc.next();
                System.out.println("Count: " + dao.countByBrand(cbrand));
                break;
            case 14:
                Phone expensive = dao.findMostExpensive();
                System.out.println(expensive);
                break;
            case 15:
                Phone cheapest = dao.findCheapest();
                System.out.println(cheapest);
                break;
            case 16:
                System.out.print("Enter keyword: ");
                String keyword = sc.next();
                List<Phone> searchList = dao.searchByModel(keyword);
                for(Phone p : searchList) {
                    System.out.println(p);
                }
                break;
            case 17:
                System.out.print("Enter brand: ");
                String dbrand = sc.next();
                dao.deleteByBrand(dbrand);
                System.out.println("Phones deleted successfully");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
