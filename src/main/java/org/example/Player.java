package org.example;

public class Player implements Movable {
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
        String mazeContent = "void";
        for (int i = 0; i < maze.maze.length; i++) {
            if (maze.maze[i].getX() == this.posX + x && maze.maze[i].getY() == this.posY + y) {
                mazeContent = maze.maze[i].getContent();
            }
        }
        switch (mazeContent) {
            case "wall":
                System.out.println("You can't move there!");
                break;
            case "monster":
                System.out.println("You hit a monster!");
                this.posX += x;
                this.posY += y;                this.posX += x;
                this.health -= 10;
                break;
            case "item":
                System.out.println("You found an item!");
                this.posX += x;
                this.posY += y;                this.posX += x;
                break;
            case "void":
                this.posX += x;
                this.posY += y;                this.posX += x;
//                System.out.println(this.name + " moved to X: " + this.posX + " Y: " + this.posY);
                break;
        }
    }
}
