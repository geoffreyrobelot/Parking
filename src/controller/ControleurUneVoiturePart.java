package controller;

import controller.Barriere;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.util.Duration;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class ControleurUneVoiturePart {

	// instanciation de la classe Barriere.
	Barriere barriere = new Barriere();
	
	/*
	 * constructeur de la classe sans argument.
	 */
	public ControleurUneVoiturePart() {
		
	}
	
	/*
	 * méthode initialisée au démarrage de la vue UneVoiturePart.
	 * gère certaines animations grâce à des clefs temporelles. 
	 * utilisation d'une Timeline pour gérer ces clefs temporelles.
	 */
	@FXML
	private void initialize() {
		
		KeyFrame kf = new KeyFrame(Duration.seconds(18), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				barriere.actionnerBarriereOuverture();
			}

		});
		
		KeyFrame kf1 = new KeyFrame(Duration.seconds(22), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				barriere.actionnerBarriereFermeture();
			}

		});
		
		Timeline tl = new Timeline(kf, kf1);
		tl.setCycleCount(1);
		tl.playFromStart();
		
	}
}
