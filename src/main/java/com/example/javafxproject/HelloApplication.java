package com.example.javafxproject;

import com.example.javafxproject.model.GameScene;
import com.example.javafxproject.model.StaticThing;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("init() method called");
    }

    public void stop() throws Exception {
        System.out.println("stop() method called");
    }

    @Override
    public void start(Stage stage) throws IOException {
        final double fixedHeight, fixedWidth;

        final int[][] moveArray = {{100, 0}, {100, 85}, {100, 170}, {100, 255}, {100, 340}};
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        final String backgroundImg = "img/desert.png";
        final String heroImg = "img/heros.png";

        StaticThing backgroundRight = new StaticThing(
            800, 400, backgroundImg);
        StaticThing backgroundLeft = new StaticThing(
            400, 400, backgroundImg);
        StaticThing heroStatic = new StaticThing(
            0, 0, 80, 100, heroImg);

        TranslateTransition transitionRight = new TranslateTransition(Duration.millis(10), heroStatic.getImg());
        transitionRight.setByX(5);
        transitionRight.setOnFinished(event -> {
            heroStatic.setPosX(moveArray[l.get(0)][0]);
            heroStatic.setPosX(moveArray[l.get(0)][1]);
            l.set(0, (l.get(0) + 1) % 5);
        });
        transitionRight.setInterpolator(Interpolator.EASE_OUT);// Move 300 pixels to the right
        TranslateTransition transitionLeft = new TranslateTransition(Duration.millis(10), heroStatic.getImg());
        transitionLeft.setByX(-10); // Move 300 pixels to the right
        TranslateTransition transitionUp = new TranslateTransition(Duration.millis(150), heroStatic.getImg());
        transitionUp.setByY(-50);
        transitionUp.setInterpolator(Interpolator.EASE_BOTH);
        transitionUp.setOnFinished(e -> heroStatic.getImg().setTranslateY(0) );

        Pane root = new Pane();
        GridPane gridPane = new GridPane();
        gridPane.add(backgroundRight.getImg(), 0, 0);
        gridPane.add(backgroundLeft.getImg(), 1, 0);
        root.getChildren().add(gridPane);
        heroStatic.getImg().setX(0);
        heroStatic.getImg().setY(300);
        root.getChildren().add(heroStatic.getImg());
        GameScene scene = new GameScene(root);
        EventHandler<KeyEvent> move = event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                for (int i = 0; i <= 6; i++) {
                    transitionRight.play();
                }

            } else if (event.getCode() == KeyCode.LEFT) {
                transitionLeft.play();

            } else if (event.getCode() == KeyCode.UP) {
                transitionUp.play();
            }

        };

        scene.addEventHandler(KeyEvent.KEY_PRESSED, move);
        stage.setScene(scene);
        stage.show();
    }

    void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        launch();
    }
}
