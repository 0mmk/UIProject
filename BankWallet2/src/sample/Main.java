package sample;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;

public class Main extends Application {
    private static int idx = 0;
    private static final double height = 800;
    private static final double width = 450;
    private static Stage stage;
    private static final String applicationName = "Bank Wallet - ";
    private static final HashMap<String,Scene> scenes = new HashMap<>();

    private static final DTuple[] dTuples = new DTuple[] {
            new DTuple("loginPage.fxml", "Login"),
            new DTuple("signUpPage.fxml", "Sign Up"),
            new DTuple("forgotPasswordPage.fxml", "Forgot Password"),
            new DTuple("homePage.fxml", "Home"),
            new DTuple("stockPage.fxml", "Stock Market"),
            new DTuple("expensePage.fxml", "Expenses and Gross"),
            new DTuple("billPage.fxml", "Automate Your Bills"),
            new DTuple("accountPage.fxml", "Accounts"),
            new DTuple("profilePage.fxml", "Profile"),
    };

    private static final DTuple[] itPages = new DTuple[] {
            dTuples[3],
            dTuples[4],
            dTuples[5],
            dTuples[6],
            dTuples[7],
            dTuples[8],
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        for (DTuple dTuple : dTuples) {
            scenes.put(
                    dTuple.fxml,
                    new Scene(
                            FXMLLoader.load(getClass().getResource(dTuple.fxml)),
                            height,
                            width
                    )
            );
        }
        gotoPage(dTuples[0]);
    }

    public static void gotoPage(DTuple dt) {
        stage.setTitle(applicationName + dt.title);
        stage.setScene(scenes.get(dt.fxml));
        stage.setResizable(false);
        stage.show();
    }

    public static void iteratePages(boolean goLeft) {
        idx = goLeft ? (idx - 1 >= 0             ? idx - 1 : itPages.length - 1)
                     : (idx + 1 < itPages.length ? idx + 1 : 0                 );
        gotoPage(itPages[idx]);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static DTuple getDTuple(int idx) {
        return dTuples[idx];
    }
}

class DTuple {
    final String fxml;
    final String title;

    public DTuple(String fxml, String title) {
        this.fxml = fxml;
        this.title = title;
    }
}
