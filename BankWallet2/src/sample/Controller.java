package sample;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

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
    Pane loginPane;

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
            signUpButton,
            billButtonNext,
            showNew4Button,
            showNew3Button,
            showNew2Button,
            showNew1Button,
            order1Button,
            sell1Button,
            buy1Button,
            order2Button,
            sell2Button,
            buy2Button,
            order3Button,
            sell3Button,
            buy3Button,
            buy1DetailButton,
            order1DetailButton,
            sell1DetailButton,
            exitButton;
    @FXML
    Hyperlink
            gotoLoginLink,
            gotoSignUpLink,
            gotoForgotPasswordLink;

    @FXML
    Label dontHaveAccount;

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
                    new TTuple(gotoForgotPasswordLink,  Main.getDTuple(2)),
                    new TTuple(billButtonNext,          Main.getDTuple(0)),
                    new TTuple(showNew4Button,          Main.getDTuple(9)),
                    new TTuple(showNew3Button,          Main.getDTuple(9)),
                    new TTuple(showNew2Button,          Main.getDTuple(9)),
                    new TTuple(showNew1Button,          Main.getDTuple(9)),
                    new TTuple(buy2Button,              Main.getDTuple(10)),
                    new TTuple(sell2Button,             Main.getDTuple(10)),
                    new TTuple(order2Button,            Main.getDTuple(10)),
                    new TTuple(buy1Button,              Main.getDTuple(10)),
                    new TTuple(sell1Button,             Main.getDTuple(10)),
                    new TTuple(order1Button,            Main.getDTuple(10)),
                    new TTuple(buy3Button,              Main.getDTuple(10)),
                    new TTuple(sell3Button,             Main.getDTuple(10)),
                    new TTuple(order3Button,            Main.getDTuple(10)),
                    new TTuple(sell1DetailButton,       Main.getDTuple(11)),
                    new TTuple(order1DetailButton,      Main.getDTuple(11)),
                    new TTuple(buy1DetailButton,        Main.getDTuple(11))
        	    )
        );
    }

    public void handlePress(ActionEvent event) throws Exception {
        Object src = event.getSource();
        if (src == exitButton) {
            System.exit(0);
        }
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

    public void handleLoginClick() throws Exception {
        Main.setScale(loginPane);
        //Main.gotoPage(Main.getDTuple(1));
    }

    public void gotoBankAccountsFunc() {
        Main.gotoPage(Main.getDTuple(7));
    }

    public void gotoExpenseFunc() {
        Main.gotoPage(Main.getDTuple(5));
    }

    public void gotoStockFunc() {
        Main.gotoPage(Main.getDTuple(4));
    }

    public void gotoBillFunc() {
        Main.gotoPage(Main.getDTuple(6));
    }
}
