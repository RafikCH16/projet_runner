package com.example.javafxproject.model;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameScene extends Scene {
    Camera camera;
    final String backgroundImg = "img/desert.png";
    StaticThing backgroundLeft;
    StaticThing backgroundRight;


    public GameScene(Parent root) {
        super(root);
        backgroundRight = new StaticThing(
            800, 400, backgroundImg);
        backgroundLeft = new StaticThing(
            400, 400, backgroundImg);


    }

    public GameScene(Parent root, double width, double height) {
        super(root, width, height);
    }

    public GameScene(Parent root, Paint fill) {
        super(root, fill);
    }

    public GameScene(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
    }

    public GameScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }


    public void render() {

    }

    public static void main(String[] args) {

    }

}
