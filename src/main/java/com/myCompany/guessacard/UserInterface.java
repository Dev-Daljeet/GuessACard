package com.mycompany.guessacard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Represents the User Interface of Application.
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
public class UserInterface extends Application
{
    private LayoutPane layoutPane = new LayoutPane();

    /** Displays the GUI and overrides the start() method of class Application.
     * @param stage An instance of class stage which consists the scene to display GUI.
     */
    public void start(Stage stage)
    {
        Scene scene = new Scene(layoutPane.getPaneForLayout(),450,550);
        stage.setTitle("Guess a card");
        stage.setScene(scene);
        stage.show();
    }

    /** Runs the program or starting point of execution.
     * (Note: The main method is only needed for the IDE with limited JavaFX support.
     *  Not needed for running from the command line.)
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
