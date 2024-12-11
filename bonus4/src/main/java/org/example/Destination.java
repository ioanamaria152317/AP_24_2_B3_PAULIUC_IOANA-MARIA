package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private String name;

   /* Destination(String name){
        this.name=name;
    }
*/

    //daca adaug un nou camp, all args o sa aiba constr pt cele doua si nu mai am constr doar cu name
    //dc?????????????????????

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;  //runtime
        Destination that = (Destination) o;
        return Objects.equals(name, that.name);
    }
}
