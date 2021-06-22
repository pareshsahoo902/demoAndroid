package com.release.androidbatch2.Login;

public class Vehicle {

    private String color;
    private String topSpeed;
    private  int noOf_Wheels;


    public Vehicle() {
    }

    public Vehicle(String color, String topSpeed, int noOf_Wheels) {
        this.color = color;
        this.topSpeed = topSpeed;
        this.noOf_Wheels = noOf_Wheels;
    }


    public String getColor() {
        return color;
    }

    public String getTopSpeed() {
        return topSpeed;
    }

    public int getNoOf_Wheels() {
        return noOf_Wheels;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setTopSpeed(String topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setNoOf_Wheels(int noOf_Wheels) {
        this.noOf_Wheels = noOf_Wheels;
    }
}
