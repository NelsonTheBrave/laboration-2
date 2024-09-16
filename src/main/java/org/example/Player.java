package org.example;

import java.util.HashSet;
import java.util.Set;

public class Player implements Movable {
    final String name;
    int posX;
    int posY;
    int health;
    int strength;
    Set<String> items = new HashSet<>();

    // Constructor
    Player(String name, int posX, int posY, int health, int strength) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.strength = strength;
        this.items.add("Wooden Sword");
    }

    public Set<String> getItems() {
        return items;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public void move(int x, int y, Maze maze) {
        Object mazeContent = null; // Null pointer?
        for (int i = 0; i < maze.maze.length; i++) {
            if (maze.maze[i].getX() == this.posX + x && maze.maze[i].getY() == this.posY + y) {
                mazeContent = maze.maze[i].getContent();
            }
        }
        switch (mazeContent) {
            case Wall wall:
                System.out.println("You can't move there!");
                break;
            case Monster monster:
                System.out.println("You hit a monster!");
                this.posX += x;
                this.posY += y;
                this.health -= 10;
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Treasure treasure:
                this.posX += x;
                this.posY += y;

                this.items.add(treasure.type);
                System.out.println("You found the " + treasure.type + "!");
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Upgrade upgrade:
                System.out.println("You found a health upgrade! Your health increased by 10");
                this.posX += x;
                this.posY += y;
                this.health += 10;
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Emptiness emptiness:
                this.posX += x;
                this.posY += y;
                break;
            case null:
                System.out.println("You can't move there! It's a wall");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mazeContent);
        }
    }
}
