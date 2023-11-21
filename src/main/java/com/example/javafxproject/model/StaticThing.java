package com.example.javafxproject.model;


import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaticThing {
    private static final String IMGPATH = "src/main/resources/com/example/javafxproject/assets/";
    private String fileName;
    private Integer posX=0;
    private Integer posY=0;
    private Integer sizeX, sizeY;
    private ImageView img;

    public Integer getSizeX() {
        return sizeX;
    }

    public StaticThing(Integer sizeX, Integer sizeY, String fileName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.fileName = fileName;
        Image sprite = null;


        try {
            sprite = new Image(new FileInputStream(IMGPATH + this.fileName));
            this.img = new ImageView(sprite);
            this.img.setViewport(new Rectangle2D(0, 0, sizeX, sizeY));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.img = null;
        }


    }

    public StaticThing(Integer posX, Integer posY, Integer sizeX, Integer sizeY, String fileName) {
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.fileName = fileName;
        Image sprite = null;
        try {
            sprite = new Image(new FileInputStream(IMGPATH + this.fileName));
            this.img = new ImageView(sprite);
            this.img.setViewport(new Rectangle2D(posX, posY, sizeX, sizeY));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.img = null;
        }
    }

    public StaticThing() {
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX += sizeX;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY +=sizeY;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageView getImg() {
        return img;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosX(Integer posX) {
        this.posX=posX;
        System.out.println(posX);
        this.img.setViewport(new Rectangle2D(posX,posY,sizeX,sizeY));
    }

    public void setPosY(Integer posY) {
        this.img.setY(posY);
    }
}
