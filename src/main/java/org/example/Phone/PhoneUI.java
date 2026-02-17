package org.example.Phone;

import org.example.Phone.phoneServices.PhoneService;
import org.example.Phone.phoneServices.PhoneServiceImpl;
import org.example.entity.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;
@Configuration
public class PhoneUI {
    @Bean
    public PhoneDAO phoneDAO(){
        return new PhoneDAOImpl();
    }
    @Bean
    public PhoneService phoneService(PhoneDAO phoneDAO){
        return new PhoneServiceImpl(phoneDAO);
    }
    static void main() {

        ApplicationContext ctxt=new AnnotationConfigApplicationContext(PhoneUI.class);
        PhoneService phoneService=ctxt.getBean(PhoneService.class);
//        PhoneDAO dao = new PhoneDAOImpl();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n1.Create Table\n2.Add Phone\n3.Delete Phone\n4.Find All\n5.Find By Id\n6.Update Price By Model\n7.Filter By Brand\n8.Filter By Price Range\n9.Filter By Storage\n10.Sort By Price Asc\n11.Sort By Price Desc\n12.Exists By Id\n13.Count By Brand\n14.Find Most Expensive\n15.Find Cheapest\n16.Search By Model\n17.Delete By Brand");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1:
                phoneService.createTable();
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
                phoneService.add(new Phone(brand, model, price, storage, color, screen, battery));
                System.out.println("Phone added successfully");
                break;
            case 3:
                System.out.print("Enter phone id: ");
                int id = sc.nextInt();
                phoneService.deleteById(id);
                System.out.println("Phone deleted successfully");
                break;
            case 4:
                List<Phone> all = phoneService.findAll();
                for(Phone p : all) {
                    System.out.println(p);
                }
                break;
            case 5:
                System.out.print("Enter phone id: ");
                int fid = sc.nextInt();
                Phone phone = phoneService.findById(fid);
                System.out.println(phone);
                break;
            case 6:
                System.out.print("Enter model: ");
                String umodel = sc.next();
                System.out.print("Enter new price: ");
                double nprice = sc.nextDouble();
                phoneService.updatePriceByModel(umodel, nprice);
                System.out.println("Price updated successfully");
                break;
            case 7:
                System.out.print("Enter brand: ");
                String fbrand = sc.next();
                List<Phone> brandList = phoneService.filterByBrand(fbrand);
                for(Phone p : brandList) {
                    System.out.println(p);
                }
                break;
            case 8:
                System.out.print("Enter min price: ");
                double min = sc.nextDouble();
                System.out.print("Enter max price: ");
                double max = sc.nextDouble();
                List<Phone> priceList = phoneService.filterByPriceRange(min, max);
                for(Phone p : priceList) {
                    System.out.println(p);
                }
                break;
            case 9:
                System.out.print("Enter storage: ");
                int stor = sc.nextInt();
                List<Phone> storList = phoneService.filterByStorage(stor);
                for(Phone p : storList) {
                    System.out.println(p);
                }
                break;
            case 10:
                List<Phone> ascList = phoneService.sortByPriceAsc();
                for(Phone p : ascList) {
                    System.out.println(p);
                }
                break;
            case 11:
                List<Phone> descList = phoneService.sortByPriceDesc();
                for(Phone p : descList) {
                    System.out.println(p);
                }
                break;
            case 12:
                System.out.print("Enter phone id: ");
                int eid = sc.nextInt();
                System.out.println("Exists: " + phoneService.existsById(eid));
                break;
            case 13:
                System.out.print("Enter brand: ");
                String cbrand = sc.next();
                System.out.println("Count: " + phoneService.countByBrand(cbrand));
                break;
            case 14:
                Phone expensive = phoneService.findMostExpensive();
                System.out.println(expensive);
                break;
            case 15:
                Phone cheapest = phoneService.findCheapest();
                System.out.println(cheapest);
                break;
            case 16:
                System.out.print("Enter keyword: ");
                String keyword = sc.next();
                List<Phone> searchList = phoneService.searchByModel(keyword);
                for(Phone p : searchList) {
                    System.out.println(p);
                }
                break;
            case 17:
                System.out.print("Enter brand: ");
                String dbrand = sc.next();
                phoneService.deleteByBrand(dbrand);
                System.out.println("Phones deleted successfully");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
