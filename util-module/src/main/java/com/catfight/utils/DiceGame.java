package com.catfight.utils;

import com.catfight.entities.Cat;
import com.catfight.api.exceptions.DiceGameException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class DiceGame {

    public static int rollDice() {
        Random random = new Random();
        int x = random.nextInt(12);
        try {
            zero(x);
        } catch (DiceGameException exception) {
            System.out.println("У одного из котов кости упали на ребро");
        }
        return x;
    }

    public static void zero(int value) throws DiceGameException {
        if (value == 0) {
            throw new DiceGameException("Error");
        }
    }

    public static void thatFighters(Map<Cat, Integer> fightCats, List<Cat> cats) {
        for (Cat cat : cats) {
            fightCats.put(cat, rollDice());
        }
        fightCats.forEach((key, value) -> System.out.format("%s кинул кости и кости показали %d%n",
                key.getName(), value));
        System.out.println("На арену выходит " + DiceGame.fighterName1(fightCats));
        System.out.println("На арену выходит " + DiceGame.fighterName2(fightCats));
    }

    public static String fighterName1(Map<Cat, Integer> fightCats) {
        return fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(1).map(x -> x.getKey().getName()).collect(Collectors.joining());
    }

    public static String fighterName2(Map<Cat, Integer> fightCats) {
        return fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .skip(1).limit(1).map(x -> x.getKey().getName()).collect(Collectors.joining());
    }
}
