package com.codecool.lifeOfTheAnts;

import com.codecool.lifeOfTheAnts.Bugs.Ant;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    private static int xSize = 25;
    private static int ySize = 25;
    private static int xOrigo = xSize / 2;
    private static int yOrigo = ySize / 2;
    private static int solderNumber = 4;
    private static int workerNumber = 4;
    private static int droneNumber = 3;
    private static String[][] matrix = new String[xSize][ySize];
    private static Colony colony = new Colony();
    private static int timeStep = 1;

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
        colony.setAntColony();
        while (timeStep > 0){
            colony.stepTime();
            matrixRefresh();
            printMatrix(matrix);
            timeStep--;
            Thread.sleep(50);
            System.out.print("\033\143");
            matrix = new String[xSize][ySize];
        }


    }

    public static void matrixRefresh(){
        String antChar;
        if (colony.getWasp().isLive()){
            matrix[colony.getWasp().getX()][colony.getWasp().getY()] = "W";
        }
        for (Ant ant: colony.getAntColony()){
            switch (ant.getType()){
                case "Queen":
                    antChar = "Q";
                    break;
                case "Soldier":
                    antChar = "S";
                    break;
                case "Worker":
                    antChar = "a";
                    break;
                case "Drone":
                    antChar = "D";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ant.getType());
            }
            matrix[ant.getX()][ant.getY()] = antChar;
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
