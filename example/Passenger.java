package org.example;

import lombok.*;

import java.util.Comparator;
import java.util.TreeSet;

public class Passenger extends Person{
  // private TreeSet<Passenger> pasageri=new TreeSet<>();

    @Override
    public String toString() {
        return this.getName();
    }
}
