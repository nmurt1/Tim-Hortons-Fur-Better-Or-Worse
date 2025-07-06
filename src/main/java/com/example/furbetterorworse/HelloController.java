package com.example.furbetterorworse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label rizzlyDate, pookieDate, uncDate;

    private String firstDate = "";
    private int lineNum = 0;
    private boolean isInterrupting= false;


    public void initialize(){}

    @FXML
    private void handleQuitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    private void switchToCombatSelector(ActionEvent event) {
        try {
            Parent gameRoot = FXMLLoader.load(getClass().getResource("CombatSelector.fxml"));
            Scene gameScene = new Scene(gameRoot);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(gameScene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateRizzlyText(ActionEvent event) throws IOException {

            String dialogue;

            // Choose which dialogue to fetch
            dialogue = getDateLine("Rizzly", lineNum, isInterrupting);

            // If no more lines
            if (dialogue == null || dialogue.trim().isEmpty()) {
                lineNum = 0;

                if (firstDate.equals("Pookie")) {
                    // End of date, switch to combat or next scene
                    switchToCombatSelector(event);
                } else {
                    // Handle interruption
                    if (!isInterrupting) {
                        isInterrupting = true;
                    } else {
                        isInterrupting = false;
                        switchToPookieDate(event);
                    }
                }
            } else {
                rizzlyDate.setText(dialogue);
                lineNum++;
            }
        }



    public void updatePookieText(ActionEvent event) throws IOException {
        String dialogue;

        // Choose which dialogue to fetch
        dialogue = getDateLine("Pookie", lineNum, isInterrupting);

        // If no more lines
        if (dialogue == null || dialogue.trim().isEmpty()) {
            lineNum = 0;

            if (firstDate.equals("Unc")) {
                // End of date, switch to combat or next scene
                switchToCombatSelector(event);
            } else {
                // Handle interruption
                if (!isInterrupting) {
                    isInterrupting = true;
                } else {
                    isInterrupting = false;
                    switchToUncDate(event);
                }
            }
        } else {
            pookieDate.setText(dialogue);
            lineNum++;
        }
    }
    public void updateUncText(ActionEvent event) throws IOException {
        String dialogue;

        // Choose which dialogue to fetch
        dialogue = getDateLine("Unc", lineNum, isInterrupting);

        // If no more lines
        if (dialogue == null || dialogue.trim().isEmpty()) {
            lineNum = 0;

            if (firstDate.equals("Rizzly")) {
                // End of date, switch to combat or next scene
                switchToCombatSelector(event);
            } else {
                // Handle interruption
                if (!isInterrupting) {
                    isInterrupting = true;
                } else {
                    isInterrupting = false;
                    switchToRizzlyDate(event);
                }
            }
        } else {
            uncDate.setText(dialogue);
            lineNum++;
        }
    }


    public static String getDateLine(String name, int lineNumber, boolean isInterruption){
        try{
            FileReader file = new FileReader("C:/Users/niros/IdeaProjects/FurBetterOrWorse/src/main/java/com/example/furbetterorworse/dialogues.txt");
            try (BufferedReader reader = new BufferedReader(file)){

                String line = reader.readLine();
                while (line != null && !line.equals(name)){
                    line = reader.readLine();
                }
                if (isInterruption){
                    while (line != null && !line.equals("Interruption")){
                        line = reader.readLine();
                    }
                }
                line = reader.readLine();
                for (int i = 0; i < lineNumber; i++){
                    while (line != null && !line.trim().isEmpty()){
                        line = reader.readLine();
                    }
                    line = reader.readLine();
                }

                return line;
            }
        } catch(IOException e){
            System.err.println("IO Exception: " + e);
        }
        return "";
    }

    public void switchToBackstory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Backstory.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToCharacterIntro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Character_Intro.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToRizzlyIntro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RizzlyIntro.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToRizzlyIntro2a(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RizzlyIntro2a.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToRizzlyIntro2b(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RizzlyIntro2b.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToRizzlyIntro2c(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RizzlyIntro2c.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToPookieIntro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PookieIntro.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToPookieIntro2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PookieIntro2.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToUncIntro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UncIntro.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToInitialChoose(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InitialChoose.fxml")));
        Stage stage = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void switchToRizzlyDate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rizzly-date.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void combatselector(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CombatSelector.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void switchToPookieDate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pookie-date.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchToUncDate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("unc-date.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void rizzlyFirst(ActionEvent e) throws IOException {
        if (firstDate.equals("")){
            firstDate = "Rizzly";
            switchToRizzlyDate(e);
        }
    }

    public void pookieFirst(ActionEvent e) throws IOException {
        if (firstDate.equals("")){
            firstDate = "Pookie";
            switchToPookieDate(e);
        }
    }

    public void uncFirst(ActionEvent e) throws IOException {
        if (firstDate.equals("")){
            firstDate = "Unc";
            switchToUncDate(e);
        }
    }

    public static void main(String[] args){
//        int counter = 0;
//        while(true){
//            String line = getDateLine("Rizzy", counter, true);
//            if (line.equals("")){
//                break;
//            }
//            System.out.println(line);
//            counter++;
//        }
    }

    //   @FXML
    //  protected void onHelloButtonClick() {
    //    welcomeText.setText("Welcome to JavaFX Application!");
    //}


}