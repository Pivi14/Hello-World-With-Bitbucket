package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.Ant;

import java.util.Arrays;

public class Main {
    public static int getxSize() {
        return xSize;
    }

    public static int getySize() {
        return ySize;
    }

    private static int xSize = 25;
    private static int ySize = 25;
    private static char[][] matrix = new char[xSize][ySize];
    private static Colony colony = new Colony();
    private static int timeStep = 100;

    public static void main(String[] args) throws InterruptedException {
        colony.setAntColony();
        while (timeStep > 0){
            colony.stepTime();
            matrixRefresh();
            printMatrix(matrix);
            timeStep--;
            Thread.sleep(5000);
            System.out.print("\033\143");
            matrix = new char[xSize][ySize];
        }


    }

    public static void matrixRefresh(){
        char antChar;
        if (colony.getWasp().isLive()){
            matrix[colony.getWasp().getX()][colony.getWasp().getY()] = 'W';
        }
        for (Ant ant: colony.getAntColony()){
            switch (ant.getType()){
                case "Queen":
                    antChar = 'Q';
                    break;
                case "Soldier":
                    antChar = 'S';
                    break;
                case "Worker":
                    antChar = 'a';
                    break;
                case "Drone":
                    antChar = 'D';
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ant.getType());
            }
            matrix[ant.getX()][ant.getY()] = antChar;
        }
    }

    public static void printMatrix(char[][] matrix){
        for (char[] line: matrix){
            System.out.println(Arrays.toString(line));
        }
    }
}
