package org.example;

import java.util.Random;

public class Maze {
    Square[] maze;

    Maze(int size) {
        maze = new Square[size];


        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < maze.length; i++) {
            String mazeContent = generateMazeContent();
            maze[i] = new Square(xPos, yPos, mazeContent);
//            System.out.println("Index: " + i + " X: " + xPos + " Y: " + yPos + " Content: " + maze[i].getContent());
            xPos++;
            if (xPos == 30) {
                xPos = 0;
                yPos++;
            }
        }
    }

    public static String generateMazeContent() {
        String[] CONTENT = {"wall", "void", "monster", "item"};
        Random RANDOM = new Random();
        int index = RANDOM.nextInt(CONTENT.length);
        return CONTENT[index];
    }

    public String getSquareContent(int x, int y) {
        for (Square square : maze) {
            if (square.getX() == x && square.getY() == y) {
                return square.getContent();
            }
        }
        return null; // or return a specific string saying not found
    }

    public void printMaze(int xPos, int yPos) { // TODO: Break out variable for maze width
        int mazeWidth = 30;
        for (int i = 0; i < mazeWidth + 2; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            if (i == 0) {
                System.out.print("|");
            } else if (i % mazeWidth == 0 && i != maze.length - 1) {
                System.out.print("|");
                System.out.println();
                System.out.print("|");
            }
            if (maze[i].getX() == xPos && maze[i].getY() == yPos) {
                System.out.print("P");
            } else {
                switch (maze[i].getContent()) {
                    case "wall":
                        System.out.print(".");
                        break;
                    case "void":
                        System.out.print(" ");
                        break;
                    case "monster":
                        System.out.print("o");
                        break;
                    case "item":
                        System.out.print("^");
                    default:
//                        System.out.print("D");
                        break;
                }
            }
            if (i == maze.length - 1) {
                System.out.print("|");
            }
        }
                System.out.println();
            for (int i = 0; i < mazeWidth + 2; i++) {
                System.out.print("-");
            }
            System.out.println();
    }
}