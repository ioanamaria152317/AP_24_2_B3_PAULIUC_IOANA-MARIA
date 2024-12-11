package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private Destination destination;

    public Person(String name, Destination destination) {
        this.name = name;
        this.destination=destination;
    }
    public boolean hasCommonDestination(Destination destination) {
        return this.destination.equals(destination);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
