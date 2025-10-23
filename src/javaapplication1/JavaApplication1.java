/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * GitHub link: https://github.com/Edric1234/Lab07_EdricTran.git
 * @author 6289632
 */
public class JavaApplication1 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setLayoutX(60);
        circle.setLayoutY(60);
        circle.setFill(Color.MEDIUMPURPLE);

        Rectangle rectangle = new Rectangle(400, 150);
        PathTransition pt = new PathTransition();
        pt.setPath(rectangle);
        pt.setNode(circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.setDuration(new Duration(1000));
        pt.setInterpolator(Interpolator.LINEAR);
        pt.play();

        Line line = new Line(0, 300, 800, 300);

        ///////////////////////////////////
        Polygon objB = new Polygon(300, 530, 500, 530, 400, 430);
        objB.setFill(Color.LIGHTBLUE);

        //Rectangle vertices coordinates
        double mX = 300, mY = 300;
        double nX = 530, nY = 300;
        double pX = 530, pY = 465;
        double qX = 300, qY = 465;

        Circle objA = new Circle();
        objA.setRadius(10);
        objA.setLayoutX(275);
        objA.setLayoutY(400);
        objA.setFill(Color.MEDIUMPURPLE);

        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");

        start.setLayoutX(20);
        start.setLayoutY(570);
        reset.setLayoutX(80);
        reset.setLayoutY(570);
        exit.setLayoutX(144);
        exit.setLayoutY(570);

        TranslateTransition moveToN = new TranslateTransition(Duration.millis(2000), objA);
        moveToN.setByX(nX - mX);

        TranslateTransition moveToP = new TranslateTransition(Duration.millis(2000), objA);
        moveToP.setByY(pY - nY);

        TranslateTransition moveToQ = new TranslateTransition(Duration.millis(2000), objA);
        moveToQ.setByX(qX - pX);

        TranslateTransition moveToM = new TranslateTransition(Duration.millis(2000), objA);
        moveToM.setByY(mY - qY);

        FadeTransition fadeB = new FadeTransition(Duration.millis(2000), objB);
        fadeB.setFromValue(1.0);
        fadeB.setToValue(0.3);

        ScaleTransition scaleB = new ScaleTransition(Duration.millis(2000), objB);
        scaleB.setToX(1.5);
        scaleB.setToY(1.5);

        RotateTransition rotateB = new RotateTransition(Duration.millis(2000), objB);
        rotateB.setByAngle(360);

        TranslateTransition moveUpB = new TranslateTransition(Duration.millis(2000), objB);
        moveUpB.setByY(-75);

        ParallelTransition part1 = new ParallelTransition(moveToN, fadeB);
        ParallelTransition part2 = new ParallelTransition(moveToP, scaleB);
        ParallelTransition part3 = new ParallelTransition(moveToQ, rotateB);
        ParallelTransition part4 = new ParallelTransition(moveToM, moveUpB);

        SequentialTransition fullSequence = new SequentialTransition(part1, part2,
                part3, part4);

        start.setOnAction(e -> {
            fullSequence.play();
        });

        reset.setOnAction(e -> {
            objA.setTranslateX(0);
            objA.setTranslateY(0);
            objB.setOpacity(1);
            objB.setScaleX(1);
            objB.setScaleY(1);
            objB.setRotate(0);
            objB.setTranslateX(0);
            objB.setTranslateY(0);
        });

        exit.setOnAction(e -> {
            fullSequence.stop();
        });

        Pane pane = new Pane(circle, line, objB, objA, start, reset, exit);
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Lab 07");
        stage.show();
    }
}
