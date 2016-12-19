package com.fazax.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee timi = new Employee("Timi Some", 29);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 19);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(timi);
        employees.add(jack);
        employees.add(snow);

        printEmployeesByAge(employees,"Employees under 40",employee -> employee.getAge() < 40);

    }

    private static void printEmployeesByAge (List<Employee> employees,
                                             String ageText,
                                             Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==================");
        employees.forEach(employee -> {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        });
    }

}


//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        System.out.println("List of employees:");
//        for(Employee employee : employees) {
//            System.out.println("\t" + employee.getName() + "\tAge: " + employee.getAge() + ".");
//        }
//
//        String sillyString = doStringStuff((s1, s2) -> s1.toUpperCase() + s2.toUpperCase(),
//                employees.get(0).getName(),
//                employees.get(1).getName()
//        );
//        System.out.println(sillyString);
//
//        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);
//    }
//
//    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
//        return uc.upperAndConcat(s1,s2);
//    }
//}


//interface UpperConcat {
//    String upperAndConcat(String s1, String s2);
//}
//class AnotherClass {
//    public String doSomething() {
//
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class name is: " + getClass().getSimpleName());
//            return s1.toUpperCase() + s2.toUpperCase();
//        };
//
//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//
//        return Main.doStringStuff(uc,"String 1","String2");

//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        },"String1", "String2");
//    }
//}
