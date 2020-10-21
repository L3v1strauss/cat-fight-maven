package com.catfight.utils;

import com.catfight.entities.Cat;

import java.util.Random;

public class CriticalAttack {

    public static boolean isCriticalChance(Cat cat) {
        boolean criticalChance;
        Random random = new Random();
        criticalChance = random.nextInt(30 / (cat.getAgility() + cat.getStrenght())) == 0;
        return criticalChance;
    }

    public static int criticalStrike(Cat cat) {
        return (cat.getDamage() * 2) + ((cat.getAgility() + cat.getStrenght()) / 2);
    }
}
