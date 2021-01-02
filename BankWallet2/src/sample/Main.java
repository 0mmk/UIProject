package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static int tuplesIndex = 0;
    private static int height = 800;
    private static int width = 450;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 800, 450));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public static void setTuplesIndex(int value) {
        tuplesIndex = value;
    }

    public static int getTuplesIndex() {
        return tuplesIndex;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Main.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Main.width = width;
    }
}
