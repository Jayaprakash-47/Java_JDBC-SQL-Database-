package org.example.Person.personServices;

import org.example.Person.PersonDAO;
import org.example.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService{
    PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void createTable() {
        personDAO.createTable();
    }

    @Override
    public void add(Person person) {
        if(person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if(person.getName() == null || person.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(person.getAge() <= 0 || person.getAge() > 150) {
            throw new IllegalArgumentException("Age must be between 1 and 150");
        }
        personDAO.add(person);
    }

    @Override
    public void deleteById(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if(!personDAO.ExistsById(id)) {
            throw new IllegalArgumentException("Person with ID " + id + " does not exist");
        }
        personDAO.deleteById(id);
    }

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public void updateById(int id, Person person) {
        if(id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if(person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }
        if(person.getName() == null || person.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(person.getAge() <= 0 || person.getAge() > 150) {
            throw new IllegalArgumentException("Age must be between 1 and 150");
        }
        if(!personDAO.ExistsById(id)) {
            throw new IllegalArgumentException("Person with ID " + id + " does not exist");
        }
        personDAO.updateById(id, person);
    }

    @Override
    public List<Person> filterByAge(int age) {
        if(age <= 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 1 and 150");
        }
        return personDAO.filterByAge(age);
    }

    @Override
    public boolean ExistsById(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        return personDAO.ExistsById(id);
    }

    @Override
    public List<Person> sortByNameAsc() {
        return personDAO.sortByNameAsc();
    }
}
