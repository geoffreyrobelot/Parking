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

public class MainCarteEmploye {

	private Stage primaryStage;
	
	/*
	 * constructeur de la classe avec argument
	 */
	public MainCarteEmploye(Stage stage) {
		primaryStage = stage;
	}
	
	/*
	 * méthode appelée dans le controleur principal pour charger la nouvelle
	 * fenêtre "ajouter carte employé
	 */

	public void montrerLaVue() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ControleurParking.class.getResource("../view/VueCarteEmploye.fxml"));
			GridPane page = (GridPane) loader.load();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajout d'une carte employé");
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
