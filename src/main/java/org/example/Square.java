package org.example;

public class Square {
    private int x;
    private int y;
    private Object content;

    // Constructor for Square
    public Square(int x, int y, Object content) {
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

    public Object getContent() {
        return content;
    }
    public void setContent(Object content) {
        this.content = content;
    }
}