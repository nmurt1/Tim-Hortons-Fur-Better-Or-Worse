package com.example.furbetterorworse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;


public class BossFights {
    @FXML
    private ProgressBar PlayerAura;
    @FXML
    private ProgressBar EnemyAura;

    public void initialize() {
        PlayerAura.setProgress(1.0);
        EnemyAura.setProgress(1.0);
    }

    @FXML
    private void Damage(ActionEvent event) {
        attack(EnemyAura);
        attack(PlayerAura);
        HappyEnding(event);
        DeadEnding(event);

    }

    @FXML
    private void SoloDamage(ActionEvent event) {
        attack(EnemyAura);
        PlayerAura.setProgress(0);
        RaccoonBabyEnding(event);

    }

    private void attack(ProgressBar bar) {
        Random rand = new Random();

        // Generate random double between 0.0 and 0.5
        double damage = rand.nextDouble() * 0.5;

        // Get current progress and clamp result
        double current = bar.getProgress();
        double updated = Math.max(0, current - damage);

        // Apply updated progress
        bar.setProgress(updated);
    }

    private void SoloAtack(ProgressBar bar) {
        Random rand = new Random();

        // Generate random double between 0.0 and 0.5
        double damage = rand.nextDouble() * 0.5;

        // Get current progress and clamp result
        double current = bar.getProgress();
        double updated = Math.max(0, current - damage);

        // Apply updated progress
        bar.setProgress(updated);
    }

    public boolean HappyEnding(ActionEvent event) {
        double playerProgress = PlayerAura.getProgress();
        double enemyProgress = EnemyAura.getProgress();

        if (enemyProgress == 0 && playerProgress > 0) {
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();
            Parent currentRoot = currentScene.getRoot();

            // Fade out current scene
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), currentRoot);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);

            fadeOut.setOnFinished(e -> {
                try {
                    // Load Happy Ending FXML
                    Parent newRoot = FXMLLoader.load(getClass().getResource("HappyEnding.fxml"));

                    // Set new scene and fade in
                    Stage stage = (Stage) sourceNode.getScene().getWindow();
                    Scene newScene = new Scene(newRoot);
                    stage.setScene(newScene);

                    // Fade in new scene
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newRoot);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            fadeOut.play();
            return true;
        } else{
            return false;
        }
    }

    public boolean DeadEnding(ActionEvent event) {
        double playerProgress = PlayerAura.getProgress();
        double enemyProgress = EnemyAura.getProgress();

        if (enemyProgress < 0 && playerProgress == 0) {
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();
            Parent currentRoot = currentScene.getRoot();

            // Fade out current scene
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), currentRoot);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);

            fadeOut.setOnFinished(e -> {
                try {
                    // Load Happy Ending FXML
                    Parent newRoot = FXMLLoader.load(getClass().getResource("Ending-YouDead.fxml"));

                    // Set new scene and fade in
                    Stage stage = (Stage) sourceNode.getScene().getWindow();
                    Scene newScene = new Scene(newRoot);
                    stage.setScene(newScene);

                    // Fade in new scene
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newRoot);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            fadeOut.play();
            return true;
        } else{
            return false;
        }
    }

    public boolean RaccoonBabyEnding(ActionEvent event) {
            Node sourceNode = (Node) event.getSource();
            Scene currentScene = sourceNode.getScene();
            Parent currentRoot = currentScene.getRoot();

            // Fade out current scene
            FadeTransition fadeOut = new FadeTransition(Duration.millis(500), currentRoot);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);

            fadeOut.setOnFinished(e -> {
                try {
                    // Load Happy Ending FXML
                    Parent newRoot = FXMLLoader.load(getClass().getResource("Ending-RaccoonBaby.fxml"));

                    // Set new scene and fade in
                    Stage stage = (Stage) sourceNode.getScene().getWindow();
                    Scene newScene = new Scene(newRoot);
                    stage.setScene(newScene);

                    // Fade in new scene
                    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newRoot);
                    fadeIn.setFromValue(0.0);
                    fadeIn.setToValue(1.0);
                    fadeIn.play();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            fadeOut.play();
            return true;
    }


    // /* Timing‑bar labels */
    //public static final String[] ZONES = {"GREEN", "YELLOW", "MISS"};


    /* Damage values for each zone */
//    private static final double GREEN_DMG = 0.2;
//    private static final double YELLOW_DMG = 0.15;
//    private static final double DUO_DMG = 0.1;
//    private static final double TRIO_DMG = 1.0;


    float eDmg;


    /* Fields */
    Player player;             // never null
    private Raccoon enemies;     // 0–3 enemies allowed
    int enemyCount;
//    private boolean playersMove = true;
//    private boolean enemiesMove = false;


//    // Player + love interest vs 2 haters
//    public BossFights(Player player, int enemyCount) {
//        if (enemyCount != 2 && enemyCount != 3)
//            throw new IllegalArgumentException("Enemy count must be 2 or 3");
//        this.player = player;
//
//        if (enemyCount == 2) {
//            enemies = new Raccoon("Duo Enemy", 1.0);
//        } else {
//            enemies = new Raccoon("Trio Enemy", 1.0);
//        }
//        player.resetAura();
//    }

    public void auraPoints() {
        PlayerAura.setProgress(player.getAura());
        EnemyAura.setProgress(enemies.getAura());
    }

//    One space‑bar press from the user:
//    zoneIdx GREEN = 0, YELLOW = 1, MISS = 2 (use the array)


    public void playerTurn(int zoneIdx) {
        //if (enemies.getRIsAlive()); //ensure the player isnt alive with 0 health


//        // Calculate damage done from the bar
//        double dmg = switch (zoneIdx) {
//            case 0 -> GREEN_DMG; //best
//            case 1 -> YELLOW_DMG; //medium
//            default -> 0; // MISS //worst
//        };
//
//
//        if (dmg < 0) {
//            System.out.println("Your attack: -" + dmg);
//            enemies.loseAura(dmg);
//            playersMove = false;
//            enemyTurn();
//        }
//    }


//    private void enemyTurn() { //call this when it is the enemy's turn
//        //if (player.getIsAlive()) return; //
//        if(enemyCount==2){
//            eDmg = (float) DUO_DMG;
//        }
//        if(enemyCount==3){
//            eDmg = (float) TRIO_DMG;
//        }
//
//
//        /* always hit the player first; if KO, hit partner --- */
//        if (player.getIsAlive()) {
//            System.out.println("Enemy's attack: -" + eDmg);
//            player.loseAura(eDmg);
//        }
//    }


//    public boolean playerWon() {
//        return enemies.getRIsAlive();
//    }
//
//
//    public boolean isFinished() {
//        if (!player.getIsAlive() | !enemies.getRIsAlive()) {
//            boolean playerDead = player.getIsAlive();              // player down
//            boolean enemiesDead = enemies.isKO();                 // enemies down
//            return playerDead || enemiesDead;
//        }
//        return false;
//    }


    }


}
