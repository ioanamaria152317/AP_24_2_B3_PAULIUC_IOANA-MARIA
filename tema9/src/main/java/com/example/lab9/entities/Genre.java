package com.example.lab9.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="genre",schema="public")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "id")
    private List<Book> books = new ArrayList<>();
//mapped by nu mi face coloana noua ?
}
