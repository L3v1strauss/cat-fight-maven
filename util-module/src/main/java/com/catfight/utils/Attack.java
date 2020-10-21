package com.catfight.utils;

import com.catfight.entities.Cat;

public class Attack {

    public static void singleAttack(Cat cat1, Cat cat2) {
        if (cat1.getHealth() == 0) {
            System.out.println(cat1.getName() + " проиграл");
        } else if (CriticalAttack.isCriticalChance(cat1) && cat2.getHealth() > 0
                && cat2.getHealth() <= CriticalAttack.criticalStrike(cat1)) {
            System.out.println(cat1.getName() + " аттакует и наносит критический урон "
                    + CriticalAttack.criticalStrike(cat1));
            cat2.setHealth(0);
            System.out.println(cat1.getName() + " одерживает победу");
        } else if (cat2.getHealth() > 0 && cat2.getHealth() <= cat1.getDamage()) {
            System.out.println(cat1.getName() + " аттакует и наносит урон " + cat1.getDamage());
            cat2.setHealth(0);
            System.out.println(cat1.getName() + " одерживает победу");
        } else if (CriticalAttack.isCriticalChance(cat1) && cat2.getHealth() > CriticalAttack.criticalStrike(cat1)) {
            System.out.println(cat1.getName() + " аттакует и наносит критический урон "
                    + CriticalAttack.criticalStrike(cat1));
            cat2.setHealth(cat2.getHealth() - CriticalAttack.criticalStrike(cat1));
        } else {
            System.out.println(cat1.getName() + " аттакует и наносит урон " + cat1.getDamage());
            cat2.setHealth(cat2.getHealth() - cat1.getDamage());
        }
    }
}
