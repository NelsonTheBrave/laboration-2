package org.example;

import java.util.Arrays;
import java.util.Random;

public class Maze {
    Square[] maze;

    Maze(int size) {
        maze = new Square[size];
    }

    public void generateMaze() {
        int xPos = 0;
        int yPos = 0;
        Object mazeContent;
        for (int i = 0; i < maze.length; i++) {
            if (i == 0) {
                mazeContent = new Emptiness(xPos, yPos);
            } else {
                mazeContent = generateMazeContent(xPos, yPos);
            }
            maze[i] = new Square(xPos, yPos, mazeContent);
            xPos++;
            if (xPos == 30) {
                xPos = 0;
                yPos++;
            }
        }
    }

    public static Object generateMazeContent(int xPos, int yPos) {


        String[] CONTENT = {"wall", "emptiness", "monster", "treasure", "upgrade"};
        Random RANDOM = new Random();
        int index = RANDOM.nextInt(CONTENT.length);
        Object object = null;
        switch (index) {
            case 0:
                object = new Wall(xPos, yPos);
                return object;
            case 1:
                object = new Emptiness(xPos, yPos);
                return object;
            case 2:
                object = new Monster(xPos, yPos);
                return object;
            case 3:
                object = new Treasure(xPos, yPos);
                return object;
            case 4:
                object = new Upgrade(xPos, yPos);
                return object;
        }
        return object;
    }

    public Object getSquareContent(int x, int y) {
        for (Square square : maze) {
            if (square.getX() == x && square.getY() == y) {
                return square.getContent();
            }
        }
        return null; // or return a specific string saying not found
    }

    public void printMaze(Player player) {
        int mazeWidth = 30;
        for (int i = 0; i < mazeWidth + 2; i++) {
            if (i == 0) {
                System.out.print("┌");
            } else if (i == mazeWidth + 1) {
                System.out.print("┐");
            } else
                System.out.print("┬");
        }
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            if (i == 0) {
                System.out.print("│");
            } else if (i % mazeWidth == 0 && i != maze.length - 1) {
                System.out.print("│");
                if (i / mazeWidth == 1) {
                    System.out.print(" Current health: " + player.getHealth());
                }
                if (i / mazeWidth == 2) {
                    System.out.print(" Current strength: " + player.getStrength());
                }
                if (i / mazeWidth == 3) {
                    System.out.print(" Items: ");
                    String[] array = player.items.toArray(new String[0]);
                    for (int j = 0; j < array.length - 1; j++) {
                        System.out.print(array[j] + ", ");
                    }
                    System.out.print(array[array.length - 1]);
                }
                System.out.println();
                System.out.print("│");
            }
            if (maze[i].getX() == player.getPosX() && maze[i].getY() == player.getPosY()) {
                System.out.print("●");
            } else {
                Object object = maze[i].getContent();

                if (object instanceof Wall) {
                    System.out.print("░");
                } else if (object instanceof Emptiness) {
                    System.out.print(" ");
                } else if (object instanceof Monster) {
                    System.out.print("▴");
                } else if (object instanceof Item) {
                    System.out.print(".");
                }

//            switch (maze[i].getContent()) {
//                case Wall:
//                    System.out.print("░");
//                    break;
//                case "void":
//                    System.out.print(" ");
//                    break;
//                case "monster":
//                    System.out.print("▴");
//                    break;
//                case "item":
//                    System.out.print(".");
//                default:
////                        System.out.print("D");
//                    break;
//            }
            }
            if (i == maze.length - 1) {
                System.out.print("│");
            }
        }
        System.out.println();
        for (int i = 0; i < mazeWidth + 2; i++) {
            if (i == 0) {
                System.out.print("└");
            } else if (i == mazeWidth + 1) {
                System.out.print("┘");
            } else
                System.out.print("┴");
        }
    }

    public void setSquareContent(int x, int y, Object content) {
        for (Square square : maze) {
            if (square.getX() == x && square.getY() == y) {
                square.setContent(content);
            }
        }
    }
}