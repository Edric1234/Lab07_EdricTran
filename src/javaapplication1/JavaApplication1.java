/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.time.Duration;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
        BorderPane bp = new BorderPane();


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
        pt.play();
        
        Line line = new Line(0, 300, 800, 300);

        Pane pane = new Pane(circle, line);
        bp.setTop(pane);

        Scene scene = new Scene(bp, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Lab 07");
        stage.show();
    }
}
