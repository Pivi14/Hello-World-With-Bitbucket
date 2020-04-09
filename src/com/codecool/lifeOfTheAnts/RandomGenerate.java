package com.codecool.lifeOfTheAnts;

public class RandomGenerate {
    public static int randomGenerate(int max, int min){
        return (int) (Math.random() * (max - min) + min);
    }
}
