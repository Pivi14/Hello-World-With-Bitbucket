package com.codecool.lifeOfTheAnts.Bugs;

import com.codecool.lifeOfTheAnts.Main;
import com.codecool.lifeOfTheAnts.RandomGenerate;

public abstract class Bug {
    private String type;
    private int x;
    private int y;
    private boolean cubeX;
    private boolean cubeY;


    public boolean isCubeX() {
        return cubeX;
    }

    public void setCubeX() {
        this.cubeX = x > Main.getxSize() / 2 - 5 && x < Main.getxSize() / 2 + 5;
    }

    public boolean isCubeY() {
        return cubeY;
    }

    public void setCubeY() {
        this.cubeY = y > Main.getySize() / 2 - 5 && y < Main.getySize() / 2 + 5;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void spawn(){
        setX(Main.getxOrigo());
        setY(Main.getyOrigo());
        setCubeX();
        setCubeY();
        while (isCubeX() && isCubeY() || getX() == Main.getxOrigo() || getY() == Main.getyOrigo()){
            setX(RandomGenerate.randomGenerate(Main.getxSize(), 0));
            setY(RandomGenerate.randomGenerate(Main.getySize(), 0));
            setCubeX();
            setCubeY();
        }}
}
