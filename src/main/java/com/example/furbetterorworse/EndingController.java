
package com.example.furbetterorworse;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EndingController {
    public ImageView baby;
    public ImageView dead;

    public class ImageFadeExample{

        @FXML
        public void start(Stage primaryStage) {
            // Set the second image invisible at start
            baby.setOpacity(0);

            AnchorPane root = new AnchorPane(baby, dead);

            Scene scene = new Scene(root, 1200, 675);
            primaryStage.setScene(scene);
            primaryStage.setTitle("");
            primaryStage.show();

            // Wait 3 seconds before starting the fade
            PauseTransition pause = new PauseTransition(Duration.seconds(5));
            pause.setOnFinished(event -> {
                // Fade out first image
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), dead);
                fadeOut.setFromValue(1.0);
                fadeOut.setToValue(0.0);

                // Fade in second image
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), baby);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);

                fadeOut.play();
                fadeIn.play();
            });
            pause.play();
        }
    }
}