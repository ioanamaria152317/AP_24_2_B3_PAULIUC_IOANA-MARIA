package com.example.lab9.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="publishinghouse", schema ="public")
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "publishing_house_id")
    private List<Book> books = new ArrayList<>();
}
