package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controller.ControleurParking;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;


/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class MainSimulateur {

	private Stage primaryStage;
	
	public MainSimulateur(Stage stage) {
		primaryStage = stage;
	}
	
	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * "simulateur"
	 */
	
	public void montrerLaVue() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/Fond.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Simulateur");
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
			
			Rectangle rectangle = new Rectangle (323, 575, 14, 45);
			page.getChildren().add(rectangle);

			// permet de gérer l'opacité de l'objet
			FadeTransition fadetransition = new FadeTransition(Duration.millis(1500), rec);
			fadetransition.setFromValue(0.01);
			fadetransition.setToValue(1.0);
			fadetransition.play();

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
			path.getElements().add(new LineTo(240, 600));

			// nouvel objet animation du chemin
			PathTransition pathtransition = new PathTransition(Duration.millis(6000), path, rec);
			pathtransition.setCycleCount(1);
			pathtransition.play();

			// nouvelle clef de l'animation
			// crée un évènement en fonction de la durée
			KeyFrame kf = new KeyFrame(Duration.millis(4200), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 4s");
					RotateTransition rt = new RotateTransition(Duration.millis(500), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame barriere = new KeyFrame(Duration.millis(8000), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					RotateTransition leverbarriere = new RotateTransition(Duration.millis(500), rectangle);
					leverbarriere.setByAngle(-90);
					leverbarriere.setAutoReverse(true);
					leverbarriere.play();
					
				}
				
			});

			KeyFrame kf1 = new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 10s");
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
					System.out.println("A 12s");
					RotateTransition rt1 = new RotateTransition(Duration.millis(500), rec);
					rt1.setByAngle(-90);
					rt1.setAutoReverse(true);
					rt1.play();

				}

			});

			KeyFrame kf3 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 12s");
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
					System.out.println("A 16s");
					RotateTransition rt2 = new RotateTransition(Duration.millis(500), rec);
					rt2.setByAngle(-90);
					rt2.setAutoReverse(true);
					rt2.play();

				}

			});

			KeyFrame kf5 = new KeyFrame(Duration.seconds(16.5), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 16s");
					Path path3 = new Path();
					path3.getElements().add(new MoveTo(420, 115));
					path3.getElements().add(new LineTo(280, 115));
					PathTransition pt = new PathTransition(Duration.millis(2000), path3, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});

			// ligne temporelle d'entrée de la voiture
			Timeline timeline = new Timeline(kf, barriere, kf1, kf2, kf3, kf4, kf5);
			timeline.setCycleCount(1);
			timeline.setAutoReverse(true);
			timeline.playFromStart();

			
			///////////////// sortie de la voiture ///////////////////////////
			
			KeyFrame kf6 = new KeyFrame(Duration.seconds(20), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 20s");
					Path path4 = new Path();
					path4.getElements().add(new MoveTo(280, 115));
					path4.getElements().add(new LineTo(505, 115));
					PathTransition pt = new PathTransition(Duration.millis(4000), path4, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});

			KeyFrame kf7 = new KeyFrame(Duration.seconds(24), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 24s");
					RotateTransition rt3 = new RotateTransition(Duration.millis(1000), rec);
					rt3.setByAngle(-90);
					rt3.setAutoReverse(true);
					rt3.play();

				}

			});

			KeyFrame kf8 = new KeyFrame(Duration.seconds(25), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 25s");
					Path path5 = new Path();
					path5.getElements().add(new MoveTo(505, 115));
					path5.getElements().add(new LineTo(505, 590));
					PathTransition pt = new PathTransition(Duration.millis(4000), path5, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});

			KeyFrame kf9 = new KeyFrame(Duration.seconds(28.5), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 28s");
					RotateTransition rt4 = new RotateTransition(Duration.millis(600), rec);
					rt4.setByAngle(-90);
					rt4.setAutoReverse(true);
					rt4.play();

				}

			});

			KeyFrame kf10 = new KeyFrame(Duration.seconds(29), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 29s");
					Path path6 = new Path();
					path6.getElements().add(new MoveTo(505, 590));
					path6.getElements().add(new LineTo(790, 590));
					PathTransition pt = new PathTransition(Duration.millis(3000), path6, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});

			KeyFrame kf11 = new KeyFrame(Duration.seconds(32), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 32s");
					RotateTransition rt5 = new RotateTransition(Duration.millis(700), rec);
					rt5.setByAngle(-90);
					rt5.setAutoReverse(true);
					rt5.play();

				}

			});

			KeyFrame kf12 = new KeyFrame(Duration.seconds(32.5), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 32s");
					Path path7 = new Path();
					path7.getElements().add(new MoveTo(790, 590));
					path7.getElements().add(new LineTo(790, -100));
					PathTransition pt = new PathTransition(Duration.millis(5000), path7, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf13 = new KeyFrame(Duration.seconds(35), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					FadeTransition fadetransition1 = new FadeTransition(Duration.millis(2000), rec);
					fadetransition1.setFromValue(1.0);
					fadetransition1.setToValue(0.01);
					fadetransition1.play();
					
				}
				
			});

			// ligne temporelle de sortie de la voiture
			Timeline timeline1 = new Timeline(kf6, kf7, kf8, kf9, kf10, kf11, kf12, kf13);
			timeline1.setCycleCount(1);
			timeline1.setAutoReverse(true);
			timeline1.playFromStart();
			
			Scene scene = new Scene(page, 900, 700);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();
			
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
