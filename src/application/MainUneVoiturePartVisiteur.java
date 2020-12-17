package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import controller.ControleurParking;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class MainUneVoiturePartVisiteur {

	private Stage primaryStage;
	
	/*
	 * constructeur de la classe avec argument
	 * 
	 * @param stage
	 */

	public MainUneVoiturePartVisiteur(Stage stage) {
		primaryStage = stage;

	}
	
	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * simulateur une voiture part visiteur
	 * 
	 * @param controleurParking
	 */

	public void montrerLaVue(ControleurParking controleurParking) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueVoitureSePresenteVisiteur.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Vue sortie visiteur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);

			// Création d'un nouvel objet image + rectangle
			// Affiliation de l'image dans le rectangle
			Image image = new Image("car1_purple.png");
			Rectangle rec = new Rectangle(30, 220, 35, 90);
			ImagePattern imagepattern = new ImagePattern(image);
			rec.setFill(imagepattern);
			page.getChildren().add(rec);

			// Permet de faire une rotation de 180° à la voiture lors de son entrée dans
			// l'image
			RotateTransition rotate = new RotateTransition(Duration.millis(0001), rec);
			rotate.setByAngle(180);
			rotate.setCycleCount(1);
			rotate.setAutoReverse(true);
			rotate.play();

		
			
			KeyFrame kf1 = new KeyFrame(Duration.seconds(3), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RotateTransition rotate = new RotateTransition(Duration.millis(600), rec);
					rotate.setByAngle(-45);
					rotate.setCycleCount(1);
					rotate.setAutoReverse(true);
					rotate.play();

				}

			});
			
			KeyFrame kf2 = new KeyFrame(Duration.seconds(4), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// nouvel objet chemin
					Path path = new Path();
					path.getElements().add(new MoveTo(60, 265));
					path.getElements().add(new LineTo(135, 380));

					// nouvel objet animation du chemin
					PathTransition pathtransition = new PathTransition(Duration.millis(2500), path, rec);
					pathtransition.setCycleCount(1);
					pathtransition.play();
				}

			});
			
			KeyFrame kf3 = new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RotateTransition rotate = new RotateTransition(Duration.millis(600), rec);
					rotate.setByAngle(45);
					rotate.setCycleCount(1);
					rotate.setAutoReverse(true);
					rotate.play();

				}

			});
			
			KeyFrame kf4 = new KeyFrame(Duration.seconds(8), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// nouvel objet chemin
					Path path = new Path();
					path.getElements().add(new MoveTo(135, 380));
					path.getElements().add(new LineTo(135, 600));

					// nouvel objet animation du chemin
					PathTransition pathtransition = new PathTransition(Duration.millis(2000), path, rec);
					pathtransition.setCycleCount(1);
					pathtransition.play();
				}

			});
			
			KeyFrame kf5 = new KeyFrame(Duration.seconds(10.5), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RotateTransition rt = new RotateTransition(Duration.millis(600), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame kf6 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// nouvel objet chemin
					Path path = new Path();
					path.getElements().add(new MoveTo(135, 600));
					path.getElements().add(new LineTo(790, 600));

					// nouvel objet animation du chemin
					PathTransition pathtransition = new PathTransition(Duration.millis(4000), path, rec);
					pathtransition.setCycleCount(1);
					pathtransition.play();
				}

			});
			
			KeyFrame kf7 = new KeyFrame(Duration.seconds(16), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RotateTransition rt = new RotateTransition(Duration.millis(600), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame kf8 = new KeyFrame(Duration.seconds(17), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// nouvel objet chemin
					Path path = new Path();
					path.getElements().add(new MoveTo(790, 600));
					path.getElements().add(new LineTo(790, -100));

					// nouvel objet animation du chemin
					PathTransition pathtransition = new PathTransition(Duration.millis(5000), path, rec);
					pathtransition.setCycleCount(1);
					pathtransition.play();
				}

			});
			
			KeyFrame kf9 = new KeyFrame(Duration.seconds(19), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					FadeTransition fadetransition = new FadeTransition(Duration.millis(2000), rec);
					fadetransition.setFromValue(1.0);
					fadetransition.setToValue(0.01);
					fadetransition.play();
					
				}
				
			});
			
			KeyFrame kf10 = new KeyFrame(Duration.seconds(22), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialogStage.close();
				}
				
			});
			
			Timeline timeline = new Timeline(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8, kf9, kf10);
			timeline.setCycleCount(1);
			timeline.playFromStart();

			Scene scene = new Scene(page, 900, 700);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
