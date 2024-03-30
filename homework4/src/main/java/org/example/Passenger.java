package org.example;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Passenger extends Person{
    public Passenger(String name, Destination destination) {
        super.setName(name);
        super.setDestination(destination);
    }
}
