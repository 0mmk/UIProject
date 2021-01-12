package sample;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main extends Application {
    private static int idx = 0;
    private static final double height = 800;
    private static final double width = 450;
    private static Stage stage;
    private static final String applicationName = "Bank Wallet - ";
    private static final HashMap<String,Scene> scenes = new HashMap<>();

    private static final DTuple[] dTuples = new DTuple[] {
            new DTuple("loginPage.fxml", "Login"), // 0
            new DTuple("signUpPage.fxml", "Sign Up"), // 1
            new DTuple("forgotPasswordPage.fxml", "Forgot Password"), // 2
            new DTuple("homePage.fxml", "Home"), // 3
            new DTuple("stockPage.fxml", "Stock Market"), // 4
            new DTuple("expensePage.fxml", "Expenses and Gross"), // 5
            new DTuple("billPage.fxml", "Automate Your Bills"), // 6
            new DTuple("account.fxml", "Accounts"), // 7
            new DTuple("profilePage.fxml", "Profile"), // 8
            new DTuple("stock 4.fxml", "Stock"), // 9
            new DTuple("stock 2.fxml", "Stock"), // 10
            new DTuple("stock 3.fxml", "Stock"), // 11
            new DTuple("expensePage2.fxml", "Expense Page"), // 12
            new DTuple("expensePage3.fxml", "Expense Page"), // 13
            new DTuple("LanguagePage.fxml", "Language Page"), // 14
            new DTuple("TimeSettingPage.fxml", "Time Setting Page"), // 15
            new DTuple("account2.fxml", "Account Page"), // 16
            new DTuple("account3.fxml", "Account Page"), // 17
            new DTuple("billPage2.fxml", "Bill Page"), // 18
            new DTuple("billPage3.fxml", "Bill Page"), // 19
            new DTuple("billPage4.fxml", "Bill Page"), // 20
            new DTuple("PopupDecont.fxml", "Popup Decont Page"), // 21
            new DTuple("SendMoney1.fxml", "Send Money"), // 22
            new DTuple("SendMoney1b.fxml", "Send Money"), // 23
            new DTuple("SendMoney2.fxml", "Send Money"), // 24
            new DTuple("sendMoney3.fxml", "Send Money"), // 25
            new DTuple("SendMoney4.fxml", "Send Money"), /// 26
            new DTuple("SecurityPreferencesPage.fxml", "Security Preferences"), // 27
            new DTuple("profilePageExtra.fxml", "Backup Data"), // 28
            new DTuple("changeEmailPage.fxml", "Change Email"), // 29
            new DTuple("changePasswordPage.fxml", "Change Password"), // 30
            new DTuple("MenuDesignPage.fxml", "Menu Design"), // 31
            new DTuple("changePhoneNumberPage.fxml", "Change Phone Number"), // 32
            new DTuple("LoginHistoryPage.fxml", "Login History") // 33
    };

    private static final DTuple[] itPages = new DTuple[] {
            dTuples[3],
            dTuples[4],
            dTuples[5],
            dTuples[6],
            dTuples[7],
            dTuples[8],
    };

    private static final LinkedList<DTuple> lastPages = new LinkedList<>();

    public static void billPageGotoLastPage() {
        if (lastPages.size() >= 2) {
            gotoPage(lastPages.get(lastPages.size() - 2));
        } else {
            gotoPage(lastPages.getLast());
        }
    }

    public static void billPageAddLastPage(DTuple d) {
        lastPages.add(d);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Font.loadFont(Main.class.getResource("dejavu/ttf/DejaVuSerif.ttf").toExternalForm(), 10);
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

    public static void setScale(Pane loginPane) throws Exception {

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
