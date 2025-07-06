package com.example.furbetterorworse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CombatSelectorController {
    Player player = new Player();

    @FXML
    public void RizzlyFinal (ActionEvent event){
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("RizzlyBoss.fxml"));
            Scene gameScene = new Scene(gameRoot);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the same stage
            stage.setScene(gameScene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void PookieFinal (ActionEvent event){
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("PookieBoss.fxml"));
            Scene gameScene = new Scene(gameRoot);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the same stage
            stage.setScene(gameScene);
            stage.setResizable(false);
            stage.show();

          //  BossFights bossfight = new BossFights(player,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void UncFinal (ActionEvent event){
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("UncBoss.fxml"));
            Scene gameScene = new Scene(gameRoot);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the same stage
            stage.setScene(gameScene);
            stage.setResizable(false);
            stage.show();

           // BossFights bossfight = new BossFights(player,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void NoneFinal (ActionEvent event){
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("SoloBoss.fxml"));
            Scene gameScene = new Scene(gameRoot);

            // Get the current stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene on the same stage
            stage.setScene(gameScene);
            stage.setResizable(false);
            stage.show();

          //  BossFights bossfight = new BossFights(player,3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
    }
}
