package sample;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;

class Tuple {
    Button button;
    String fxml, title;
    public Tuple(String fxml, Button button, String title) {
        this.fxml = fxml;
        this.button = button;
        this.title = title;
    }
}

public class Controller {

    @FXML
    Button homeButton, stockButton, expenseButton, billButton, accountButton, profileButton,
            pageLeftButton, pageRightButton, loginButton, forgotPasswordButton, signUpButton;

    Stage currentStage;
    Tuple[] tuples;

    @FXML
    public void initialize() {
        tuples = new Tuple[]{
                new Tuple("homePage.fxml", homeButton, "Home"),
                new Tuple("stockPage.fxml", stockButton, "Stock"),
                new Tuple("expensePage.fxml", expenseButton, "Expenses and Gross"),
                new Tuple("billPage.fxml", billButton, "Bills"),
                new Tuple("accountPage.fxml", accountButton, "Account"),
                new Tuple("profilePage.fxml", profileButton, "Profile")
        };
    }

    public void handlePress(ActionEvent event) throws Exception {
        if (currentStage == null) {
            if (event.getSource() == loginButton) {
                currentStage = (Stage) loginButton.getScene().getWindow();
            } else if (event.getSource() == signUpButton) {
                currentStage = (Stage) signUpButton.getScene().getWindow();
            } else if (event.getSource() == forgotPasswordButton) {
                currentStage = (Stage) forgotPasswordButton.getScene().getWindow();
            } else {
                currentStage = (Stage) homeButton.getScene().getWindow();
            }
        }

        if (event.getSource() == loginButton) {
            gotoPage(tuples[0].fxml, "Welcome");
        } else if (event.getSource() == signUpButton) {
            gotoPage(tuples[0].fxml, "Welcome");
        } else if (event.getSource() == forgotPasswordButton) {
            gotoPage(tuples[0].fxml, "Welcome");
        } else if (event.getSource() == pageLeftButton) {
            Main.setTuplesIndex(Main.getTuplesIndex() == 0 ? tuples.length-1 : Main.getTuplesIndex() - 1);
            gotoPage(tuples[Main.getTuplesIndex()].fxml, tuples[Main.getTuplesIndex()].title);
        } else if (event.getSource() == pageRightButton) {
            Main.setTuplesIndex(Main.getTuplesIndex() == tuples.length - 1 ? 0 : Main.getTuplesIndex() + 1);
            gotoPage(tuples[Main.getTuplesIndex()].fxml, tuples[Main.getTuplesIndex()].title);
        } else {
            for (int i = 0; i < tuples.length; i++) {
                if (event.getSource() == tuples[i].button) {
                    Main.setTuplesIndex(i);
                    break;
                }
            }
            gotoPage(tuples[Main.getTuplesIndex()].fxml, tuples[Main.getTuplesIndex()].title);
        }
    }

    private void gotoPage(String fileFXML, String title) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(fileFXML));
        Scene scene = new Scene(root, Main.getHeight(), Main.getWidth());
        currentStage.setScene(scene);
        if (!title.equals("")) currentStage.setTitle(title);
        currentStage.setResizable(false);
        currentStage.show();
    }

    private void gotoPage(String fileFXML) throws Exception {
        gotoPage(fileFXML, "");
    }
}
