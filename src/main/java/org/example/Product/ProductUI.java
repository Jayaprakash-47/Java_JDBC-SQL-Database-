package org.example.Product;

import org.example.Phone.phoneServices.PhoneService;
import org.example.Product.productServices.ProductService;
import org.example.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class ProductUI {
    public static void main(String[] args) {
        ApplicationContext ctxt=new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService productService=ctxt.getBean(ProductService.class);
//        ProductDAO dao = new ProductDAOImpl();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n1.Create Table\n2.Add Product\n3.Delete Product\n4.Find All\n5.Find By Id\n6.Update Price By Id\n7.Filter By Brand\n8.Filter By Category\n9.Filter By Price Range\n10.Filter By Rating\n11.Sort By Price Asc\n12.Sort By Price Desc\n13.Exists By Id\n14.Count By Brand\n15.Find Most Expensive\n16.Find Cheapest\n17.Search By Name\n18.Delete By Brand");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1:
                productService.createTable();
                System.out.println("Table created successfully");
                break;
            case 2:
                System.out.print("Enter product name: ");
                String pname = sc.next();
                System.out.print("Enter brand: ");
                String brand = sc.next();
                sc.nextLine();
                System.out.print("Enter category: ");
                String category = sc.next();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter rating: ");
                int rating = sc.nextInt();
                System.out.print("Enter discount: ");
                int discount = sc.nextInt();
                productService.add(new Product(pname, brand, category, price, rating, discount));
                System.out.println("Product added successfully");
                break;
            case 3:
                System.out.print("Enter product id: ");
                int pid = sc.nextInt();
                productService.deleteById(pid);
                System.out.println("Product deleted successfully");
                break;
            case 4:
                List<Product> all = productService.findAll();
                for(Product p : all) {
                    System.out.println(p);
                }
                break;
            case 5:
                System.out.print("Enter product id: ");
                int fid = sc.nextInt();
                Product product = productService.findById(fid);
                System.out.println(product);
                break;
            case 6:
                System.out.print("Enter product id: ");
                int upid = sc.nextInt();
                System.out.print("Enter new price: ");
                double nprice = sc.nextDouble();
                productService.updatePriceById(upid, nprice);
                System.out.println("Price updated successfully");
                break;
            case 7:
                System.out.print("Enter brand: ");
                String fbrand = sc.next();
                List<Product> brandList = productService.filterByBrand(fbrand);
                for(Product p : brandList) {
                    System.out.println(p);
                }
                break;
            case 8:
                System.out.print("Enter category: ");
                String fcat = sc.next();
                List<Product> catList = productService.filterByCategory(fcat);
                for(Product p : catList) {
                    System.out.println(p);
                }
                break;
            case 9:
                System.out.print("Enter min price: ");
                double min = sc.nextDouble();
                System.out.print("Enter max price: ");
                double max = sc.nextDouble();
                List<Product> priceList = productService.filterByPriceRange(min, max);
                for(Product p : priceList) {
                    System.out.println(p);
                }
                break;
            case 10:
                System.out.print("Enter rating: ");
                int frating = sc.nextInt();
                List<Product> ratingList = productService.filterByRating(frating);
                for(Product p : ratingList) {
                    System.out.println(p);
                }
                break;
            case 11:
                List<Product> ascList = productService.sortByPriceAsc();
                for(Product p : ascList) {
                    System.out.println(p);
                }
                break;
            case 12:
                List<Product> descList = productService.sortByPriceDesc();
                for(Product p : descList) {
                    System.out.println(p);
                }
                break;
            case 13:
                System.out.print("Enter product id: ");
                int eid = sc.nextInt();
                System.out.println("Exists: " + productService.existsById(eid));
                break;
            case 14:
                System.out.print("Enter brand: ");
                String cbrand = sc.next();
                System.out.println("Count: " + productService.countByBrand(cbrand));
                break;
            case 15:
                Product expensive = productService.findMostExpensive();
                System.out.println(expensive);
                break;
            case 16:
                Product cheapest = productService.findCheapest();
                System.out.println(cheapest);
                break;
            case 17:
                System.out.print("Enter keyword: ");
                String keyword = sc.next();
                List<Product> searchList = productService.searchByName(keyword);
                for(Product p : searchList) {
                    System.out.println(p);
                }
                break;
            case 18:
                System.out.print("Enter brand: ");
                String dbrand = sc.next();
                productService.deleteByBrand(dbrand);
                System.out.println("Products deleted successfully");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
