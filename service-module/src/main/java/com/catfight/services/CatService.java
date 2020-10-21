package com.catfight.services;

import com.catfight.api.dao.ICatDao;
import com.catfight.api.services.ICatService;
import com.catfight.dao.CatDao;
import com.catfight.entities.Cat;

import java.util.List;
import java.util.Map;

public class CatService implements ICatService {

    private final ICatDao catDao = new CatDao();

    @Override
    public List<Cat> getCats() {
        return catDao.getCats();
    }

    @Override
    public Map<Cat, Integer> getFightCats() {
        return catDao.getFightCats();
    }

    @Override
    public void addCat(Cat cat) {
        catDao.addCat(cat);
    }

    @Override
    public Cat getByName(String name) {
        return catDao.getByName(name);
    }

    @Override
    public int getCatHealth(String name) {
        return catDao.getCatHealth(name);
    }
}
