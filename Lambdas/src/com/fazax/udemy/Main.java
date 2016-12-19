package com.fazax.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        new Thread(() -> System.out.println("Hello from the Runnable")).start();

        Employee john = new Employee("John Doe", 30);
        Employee timi = new Employee("Timi Some", 29);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 19);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(timi);
        employees.add(jack);
        employees.add(snow);

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        System.out.println("List of employees:");
        for(Employee employee : employees) {
            System.out.println("\t" + employee.getName() + "\tAge: " + employee.getAge() + ".");
        }

        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
            employees.get(0).getName(),
            employees.get(1).getName()
        );
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1,s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}
class AnotherClass {
    public String doSomething() {

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class name is: " + getClass().getSimpleName());
            return s1.toUpperCase() + s2.toUpperCase();
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());

        return Main.doStringStuff(uc,"String 1","String2");

//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },"String1", "String2");
    }
}