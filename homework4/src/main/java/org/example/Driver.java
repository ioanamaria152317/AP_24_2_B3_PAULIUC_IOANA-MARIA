package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class Driver extends Person{
    public Driver(String name, Destination destination) {
        super.setName(name);
        super.setDestination(destination);
    }
    private List<Destination> destinationsBefore;

}
