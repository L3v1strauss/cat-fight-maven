package com.catfight.entities;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {

    private String name;

    public Cat(int health, int damage, int agility, int strenght) {
        super(health, damage, agility, strenght);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
        System.out.println("Оставшееся здоровье " + this.getName() + ": " + this.getHealth() + " едениц");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' + "health" + getHealth() +
                '}';
    }
}
