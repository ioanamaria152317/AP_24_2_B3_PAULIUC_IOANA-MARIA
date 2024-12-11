package org.example;

import lombok.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Stream;
public class Driver extends Person{
    //linked list + sorted by age + print = un to string ceva
    //private LinkedList<Driver> drivers=new LinkedList<>();


    //Stream<Driver> driversStream= drivers.stream();

    /*@Override
    public String toString() {
        return "Driver{" +
                "drivers=" + drivers.stream().sorted(Comparator.comparingInt(a -> this.getAge())) +
                '}';
    }*/
    public String toString(){
        return this.getName();
    }
}