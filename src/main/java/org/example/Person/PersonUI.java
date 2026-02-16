package org.example.Person;

import org.example.entity.Person;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PersonUI {
    static void main() {
        PersonDAO p=new PersonDAOImpl();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n1.Create a table\n2.Add a Person\n3.Delete a Person\n4.Get All the Persons\n5.Update Person By Id\n6.Filter Persons By Age\n7.Check whether the person exists or not ?\n8.Sort the Persons By Name");
        System.out.println("Enter the choice :");
        int choice=sc.nextInt();
        switch (choice){
            case 1:
                p.createTable();
                System.out.println("Table has been created successfully.....");
                break;
            case 2:
                System.out.println("Enter the name: ");
                String name=sc.next();
                System.out.println("Enter the age: ");
                int age=sc.nextInt();
                p.add(new Person(age,name));
                System.out.println("Data has been inserted successfully.....");
                break;
            case 3:
                System.out.println("Enter the id to delete: ");
                int id=sc.nextInt();
                p.deleteById(id);
                System.out.println("Data has been deleted successfully.....");
                break;
            case 4:
               List<Person>persons= p.findAll();
                for(Person person : persons)
                {
                    System.out.println(person);
                }
                break;
            case 5:
                System.out.println("Enter the id to update :");
                int uid=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the updated name: ");
                String uname=sc.nextLine();
                System.out.println("Enter the updated age: ");
                int uage=sc.nextInt();
                p.updateById(uid,new Person(uage,uname));
                System.out.println("Data has been updated successfully.....");
                break;
            case 6:
                System.out.println("Enter the age to filter: ");
                int fage=sc.nextInt();
                List<Person> filteredPersons = p.filterByAge(fage);
                for(Person person : filteredPersons)
                {
                    System.out.println(person);
                }
                break;
            case 7:
                System.out.println("Enter the id to check whether the person exists or not ?: ");
                int pid=sc.nextInt();
//                p.ExistsById(pid);
                System.out.println("Person with id: "+ pid + "exists ?: "+p.ExistsById(pid));
                break;
            case 8:
                List<Person>pe=p.sortByNameAsc();
                for(Person person : pe)
                {
                    System.out.println(person);
                }
                break;
            default:
                System.out.println("You have entered the invalid choice......");
                break;
        }
    }
}
