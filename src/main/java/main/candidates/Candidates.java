package main.candidates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.database.DbConn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Candidates {

    @FXML
    private BorderPane candBorderPane;

    @FXML
    private TableView<CandidateModel> tableView;

    @FXML
    private TableColumn<CandidateModel, Integer> candID;
    @FXML
    private TableColumn<CandidateModel, String> candFName;
    @FXML
    private TableColumn<CandidateModel, String> candLName;
    @FXML
    private TableColumn<CandidateModel, String> candPosition;
    @FXML
    private TableColumn<CandidateModel, String> positionClass;
    @FXML
    private TableColumn<CandidateModel, Integer> votesReceived;

    ObservableList<CandidateModel> data = FXCollections.observableArrayList();

    Connection connection;

    public void initialize() {

        try {
            connection = DbConn.connect();
            ResultSet rs = connection.createStatement().executeQuery("SELECT candidate_id, candidate_first, candidate_last, postion_name, position_class, votes_received FROM candidates");

            while (rs.next()) {
                data.add(new CandidateModel(
                        rs.getInt("candidate_id"),
                        rs.getString("candidate_first"),
                        rs.getString("candidate_last"),
                        rs.getString("postion_name"),
                        rs.getString("position_class"),
                        rs.getInt("votes_received")
                        )
                );
                System.out.println(rs.getString("candidate_first"));
                System.out.println(rs.getString("candidate_last"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        candID.setCellValueFactory(new PropertyValueFactory<>("id"));
        candFName.setCellValueFactory(new PropertyValueFactory<>("ffName"));
        candLName.setCellValueFactory(new PropertyValueFactory<>("llName"));
        candPosition.setCellValueFactory(new PropertyValueFactory<>("positionName"));
        positionClass.setCellValueFactory(new PropertyValueFactory<>("positionClass"));
        votesReceived.setCellValueFactory(new PropertyValueFactory<>("votesReceived"));

        tableView.setItems(data);
    }

    @FXML
    public void handleBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../adminDashboard.fxml"));
            Parent root = loader.load();
            Stage candStage = (Stage) candBorderPane.getScene().getWindow();
            candStage.setScene(new Scene(root));
            candStage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
