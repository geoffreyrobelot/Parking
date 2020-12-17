package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import controller.ControleurParking;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class MainCarteVisiteur {

	private Stage primaryStage;

	/*
	 * constructeur de la classe avec arguments
	 * @param stage
	 */
	public MainCarteVisiteur(Stage stage) {
		primaryStage = stage;
	}

	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle fenêtre
	 * "ajouter carte visiteur"
	 */

	public void montrerLaVue() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueCarteVisiteur.fxml"));
			GridPane page = (GridPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Carte Visiteur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);

			Scene scene = new Scene(page, 400, 300);
			dialogStage.setScene(scene);
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
