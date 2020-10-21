package com.catfight.api.services;

import com.catfight.entities.Cat;

import java.util.List;
import java.util.Map;

public interface ICatService {

    List<Cat> getCats();

    Map<Cat, Integer> getFightCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    int getCatHealth(String name);
}
