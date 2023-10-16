package com.example.assignment2_2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LayoutView root = new LayoutView();
        Scene scene = new Scene(root, 600, 300);
        scene.setFill(Color.ORANGE);
        stage.setTitle("Layout Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}