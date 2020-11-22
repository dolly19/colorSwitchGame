package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Color Switch");

        startScreen startScreenScene = new startScreen(primaryStage); //This is a an object for scene

        firstScreen firstScreen = new firstScreen(primaryStage, startScreenScene);

        primaryStage.setScene(firstScreen.scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
