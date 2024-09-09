package org.example;

public class Square {
    private int x;
    private int y;
    private String content;

    // Constructor for Square
    public Square(int x, int y, String content) {
        this.x = x;
        this.y = y;
        this.content = content;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getContent() {
        return content;
    }
}