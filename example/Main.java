package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person p=new Person();
        Person driver1=new Driver();
        driver1.setName("Cosmin");
        driver1.setAge(18);
        Person driver2=new Driver();
        driver2.setName("Andreea");
        driver2.setAge(20);
        Person passenger1=new Passenger();
        passenger1.setName("Maria");
        Person passenger2=new Passenger();
        passenger2.setName("Ioana");
        driver2.setAge(17);

        List<Person> list =new ArrayList<>();
        list.add(driver1);
        list.add(driver2);
        list.add(passenger1);
        list.add(passenger2);
        p.setGroup(list);
        //VREAU VAR AICI

        //System.out.println(p.getGroup());
        System.out.println(p);
    }
}