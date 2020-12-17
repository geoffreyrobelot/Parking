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

public class MainUneVoitureSePresente {

	private Stage primaryStage;
	
	/*
	 * constructeur de la classe avec argument 
	 * 
	 * @param stage
	 */

	public MainUneVoitureSePresente(Stage stage) {
		primaryStage = stage;
	}
	
	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * simulation une voiture se présente
	 * 
	 * @param controleurParking
	 */

	public void montrerLaVue(ControleurParking controleurParking) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueVoitureSePresente.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Simulateur-Une voiture se présente au parking");
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
			path.getElements().add(new LineTo(135, 600));
			//path.getElements().add(new LineTo(240, 600));

			// nouvel objet animation du chemin
			PathTransition pathtransition = new PathTransition(Duration.millis(4000), path, rec);
			pathtransition.setCycleCount(1);
			pathtransition.play();

			// nouvelle clef de l'animation
			// crée un évènement en fonction de la durée
			KeyFrame kf = new KeyFrame(Duration.millis(4500), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Path path = new Path();
					path.getElements().add(new MoveTo(135,600));
					path.getElements().add(new LineTo(240,600));
					PathTransition pt = new PathTransition(Duration.millis(2000), path, rec);
					pt.setCycleCount(1);
					pt.play();
					RotateTransition rt = new RotateTransition(Duration.millis(500), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});


	

			KeyFrame kf1 = new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					Path path1 = new Path();
					path1.getElements().add(new MoveTo(240, 600));
					path1.getElements().add(new LineTo(420, 600));
					PathTransition pt = new PathTransition(Duration.millis(2000), path1, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			
			KeyFrame kf2 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					RotateTransition rt1 = new RotateTransition(Duration.millis(500), rec);
					rt1.setByAngle(-90);
					rt1.setAutoReverse(true);
					rt1.play();

				}

			});

			KeyFrame kf3 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					Path path2 = new Path();
					path2.getElements().add(new MoveTo(420, 600));
					path2.getElements().add(new LineTo(420, 120));
					PathTransition pt = new PathTransition(Duration.millis(5000), path2, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});

			KeyFrame kf4 = new KeyFrame(Duration.seconds(16.3), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					RotateTransition rt2 = new RotateTransition(Duration.millis(500), rec);
					rt2.setByAngle(-90);
					rt2.setAutoReverse(true);
					rt2.play();

				}

			});

			KeyFrame kf5 = new KeyFrame(Duration.seconds(16.5), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
				
					Path path3 = new Path();
					path3.getElements().add(new MoveTo(420, 115));
					path3.getElements().add(new LineTo(280, 115));
					PathTransition pt = new PathTransition(Duration.millis(2000), path3, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf6 = new KeyFrame(Duration.seconds(20), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					dialogStage.close();

				}

			});
			
			

			// ligne temporelle d'entrée de la voiture
			Timeline timeline = new Timeline(kf, kf1, kf2, kf3, kf4, kf5, kf6);
			//Timeline timeline = new Timeline(kf, kf1);
			timeline.setCycleCount(1);
			timeline.setAutoReverse(true);
			timeline.playFromStart();
			
		

			Scene scene = new Scene(page, 900, 700);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
