package main.login;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AdminDashboard {

    @FXML
    private BorderPane dashBorderPane;

    @FXML
    private Hyperlink election;

    @FXML
    private Hyperlink dashboard;

    @FXML
    private Hyperlink profile;

    @FXML
    private Hyperlink logout;

    @FXML
    private JFXButton positions;

    @FXML
    private JFXButton candidates;

    @FXML
    private JFXButton voting;

    @FXML
    private JFXButton registration;

    @FXML
    private JFXButton results;

    AdminLogin adminLogin;

    public AdminLogin getAdminLogin() {
        return adminLogin;
    }

    @FXML
    public void handlePositionsView(MouseEvent event) {
       viewSwitcher("../../positions.fxml");
    }

    @FXML
    public void handleCandidatesView(MouseEvent event) {
        viewSwitcher("../../candidates.fxml");
    }

    @FXML
    public void handleVotingView(MouseEvent event) {

    }

    @FXML
    public void handleRegistrationView(MouseEvent event) {

    }

    @FXML
    public void handleLogout(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../adminLogin.fxml"));
            Parent root = loader.load();
            Stage dashStage = (Stage) dashBorderPane.getScene().getWindow();
            dashStage.setScene(new Scene(root, 510, 516));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        viewSwitcher("../../adminLogin.fxml");
    }

    public void viewSwitcher(String location) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
            Parent root = loader.load();
            Stage dashStage = (Stage) dashBorderPane.getScene().getWindow();
            dashStage.setScene(new Scene(root));
            dashStage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
