package main.positions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class Positions {

    @FXML
    private Hyperlink backButton;

    public void viewSwitcher(String location) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
            Parent root = loader.load();
            ((Stage) backButton.getScene().getWindow()).setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
