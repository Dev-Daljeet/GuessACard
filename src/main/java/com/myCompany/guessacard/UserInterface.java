package com.myCompany.guessacard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Daljeet Singh
 * @version 0.1
 */
public class UserInterface extends Application
{
    private LayoutPane layoutPane = new LayoutPane();

    public void start(Stage stage)
    {
        Scene scene = new Scene(layoutPane.getPaneForLayout(),450,550);
        stage.setTitle("Guess the card");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
