package org.example.Product;

import org.example.DBConnection.DatabaseConnection;
import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void createTable() {
        try(Connection con= DatabaseConnection.getConnection();){
            String sql="Create table if not exists product(pid int primary key auto_increment,pname varchar(50),brand varchar(30),category varchar(30),price double,rating int,discount int)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Product product) {
        try(Connection con= DatabaseConnection.getConnection();){
            String sql="insert into product(pname,brand,category,price,rating,discount) values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,product.getPname());
            ps.setString(2,product.getBrand());
            ps.setString(3,product.getCategory());
            ps.setDouble(4,product.getPrice());
            ps.setInt(5,product.getRating());
            ps.setInt(6,product.getDiscount());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int pid) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="delete from product where pid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,pid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Product findById(int pid) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where pid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,pid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                return new Product(id,pname,brand,category,price,rating,discount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void updatePriceById(int pid, double newPrice) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="update product set price=? where pid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,newPrice);
            ps.setInt(2,pid);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> filterByBrand(String brand) {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where brand=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String b=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,b,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByCategory(String category) {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where category=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,category);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String cat=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,cat,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where price >=? and price <=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,minPrice);
            ps.setDouble(2,maxPrice);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> filterByRating(int rating) {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where rating=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,rating);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rat=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rat,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> sortByPriceAsc() {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product order by price asc";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Product> sortByPriceDesc() {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product order by price desc";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean existsById(int pid) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select count(*) from product where pid=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,pid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int count=rs.getInt(1);
                return count>0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public int countByBrand(String brand) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select count(*) from product where brand=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int count=rs.getInt(1);
                return count;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public Product findMostExpensive() {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where price=(select max(price) from product)";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                return new Product(pid,pname,brand,category,price,rating,discount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Product findCheapest() {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where price=(select min(price) from product)";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                return new Product(pid,pname,brand,category,price,rating,discount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from product where pname like ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"%" + keyword + "%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int pid=rs.getInt("pid");
                String pname=rs.getString("pname");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double price=rs.getDouble("price");
                int rating=rs.getInt("rating");
                int discount=rs.getInt("discount");
                list.add(new Product(pid,pname,brand,category,price,rating,discount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void deleteByBrand(String brand) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="delete from product where brand=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
