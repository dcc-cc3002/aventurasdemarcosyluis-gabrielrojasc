package com.example.aventurasdemarcoyluis.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Aventuras de Marcos y Luis");

    Label label = new Label("Hello World from JavaFX!");
    label.setAlignment(Pos.CENTER);

    Scene scene = new Scene(label, 1280, 720);
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
