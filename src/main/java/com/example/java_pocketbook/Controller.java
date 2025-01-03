package com.example.java_pocketbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Controller
{
    @FXML
    private TextArea textBox;

    // Class-level variable to store the current file name
    private Path currentFilePath;

    public void openFile(ActionEvent event)
    {
        // Get the button that was clicked
        Button clickedButton = (Button) event.getSource();

        // Use the button's text as the file name
        String fileName = clickedButton.getText() + ".txt"; // Add .txt to the file name

        File file = new File("src/main/resources/fileSaves/" + fileName);

        // Update the currentFileName variable
        currentFilePath = Paths.get("src/main/resources/fileSaves/" + fileName);

        // Check if the file exists
        if (!file.exists())
        {
            try
            {
                // Create the file if it doesn't exist
                if (file.createNewFile())
                {
                    System.out.println("File " + fileName + " was created successfully.");
                } else
                {
                    System.out.println("Failed to create the file.");
                }
            } catch (IOException exception)
            {
                System.out.println("An error occurred while creating the file: " + exception.getMessage());
            }
        } else
        {
            System.out.println("File " + file.getName() + " already exists.");
            System.out.println("Trying to populate a text area with the contents of a file: " + file.getName());

            try
            {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                textBox.setText(content);
                System.out.println("TextArea populated with the content of the file.");
            } catch (IOException exception)
            {
                textBox.setText("An error occurred while reading the file: " + exception.getMessage());
            }
        }
    }

    public void saveFile()
    {
        if (currentFilePath == null)
        {
            System.out.println("Error: File path is null. Cannot save the file.");
            return;
        }

        try
        {
            Files.write(currentFilePath, textBox.getText().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            System.out.println("Text saved to the file.");
        } catch (IOException exception)
        {
            System.out.println("Error occurred during saving the file: " + exception.getMessage());
        }
    }
}
