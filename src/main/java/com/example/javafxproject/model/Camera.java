package com.example.javafxproject.model;

public class Camera {
    Integer x, y;

    public Camera(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Camera() {
        this.x=0;
        this.y=0;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Camera{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }

}
