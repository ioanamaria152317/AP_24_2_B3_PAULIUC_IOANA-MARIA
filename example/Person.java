package org.example;

import com.sun.source.tree.Tree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
@Setter
public class Person {
    private List<Person> group =new ArrayList<>();
    private List<Person> whoIsDriving=new LinkedList<>();
    private TreeSet<Person> whoIsPassenger=new TreeSet<>();
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public List<Person> getGroup() {
        return group;
    }

    public Stream<Person> getWhoIsPassenger() {
        return group.stream().filter(Person::isPassanger);
    }

    public Stream<Person> getWhoIsDriving() {
        return group.stream().filter(Person::isDriver);
    }

    public void setGroup(List<Person> group) {
        this.group = group;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isDriver(){
        if (this instanceof Driver)
        return true;
        return false;
    }
    public boolean isPassanger(){
        if (this instanceof Passenger)
            return true;
        else return false;
    }

    /*@Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
       /* return "Person{" +
                "whoIsDriving=" + whoIsDriving.stream().filter(Person::isDriver) +
                '}';*/     //imi ret doar o referinta a obiectului stream
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        return getWhoIsDriving().sorted((a,b)->b.getAge()-a.getAge()).collect(Collectors.toList()).toString()+
                getWhoIsPassenger().sorted(comparator).collect(Collectors.toList());  //MEREU COLECTEZ TOT DIN STREAM INTR O LISTA, ALTFEL AM REFERINTA CRED
    }
    //imi ia to string de aici daca nu am un to string "local"
}
