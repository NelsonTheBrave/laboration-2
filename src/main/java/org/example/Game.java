package org.example;

import java.util.Scanner;

public class Game {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Maze maze = new Maze(300);
        maze.generateMaze();
        Player player = new Player("Jörgen", 0, 0, 100, 30);
        maze.printMaze(player);

        play(scanner, player, maze);
    }

    public boolean gameOver(Player player) {
        if (player.health == 0) {
            System.out.println();
            System.out.println("You ran out of health. GAME OVER!");
            return false;
        } else {
            return true;
        }
    }

    public void play(Scanner scanner, Player player, Maze maze) {
        boolean awaitingChoice = true;


        while (awaitingChoice) {
            System.out.println();
            System.out.println("Please enter desired direction to move player (a, s, d, w or q to quit)");
            char direction = scanner.next().charAt(0);
            switch (direction) {
                case 'a':
                    player.move(-1, 0, maze);
                    break;
                case 's':
                    player.move(0, 1, maze);
                    break;
                case 'd':
                    player.move(1, 0, maze);
                    break;
                case 'w':
                    player.move(0, -1, maze);
                    break;
                case 'q':
                    awaitingChoice = false;
                    System.out.println("Goodbye");
                default:
                    System.out.println("You must enter a valid move direction!");
            }
            for (int i = 0; i < maze.maze.length; i++) {
                if (maze.maze[i].getContent() instanceof Monster) {
                    Monster monster = (Monster) maze.maze[i].getContent();
                    monster.move(1, 1, maze);

                }
            }
            maze.printMaze(player);
            if (awaitingChoice == true) {
                awaitingChoice = gameOver(player);
            }
        }
    }
}
