package org.example;

public class Monster implements Movable {
    int posX;
    int posY;
    int health;
    int strength;

    // Constructor
    Monster(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.health = 100;
        this.strength = 20;
    }

    @Override
    public void move(int x, int y, Maze maze) {
        Object mazeContent = null;
        for (int i = 0; i < maze.maze.length; i++) {
            if (maze.maze[i].getX() == this.posX + x && maze.maze[i].getY() == this.posY + y) {
                mazeContent = maze.maze[i].getContent();
            }
        }
        switch (mazeContent) {
            case Wall wall:
                break;
            case Monster monster:
                this.posX += x;
                this.posY += y;
                for (int i = 0; i < maze.maze.length; i++) {
                    if (maze.maze[i].getX() == this.posX && maze.maze[i].getY() == this.posY) {
                        maze.setSquareContent(this.posX, this.posY, new Monster(this.posX, this.posY));
                    }
                }
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Treasure treasure:
                this.posX += x;
                this.posY += y;
                for (int i = 0; i < maze.maze.length; i++) {
                    if (maze.maze[i].getX() == this.posX && maze.maze[i].getY() == this.posY) {
                        maze.setSquareContent(this.posX, this.posY, new Monster(this.posX, this.posY));
                    }
                }
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Upgrade upgrade:
                this.posX += x;
                this.posY += y;
                for (int i = 0; i < maze.maze.length; i++) {
                    if (maze.maze[i].getX() == this.posX && maze.maze[i].getY() == this.posY) {
                        maze.setSquareContent(this.posX, this.posY, new Monster(this.posX, this.posY));
                    }
                }
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case Emptiness emptiness:
                this.posX += x;
                this.posY += y;
                for (int i = 0; i < maze.maze.length; i++) {
                    if (maze.maze[i].getX() == this.posX && maze.maze[i].getY() == this.posY) {
                        maze.setSquareContent(this.posX, this.posY, new Monster(this.posX, this.posY));
                    }
                }
                maze.setSquareContent(this.posX, this.posY, new Emptiness(this.posX, this.posY));
                break;
            case null:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mazeContent);
        }
    }
}
