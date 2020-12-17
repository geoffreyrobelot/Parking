package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import controller.ControleurParking;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;


/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Main extends Application {
	
	
	/*
	 * Cette méthode est le point d'entré de l'application.
	 * Elle est appelée après compilation du projet, 
	 * lorsque l'application est prête à démarrer
	 * 
	 * @param primaryStage. Fenêtre principale de l'application
	 */
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/parking.fxml"));
			GridPane root = (GridPane) loader.load();
			
			Scene scene = new Scene(root, 1000, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Parking");
			primaryStage.setScene(scene);

			// fenêtre ajout carte employe
			
			// instanciation de la classe MainCarteEmploye
			MainCarteEmploye mainCarteEmploye = new MainCarteEmploye(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur = loader.getController();
			controleur.setMainCarteEmploye(mainCarteEmploye);

			// fenêtre simulateur
			
			// instanciation de la classe MainSimulateur
			MainSimulateur mainsimulateur = new MainSimulateur(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur1 = loader.getController();
			controleur1.setMainSimulateur(mainsimulateur);
			
			// fenêtre ajoute carte visiteur 
			
			// instanciation de la classe MainCarteVisiteur
			MainCarteVisiteur mainCarteVisiteur = new MainCarteVisiteur(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur2 = loader.getController();
			controleur2.setMainCarteVisiteur(mainCarteVisiteur);
			
			// fenêtre simulation une voiture sort du parking 
			
			// instanciation de la classe MainUneVoiturePart
			MainUneVoiturePart mainUneVoiturePart = new MainUneVoiturePart(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur3 = loader.getController();
			controleur3.setMainUneVoiturePart(mainUneVoiturePart);
			
			// fenêtre simulation une voiture se présente au parking
			
			// instanciation de la classe MainUneVoitureSePresente
			MainUneVoitureSePresente mainUneVoitureSePresente = new MainUneVoitureSePresente(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur4 = loader.getController();
			controleur4.setMainUneVoitureSePresente(mainUneVoitureSePresente);
			
			// fenêtre simulation une voiture se présente au parking visiteur 
			
			// instanciation de la classe MainUneVoitureSePresenteVisiteur
			MainUneVoitureSePresenteVisiteur mainUneVoitureSePresenteVisiteur = new MainUneVoitureSePresenteVisiteur(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur5 = loader.getController();
			controleur5.setMainUneVoitureSePresenteVisiteur(mainUneVoitureSePresenteVisiteur);
			
			// fenêtre simulation une voiture sort du parking visiteur 
			
			// instanciation de la classe MainUneVoiturePartVisiteur
			MainUneVoiturePartVisiteur mainUneVoiturePartVisiteur = new MainUneVoiturePartVisiteur(primaryStage);
			// donne la référence de l'objet au contrôleur principal
			ControleurParking controleur6 = loader.getController();
			controleur6.setMainUneVoiturePartVisiteur(mainUneVoiturePartVisiteur);
			
			// fenêtre simulation une voiture entre mais la barrière est en panne 
			
			// instanciation de la classe MainBarriereEnPanne
			MainBarriereEnPanne mainBarriereEnPanne = new MainBarriereEnPanne(primaryStage);
			// donne la référence de l'objet au contrôleur principal.
			ControleurParking controleur7 = loader.getController();
			controleur7.setMainBarriereEnPanne(mainBarriereEnPanne);
			
			primaryStage.show();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}
}