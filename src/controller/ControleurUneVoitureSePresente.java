package controller;


import controller.Barriere;
import controller.Borne;
import controller.Feu;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class ControleurUneVoitureSePresente {

	// instanciation de la classe Borne 
	Borne borne1 = new Borne();
	// instanciation de la classe Feu
	Feu feu = new Feu();
	// instanciation de la classe Barriere
	Barriere barriere = new Barriere();

	/*
	 * constructeur de la classe sans argument
	 */
	public ControleurUneVoitureSePresente() {

	}

	@FXML
	private Label borne;
	
	/*
	 * méthode initialisée au démarrage de la vue UneVoitureSePresente.
	 * gère certaines animations grâce à des clefs temporelles. 
	 * utilisation d'une Timeline pour gérer ces clefs temporelles.
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
					feu.passageVert();
					barriere.actionnerBarriereOuverture();
					borne.setText("La carte est acceptée");
					
					
				}
				else {
					borne1.refuserCarte();
					borne.setText("La carte est refusée");
					feu.passageRouge();
				}
				
				}

		});
		
		KeyFrame kf2 = new KeyFrame(Duration.millis(9500), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				borne.setText("Entrez");
				
				}

		});
		
		KeyFrame kf3 = new KeyFrame(Duration.seconds(13), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				barriere.actionnerBarriereFermeture();
				borne.setText("");
				
				}

		});
		Timeline timeline = new Timeline(kf, kf1, kf2, kf3);
		timeline.setAutoReverse(true);
		timeline.play();

	}
}