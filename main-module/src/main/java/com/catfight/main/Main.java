package com.catfight.main;

import com.catfight.api.services.ICatService;
import com.catfight.entities.Cat;
import com.catfight.services.CatService;
import com.catfight.utils.Attack;
import com.catfight.utils.DiceGame;
import com.catfight.utils.Names;
import com.catfight.utils.SavedGame;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ICatService catService = new CatService();
        catService.addCat(new Cat(100, 5, 5, 5));
        catService.addCat(new Cat(100, 3, 10, 10));
        catService.addCat(new Cat(100, 1, 15, 15));
        catService.addCat(new Cat(100, 10, 2, 2));
        catService.addCat(new Cat(100, 6, 3, 4));
        catService.addCat(new Cat(100, 4, 7, 3));
        Names.nameCats(catService.getCats());
        DiceGame.thatFighters(catService.getFightCats(),catService.getCats());
        System.out.println();
        while (catService.getCatHealth(DiceGame.fighterName2(catService.getFightCats())) > 0
                && catService.getCatHealth(DiceGame.fighterName1(catService.getFightCats())) > 0) {
            SavedGame.saved(catService.getByName(DiceGame.fighterName1(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName2(catService.getFightCats())));
            Attack.singleAttack(catService.getByName(DiceGame.fighterName2(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName1(catService.getFightCats())));
            Attack.singleAttack(catService.getByName(DiceGame.fighterName1(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName2(catService.getFightCats())));
        }
        SavedGame.gameContinued();
    }
}
