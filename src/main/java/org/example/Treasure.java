package org.example;

import java.util.Random;

public class Treasure extends Item {
    String type;

    Treasure(int posX, int posY) {
        super(posX, posY);
        this.type = generateTreasure();
    }

    public static String generateTreasure() {
        String[] CONTENT = {"Axe", "Shield", "Dagger", "Morning star"};
        Random RANDOM = new Random();
        int index = RANDOM.nextInt(CONTENT.length);
        return CONTENT[index];
    }
}