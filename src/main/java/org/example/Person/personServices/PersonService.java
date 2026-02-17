package org.example.Person.personServices;

import org.example.entity.Person;

import java.util.List;

public interface PersonService {
    void createTable();
    void add(Person person);
    void deleteById(int id);
    List<Person> findAll();
    void updateById(int id,Person person);
    List<Person> filterByAge(int age);
    boolean ExistsById(int id);
    List<Person> sortByNameAsc();
}
