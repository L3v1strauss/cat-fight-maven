package com.catfight.utils;

import com.catfight.entities.Cat;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class SavedGame {

    public static void saved(Cat cat1, Cat cat2) throws IOException, URISyntaxException, NullPointerException {
        Path path1 = Path.of(ClassLoader.getSystemResource("myfiles/catNumberOne.out").toURI());
        Path path2 = Path.of(ClassLoader.getSystemResource("myfiles/catNumberTwo.out").toURI());
        if (cat1.getHealth() < 50 && Files.readAllBytes(path1).length == 0 && Files.readAllBytes(path2).length == 0 ||
                cat2.getHealth() < 50 && Files.readAllBytes(path1).length == 0 && Files.readAllBytes(path1).length == 0) {
            Scanner scanner = new Scanner(System.in);
            String yes = "YES";
            if (cat1.getHealth() < 50) {
                System.out.println("У " + cat1.getName() + " осталось мало здоровья хотите сохранить игру? Введите YES/NO");
            } else {
                System.out.println("У " + cat2.getName() + " осталось мало здоровья хотите сохранить игру? Введите YES/NO");
            }
            if (yes.equalsIgnoreCase(scanner.nextLine())) {
                System.out.println("Игра сохранена)");
                try (ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream(path1.toFile()));
                     ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(path2.toFile()))) {
                    objectOutputStream1.writeObject(cat1);
                    objectOutputStream2.writeObject(cat2);
                }
            } else {
                System.out.println("Игра не сохранена(");
            }
        }
    }

    public static void gameContinued() throws IOException, URISyntaxException {
        Path path1 = Path.of(ClassLoader.getSystemResource("myfiles/catNumberOne.out").toURI());
        Path path2 = Path.of(ClassLoader.getSystemResource("myfiles/catNumberTwo.out").toURI());
        System.out.println("Начать с сохраненного пункта? YES/NO");
        Scanner scanner = new Scanner(System.in);
        String yes = "YES";
        if (yes.equalsIgnoreCase(scanner.nextLine()) && Files.exists(path1) && Files.exists(path2)) {
            try (ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(path1.toFile()));
                 ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(path2.toFile()))) {
                Cat cat1 = (Cat) objectInputStream1.readObject();
                Cat cat2 = (Cat) objectInputStream2.readObject();
                while (cat1.getHealth() > 0 && cat2.getHealth() > 0) {
                    Attack.singleAttack(cat1, cat2);
                    Attack.singleAttack(cat2, cat1);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("GAME OVER");
        }
        if (Files.readAllBytes(path1).length > 0 && Files.readAllBytes(path1).length > 0) {
            Files.newBufferedWriter(path1, StandardOpenOption.TRUNCATE_EXISTING);
            Files.newBufferedWriter(path2, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
