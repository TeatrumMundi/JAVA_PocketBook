package com.example.java_pocketbook;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Pocket_Book_Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root,750,750, Color.LIGHTGRAY);

        Text text = new Text();
        text.setText("KYS");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Roboto",50));
        text.setFill(Color.DARKOLIVEGREEN);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);

        // Icon declaration
        Image icon = new Image("icon.jpeg");
        stage.getIcons().add(icon);
        // Application Title declaration
        stage.setTitle("PocketBook");

        root.getChildren().add(text);
        root.getChildren().add(line);
        stage.setScene(scene);
        stage.show();
    }
}