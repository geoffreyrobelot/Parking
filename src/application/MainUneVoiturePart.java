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

public class MainUneVoiturePart {
	
	private Stage primaryStage;

	/*
	 * constructeur de la classe avec argument
	 * 
	 * @param stage
	 */
	
	public MainUneVoiturePart(Stage stage) {
		primaryStage = stage;
		
	}
	
	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * simulation une voiture part
	 * 
	 * @param controleurParking
	 */
	
	public void montrerLaVue(ControleurParking controleurParking) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueVoiturePart.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Vue sortie employé");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			
			Image image = new Image("car1_purple.png");
			Rectangle rec = new Rectangle(270, 70, 35, 90);
			ImagePattern imagepattern = new ImagePattern(image);
			rec.setFill(imagepattern);
			page.getChildren().add(rec);

			RotateTransition rotate = new RotateTransition(Duration.millis(0001), rec);
			rotate.setByAngle(-90);
			rotate.setCycleCount(1);
			rotate.setAutoReverse(true);
			rotate.play();
			
			KeyFrame kf = new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 2s");
					Path path = new Path();
					path.getElements().add(new MoveTo(280, 115));
					path.getElements().add(new LineTo(505, 115));
					PathTransition pt = new PathTransition(Duration.millis(4000), path, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf1 = new KeyFrame(Duration.seconds(6), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 6s");
					RotateTransition rt = new RotateTransition(Duration.millis(1000), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});
			
			KeyFrame kf2 = new KeyFrame(Duration.seconds(8), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 8s");
					Path path1 = new Path();
					path1.getElements().add(new MoveTo(505, 115));
					path1.getElements().add(new LineTo(505, 590));
					PathTransition pt = new PathTransition(Duration.millis(4000), path1, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf3 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 12s");
					RotateTransition rt1 = new RotateTransition(Duration.millis(600), rec);
					rt1.setByAngle(-90);
					rt1.setAutoReverse(true);
					rt1.play();

				}

			});

			KeyFrame kf4 = new KeyFrame(Duration.seconds(13), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 13s");
					Path path1 = new Path();
					path1.getElements().add(new MoveTo(505, 590));
					path1.getElements().add(new LineTo(790, 590));
					PathTransition pt = new PathTransition(Duration.millis(3000), path1, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf5 = new KeyFrame(Duration.seconds(16), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 16s");
					RotateTransition rt = new RotateTransition(Duration.millis(700), rec);
					rt.setByAngle(-90);
					rt.setAutoReverse(true);
					rt.play();

				}

			});

			KeyFrame kf6 = new KeyFrame(Duration.seconds(17), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					System.out.println("A 17s");
					Path path = new Path();
					path.getElements().add(new MoveTo(790, 590));
					path.getElements().add(new LineTo(790, -100));
					PathTransition pt = new PathTransition(Duration.millis(5000), path, rec);
					pt.setCycleCount(1);
					pt.play();

				}

			});
			
			KeyFrame kf7 = new KeyFrame(Duration.seconds(20), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					FadeTransition fadetransition = new FadeTransition(Duration.millis(2000), rec);
					fadetransition.setFromValue(1.0);
					fadetransition.setToValue(0.01);
					fadetransition.play();
					
				}
				
			});
			
			KeyFrame kf8 = new KeyFrame(Duration.seconds(22), new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialogStage.close();
				}
				
			});
			
			Timeline timeline = new Timeline(kf, kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8);
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