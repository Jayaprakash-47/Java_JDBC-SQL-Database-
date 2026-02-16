package org.example.Person;

import org.example.DBConnection.DatabaseConnection;
import org.example.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public void createTable() {
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "CREATE TABLE IF NOT EXISTS person(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Person person) {
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "insert into person(name,age) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setInt(2,person.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "delete from person where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person>list=new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "select *from person";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                list.add(new Person(id,name,age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;

    }

    @Override
    public void updateById(int id, Person person) {
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "update person set name = ?,age= ? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setInt(2,person.getAge());
            ps.setInt(3,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Person> filterByAge(int age) {
        List<Person>p=new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "select * from person where age = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,age);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int a=rs.getInt("age");
                p.add(new Person(id,name,a));
//                System.out.println("Id:"+id+" name :"+name+" Age:"+a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public boolean ExistsById(int id) {
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "select count(*) from person where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Person> sortByNameAsc() {
        List<Person>l=new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();) {
            String sql = "select * from person order by name asc";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                l.add(new Person(id,name,age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return l;
    }
}
