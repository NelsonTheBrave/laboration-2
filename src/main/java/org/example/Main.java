package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MazeContentGenerator mazeContentGenerator = new MazeContentGenerator();

        Maze[] maze = new Maze[100];
        int posX = 1;
        int posY = 1;
        for (int i = 0; i < maze.length; i++) {
            String mazeContent = mazeContentGenerator.getMazeContent();
            maze[i] = new Maze(posX, posY, mazeContent);
            posY++;
            if (posY == 11) {
                posY = 1;
                posX++;
            }
            System.out.println("Index: " + i + " X: " + maze[i].getPosX() + " Y: " + maze[i].getPosY() + " Content: " + maze[i].getContent());
        }
        Player player1 = new Player("Jörgen", 1, 1, 100, 30, new String[]{"sword", "axe"});
        System.out.println("Player's position is X: " + player1.posX + ", Y: " + player1.posY);
        boolean awaitingChoice = true;
        while (awaitingChoice) {

            System.out.println("Please enter desired direction to move player (a, s, d, w or q to quit)");
            char direction = scanner.next().charAt(0);
            switch (direction) {
                case 'a':
                    player1.move(-1, 0, maze);
                    break;
                case 's':
                    player1.move(0, -1, maze);
                    break;
                case 'd':
                    player1.move(1, 0, maze);
                    break;
                case 'w':
                    player1.move(0, 1, maze);
                    break;
                case 'q':
                    awaitingChoice = false;
                    System.out.println("Goodbye");
                default:
                    System.out.println("You must enter a valid move direction!");
            }
        }
    }

    void mazeRandomizer() {

    }

}

class MazeContentGenerator { // Should this one be on the Maze class perhaps?
    private static final String[] CONTENT = {"wall", "void", "monster", "item"};
    private static final Random RANDOM = new Random();

    // Method to return a random string from the OPTIONS array
    public static String getMazeContent() {
        int index = RANDOM.nextInt(CONTENT.length);
        return CONTENT[index];
    }
}

class Player implements Movable {
    final String name;
    int posX;
    int posY;
    int health;
    int strength;
    String[] items;

    // Constructor
    Player(String name, int posX, int posY, int health, int strength, String[] items) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.health = health;
        this.strength = strength;
        this.items = items;
    }

    public String getItems(int index) {
        return items[index];
    }

    @Override
    public void move(int x, int y, Maze[] maze) {
        String mazeContent = "void";
        for (Maze m : maze) {
            if (m.getPosX() == this.posX + x && m.getPosY() == this.posY + y) {
                mazeContent = m.getContent();
            }
        }
        switch (mazeContent) {
            case "wall":
                System.out.println("You can't move there!");
                break;
            case "monster":
                System.out.println("You hit a monster!");
                this.health -= 10;
                break;
            case "item":
                System.out.println("You found an item!");
                break;
            case "void":
                this.posX += x;
                this.posY += y;
                System.out.println(this.name + " moved to X: " + this.posX + " Y: " + this.posY);
                break;
        }
    }
}

class Maze {
    int posX;
    int posY;
    String content; // Can have one of following: void, wall, monster, item

    Maze(int posX, int posY, String content) {
        this.posX = posX;
        this.posY = posY;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

//    void drawMaze() {
//        this
//    }
}

class Item { // Superclass to more specific items
    int posX;
    int posY;

    Item(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}

class Treasure extends Item {
    String type;

    Treasure(int posX, int posY, String type) {
        super(posX, posY);
        this.type = type;
    }
}

class Upgrade extends Item {
    String type;

    Upgrade(int posX, int posY, String type) {
        super(posX, posY);
        this.type = type;
    }
}

abstract class Monster implements Movable {
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
    public void move(int x, int y, Maze[] maze) {
        this.posX += x;
        this.posY += y;
        // TODO: Something here to access Maze
    }
}


interface Movable {
    void move(int x, int y, Maze[] maze);
}

/* TODO:
    - Where and how do I place classes and methods?
    - MazeGenerator in Maze class?
 */