package org.example;

public class Upgrade extends Item {
    String type;

    Upgrade(int posX, int posY, String type) {
        super(posX, posY);
        this.type = type;
    }
}
