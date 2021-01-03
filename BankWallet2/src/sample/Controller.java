package sample;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.util.*;

class TTuple {
    final Object mainObject;
    final DTuple dTuple;

    public TTuple(Object mainObject, DTuple dTuple) {
        this.mainObject = mainObject;
        this.dTuple = dTuple;
    }
}

public class Controller {
    @FXML
    Button
            homeButton,
            stockButton,
            expenseButton,
            billButton,
            accountButton,
            profileButton,
            pageLeftButton,
            pageRightButton,
            loginButton,
            forgotPasswordButton,
            signUpButton;
    @FXML
    Hyperlink
            gotoLoginLink,
            gotoSignUpLink,
            gotoForgotPasswordLink;

    private LinkedList<TTuple> list = null;

    @FXML
    public void initialize() {
        list = new LinkedList<>(
                Arrays.asList(
                    new TTuple(homeButton,              Main.getDTuple(3)),
                    new TTuple(stockButton,             Main.getDTuple(4)),
                    new TTuple(expenseButton,           Main.getDTuple(5)),
                    new TTuple(billButton,              Main.getDTuple(6)),
                    new TTuple(accountButton,           Main.getDTuple(7)),
                    new TTuple(profileButton,           Main.getDTuple(8)),
                    new TTuple(loginButton,             Main.getDTuple(3)),
                    new TTuple(signUpButton,            Main.getDTuple(3)),
                    new TTuple(forgotPasswordButton,    Main.getDTuple(3)),
                    new TTuple(gotoLoginLink,           Main.getDTuple(0)),
                    new TTuple(gotoSignUpLink,          Main.getDTuple(1)),
                    new TTuple(gotoForgotPasswordLink,  Main.getDTuple(2))
        	    )
        );
    }

    public void handlePress(ActionEvent event) throws Exception {
        Object src = event.getSource();
        for (TTuple t: list) {
            if (t.mainObject == src) {
                Main.gotoPage(t.dTuple);
                return;
            }
        }

        if (src == pageLeftButton) {
            Main.iteratePages(true);
        } else if (src == pageRightButton) {
            Main.iteratePages(false);
        }
    }
}
