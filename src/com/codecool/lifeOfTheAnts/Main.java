package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.Ant;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static int xSize = 31;
    private static int ySize = 31;
    private static int xOrigo = xSize / 2;
    private static int yOrigo = ySize / 2;
    private static int solderNumber = 5;
    private static int workerNumber = 2;
    private static int droneNumber = 4;
    private static String[][] matrix = new String[xSize][ySize];
    private static Colony colony = new Colony();
    private static int timeStep = 1000;

    public static int getxOrigo() { return xOrigo; }
    public static int getyOrigo() { return yOrigo; }
    public static int getxSize() {
        return xSize;
    }

    public static int getySize() {
        return ySize;
    }

    public static int getSolderNumber() {
        return solderNumber;
    }

    public static int getWorkerNumber() {
        return workerNumber;
    }

    public static int getDroneNumber() {
        return droneNumber;
    }

    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
        colony.setAntColony();
        matrixRefresh();
        printMatrix(matrix);
        matrix = new String[xSize][ySize];
//        scanner.nextLine();
        while (timeStep > 0){
            colony.stepTime();
            matrixRefresh();
            printMatrix(matrix);
            timeStep--;
            Thread.sleep(5);
//            scanner.nextLine();
            System.out.print("\033\143");
            matrix = new String[xSize][ySize];
            System.out.println(timeStep);
        }


    }

    public static void matrixRefresh(){
        String antChar;
        if (colony.getWasp().isLive()){
            matrix[colony.getWasp().getX()][colony.getWasp().getY()] = "W";
        }
        if (colony.getFood().isSpawn() && !colony.getFood().isCarrying()){
            matrix[colony.getFood().getX()][colony.getFood().getY()] = "F";
        }
        for (Ant ant: colony.getAntColony()){
            switch (ant.getType()){
                case "Worker":
                    antChar = "a";
                    break;
                case "Drone":
                    antChar = "D";
                    break;
                case "Soldier":
                    antChar = "S";
                    break;
                case "Queen":
                    antChar = "Q";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ant.getType());
            }
            if (matrix[ant.getX()][ant.getY()] == null){
                matrix[ant.getX()][ant.getY()] = antChar;
            }
        }
    }

    public static void printMatrix(String[][] matrix){
        for (String[] line: matrix){
            for (String cell: line){
                System.out.print(Objects.requireNonNullElse(cell, "."));
            }
            System.out.print("\n");
        }
    }
}
