package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Color Switch");

        gameMain gameMainScene = new gameMain(primaryStage); //This is a an object for scene
        firstScreen firstScreen = new firstScreen(primaryStage, gameMainScene);
        primaryStage.setScene(firstScreen.scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
