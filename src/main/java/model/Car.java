package model;

import org.codehaus.jackson.annotate.JsonTypeInfo;

public class Car implements Vehicle {
    private int seatingCapacity;
    private double topSpeed;



    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    // no-arg constructor, getters and setters
}