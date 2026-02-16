package org.example.Phone;

import org.example.DBConnection.DatabaseConnection;
import org.example.entity.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl implements PhoneDAO {
    @Override
    public void createTable() {
        try(Connection con= DatabaseConnection.getConnection();){
            String sql="Create table if not exists phone(id int primary key auto_increment,brand varchar(20),model varchar(20),price double,storageCapacity int,color varchar(10),screenSize double,batteryCapacity int)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Phone phone) {
        try(Connection con= DatabaseConnection.getConnection();){
            String sql="insert into phone(brand,model,price,storageCapacity,color,screenSize,batteryCapacity) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,phone.getBrand());
            ps.setString(2,phone.getModel());
            ps.setDouble(3,phone.getPrice());
            ps.setInt(4,phone.getStorageCapacity());
            ps.setString(5,phone.getColor());
            ps.setDouble(6,phone.getScreenSize());
            ps.setInt(7,phone.getBatteryCapacity());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int phoneId) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="delete from phone where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,phoneId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> findAll() {
        List<Phone>li=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select *from phone";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                li.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return li;
    }

    @Override
    public Phone findById(int phoneId) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select *from phone where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,phoneId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                return new Phone(id,b,m,p,sc,c,ss,bc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    @Override
    public void updatePriceByModel(String model, double newPrice) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="update phone set price=? where model=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,newPrice);
            ps.setString(2,model);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        List<Phone>list=new ArrayList<>();
            try(Connection con=DatabaseConnection.getConnection();){
                String sql="select * from phone where brand=?";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,brand);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    int id=rs.getInt("id");
                    String b=rs.getString("brand");
                    String m=rs.getString("model");
                    Double p=rs.getDouble("price");
                    int sc=rs.getInt("storageCapacity");
                    String c=rs.getString("color");
                    Double ss=rs.getDouble("screenSize");
                    int bc=rs.getInt("batteryCapacity");
                    list.add(new Phone(id,b,m,p,sc,c,ss,bc));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return list;
        }


    @Override
    public List<Phone> filterByPriceRange(double minPrice, double maxPrice) {
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone where price >=? and price <= ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,minPrice);
            ps.setDouble(2,maxPrice);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                list.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    @Override
    public List<Phone> filterByStorage(int storageCapacity) {
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone where storageCapacity=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,storageCapacity);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                list.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> sortByPriceAsc() {
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone order by price asc";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                list.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> sortByPriceDesc() {
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone order by price desc";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                list.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean existsById(int phoneId) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select count(*) from phone where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,phoneId);
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
            String sql="select count(*) from phone where brand=?";
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
    public Phone findMostExpensive() {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select *from phone where price=(select max(price) from phone)";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                return new Phone(id,b,m,p,sc,c,ss,bc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Phone findCheapest() {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone where price=(select min(price) from phone)";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                return new Phone(id,b,m,p,sc,c,ss,bc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Phone> searchByModel(String keyword) {
        List<Phone>list=new ArrayList<>();
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="select * from phone where model like ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,"%" + keyword + "%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String b=rs.getString("brand");
                String m=rs.getString("model");
                Double p=rs.getDouble("price");
                int sc=rs.getInt("storageCapacity");
                String c=rs.getString("color");
                Double ss=rs.getDouble("screenSize");
                int bc=rs.getInt("batteryCapacity");
                list.add(new Phone(id,b,m,p,sc,c,ss,bc));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void updateStock(int phoneId, int quantity) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="update phone set stock=? where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,quantity);
            ps.setInt(2,phoneId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByBrand(String brand) {
        try(Connection con=DatabaseConnection.getConnection();){
            String sql="delete from phone where brand=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,brand);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
