package com.example.java_pocketbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Pocket_Book_Main extends Application
{
    private static final String FXML_PATH = "/com/example/java_pocketbook/pocketbook_view.fxml";
    private static final String ICON_PATH = "/icon.jpeg";
    private static final String APP_TITLE = "PocketBook";

    @Override
    public void start(Stage stage)
    {
        try
        {
            // Load FXML
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(FXML_PATH)));

            // Load Icon
            Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream(ICON_PATH)));
            stage.getIcons().add(icon);

            // Application Title declaration
            stage.setTitle(APP_TITLE);

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | NullPointerException exception)
        {
            System.err.println("Error loading application resources: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {launch(args);}
}