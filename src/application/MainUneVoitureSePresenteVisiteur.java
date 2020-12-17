package application;

import java.io.IOException;

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

public class MainUneVoitureSePresenteVisiteur {

	private Stage primaryStage;
	
	/*
	 * constructeur de la classe avec argument
	 * 
	 * @param stage
	 */

	public MainUneVoitureSePresenteVisiteur(Stage stage) {
		primaryStage = stage;
	}

	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * simulation une voiture se presente visiteur 
	 * 
	 * @param controleurParking
	 */
	
	public void montrerLaVue(ControleurParking controleurParking) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueVoitureSePresenteVisiteur.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Vue entrée visiteur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);

			// Création d'un nouvel objet image + rectangle
			// Affiliation de l'image dans le rectangle
			Image image = new Image("car1_purple.png");
			Rectangle rec = new Rectangle(115, 10, 35, 90);
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

			// nouvel objet chemin
			Path path = new Path();
			path.getElements().add(new MoveTo(135, 0));
			path.getElements().add(new LineTo(135, 380));

			// nouvel objet animation du chemin
			PathTransition pathtransition = new PathTransition(Duration.millis(3000), path, rec);
			pathtransition.setCycleCount(1);
			pathtransition.play();

			// nouvelle clef de l'animation
			// crée un évènement en fonction de la durée
			KeyFrame kf = new KeyFrame(Duration.millis(5000), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 5s");
					RotateTransition rt = new RotateTransition(Duration.millis(500), rec);
					rt.setByAngle(-45);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame kf1 = new KeyFrame(Duration.millis(6000), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 6s");
					Path path = new Path();
					path.getElements().add(new MoveTo(135, 380));
					path.getElements().add(new LineTo(60, 265));
					PathTransition pathtransition = new PathTransition(Duration.millis(2000), path, rec);
					pathtransition.setCycleCount(1);
					pathtransition.play();
				}

			});
			
			KeyFrame kf2 = new KeyFrame(Duration.millis(8500), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 8.5s");
					RotateTransition rt = new RotateTransition(Duration.millis(500), rec);
					rt.setByAngle(45);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame kf3 = new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 10s");
					dialogStage.close();

				}

			});
			
			
			
			Timeline timeline = new Timeline(kf,kf1, kf2, kf3);
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
