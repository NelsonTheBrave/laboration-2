package org.example;

public abstract class Monster implements Movable {
    int posX;
    int posY;
    int health;
    int strength;

    // Constructor
    Monster(int posX, int posY, int health, int strength) {
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.strength = strength;
    }

    @Override
    public void move(int x, int y, Maze maze) {
        this.posX += x;
        this.posY += y;
        // TODO: Something here to access Maze
    }
}