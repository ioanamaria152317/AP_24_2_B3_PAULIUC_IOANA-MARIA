package com.example.lab9.repositories;

import com.example.lab9.entities.Book;
import com.example.lab9.entities.PublishingHouse;

public class PublishingHouseRepository extends DataRepository<PublishingHouse,Long> {
    protected Class<PublishingHouse> getEntityClass() {
        return PublishingHouse.class;
    }
}
