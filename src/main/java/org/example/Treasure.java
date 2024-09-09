package org.example;

public class Treasure extends Item {
    String type;

    Treasure(int posX, int posY, String type) {
        super(posX, posY);
        this.type = type;
    }
}