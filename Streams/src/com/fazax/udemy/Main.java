package com.fazax.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> bingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50","g35",
                "I26", "I17", "I29",
                "071"
        );

        List<String> gNumbers = new ArrayList<>();

//  NON-Stream aproach
//        bingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")){
////                System.out.println(number);
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((s1,s2)-> s1.compareTo(s2));
//        gNumbers.forEach(s -> System.out.println(s));

        bingoNumbers
                .stream()
                .map(String::toUpperCase)   //function reference
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);  //terminate operation - ending stream (peek() - used for debugging)


        System.out.println("flatMap example");
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane", 25);
        Employee jack = new Employee("Jack", 40);
        Employee snow = new Employee("Snow", 21);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("collect() example - terminate operation");
//        List<String> sortedGNumbers = bingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : sortedGNumbers){
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println("reduce example");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);



    }
}
