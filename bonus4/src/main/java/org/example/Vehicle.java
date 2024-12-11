package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehicle {
        private Driver driver;
        private List<Passenger> passengers;
        Vehicle(Driver driver){
            this.driver=driver;
            passengers = new ArrayList<>();
        }
        public boolean addPassenger(Passenger passenger) {
            if (passengers.isEmpty()) {
                passengers.add(passenger);
                return true;
            }
            return false;
        }
}

