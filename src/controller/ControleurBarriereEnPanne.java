package controller;

import controller.Barriere;
import controller.Borne;
import controller.Feu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;
/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */
public class ControleurBarriereEnPanne {

	// instanciation de la classe Borne 
	Borne borne1 = new Borne();
	// instanciation de la classe Barriere
	Barriere barriere = new Barriere();
	// instanciation de la classe Feu
	Feu feu = new Feu();

	/*
	 * constructeur de la classe sans argument
	 */
	public ControleurBarriereEnPanne() {

	}

	@FXML
	private Label borne;

	/*
	 * méthode initialisée au démarrage de la vue VueBarriereEnPanne
	 */
	@FXML
	private void initialize() {
		borne.setText("");

		KeyFrame kf = new KeyFrame(Duration.millis(6000), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				borne.setText("Présentez votre carte");
			}

		});

		KeyFrame kf1 = new KeyFrame(Duration.millis(8000), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (borne1.accepterCarte()) {
					feu.passageRouge();
					barriere.barriereBloquee();
					borne.setText(barriere.barriereBloquee());

				}
			}
		});

		KeyFrame kf2 = new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Système");
				alert.setContentText("Veuillez patienter");
				alert.show();
			}

		});

		Timeline timeline = new Timeline(kf, kf1, kf2);
		timeline.setAutoReverse(true);
		timeline.play();
	}

}
