package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze(300);
        Player player1 = new Player("Jörgen", 0, 0, 100, 30, new String[]{"sword", "axe"});
//        System.out.println("Player's position is X: " + player1.posX + ", Y: " + player1.posY);
        maze.printMaze(player1.getPosX(), player1.getPosY());
        boolean awaitingChoice = true;
        while (awaitingChoice) {
            System.out.println();
            System.out.println("Please enter desired direction to move player (a, s, d, w or q to quit)");
            char direction = scanner.next().charAt(0);
            switch (direction) {
                case 'a':
                    player1.move(-1, 0, maze);
                    break;
                case 's':
                    player1.move(0, 1, maze);
                    break;
                case 'd':
                    player1.move(1, 0, maze);
                    break;
                case 'w':
                    player1.move(0, -1, maze);
                    break;
                case 'q':
                    awaitingChoice = false;
                    System.out.println("Goodbye");
                default:
                    System.out.println("You must enter a valid move direction!");
            }
            maze.printMaze(player1.getPosX(), player1.getPosY());
        }
    }
}

/* TODO:
    - Where and how do I place classes and methods?
    - MazeGenerator in Maze class?
 */