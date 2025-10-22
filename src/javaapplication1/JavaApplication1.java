/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
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
        circle.setFill(Color.RED);
        
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
        Polygon triangle = new Polygon(100, 400, 300, 400, 200, 300);
        triangle.setFill(Color.LIGHTBLUE);
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        start.setLayoutX(20);
        start.setLayoutY(570);
        reset.setLayoutX(80);
        reset.setLayoutY(570);
        exit.setLayoutX(144);
        exit.setLayoutY(570);
        
        Pane pane = new Pane(circle, line, triangle, start, reset, exit);
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Lab 07");
        stage.show();
    }
}
