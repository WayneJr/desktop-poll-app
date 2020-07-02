package main.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.database.DbConn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLogin {

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    public JFXButton loginButton;

    @FXML
    private GridPane loginGrid;

    Connection conn;

    ApplicationContext factory = new AnnotationConfigApplicationContext(main.AppConfig.class);

    public void initialize() {
        try {
            DbConn connection = factory.getBean(DbConn.class);
            conn = connection.connect();
            System.out.println("Database connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void enterTextField() {
        passwordField.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) handleLogin();
        });
    }

    @FXML
    public void handleLogin() {
        try {
            PreparedStatement statement;
            ResultSet rs;
            String sql;
            String user, pass;

            sql = "SELECT * FROM admins WHERE username='" + usernameField.getText() + "' AND password='" + passwordField.getText() +  "'";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

            if (rs.next()) {
                user = rs.getString("username");
                pass = rs.getString("password");

                System.out.println("username = " + user + " and pass = " + pass);

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../adminDashboard.fxml"));
                    Parent root = loader.load();
                    Scene dashScene  = new Scene(root);
                    Stage dashStage = (Stage) loginGrid.getScene().getWindow();
//                    Stage dashStage = new Stage();
                    dashStage.setScene(dashScene);
                    dashStage.setFullScreen(true);
                } catch (IOException e) {
                    e.getMessage();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No Such Account");
                alert.showAndWait()
                        .filter(response -> response == ButtonType.OK)
                        .ifPresent(response -> alert.close());
                System.err.println("No Such account");
            }

        } catch (SQLException e) {
            e.getMessage();
        }


    }

}
