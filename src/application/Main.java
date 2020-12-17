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
	 * Cette m�thode est le point d'entr� de l'application.
	 * Elle est appel�e apr�s compilation du projet, 
	 * lorsque l'application est pr�te � d�marrer
	 * 
	 * @param primaryStage. Fen�tre principale de l'application
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

			// fen�tre ajout carte employe
			
			// instanciation de la classe MainCarteEmploye
			MainCarteEmploye mainCarteEmploye = new MainCarteEmploye(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur = loader.getController();
			controleur.setMainCarteEmploye(mainCarteEmploye);

			// fen�tre simulateur
			
			// instanciation de la classe MainSimulateur
			MainSimulateur mainsimulateur = new MainSimulateur(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur1 = loader.getController();
			controleur1.setMainSimulateur(mainsimulateur);
			
			// fen�tre ajoute carte visiteur 
			
			// instanciation de la classe MainCarteVisiteur
			MainCarteVisiteur mainCarteVisiteur = new MainCarteVisiteur(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur2 = loader.getController();
			controleur2.setMainCarteVisiteur(mainCarteVisiteur);
			
			// fen�tre simulation une voiture sort du parking 
			
			// instanciation de la classe MainUneVoiturePart
			MainUneVoiturePart mainUneVoiturePart = new MainUneVoiturePart(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur3 = loader.getController();
			controleur3.setMainUneVoiturePart(mainUneVoiturePart);
			
			// fen�tre simulation une voiture se pr�sente au parking
			
			// instanciation de la classe MainUneVoitureSePresente
			MainUneVoitureSePresente mainUneVoitureSePresente = new MainUneVoitureSePresente(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur4 = loader.getController();
			controleur4.setMainUneVoitureSePresente(mainUneVoitureSePresente);
			
			// fen�tre simulation une voiture se pr�sente au parking visiteur 
			
			// instanciation de la classe MainUneVoitureSePresenteVisiteur
			MainUneVoitureSePresenteVisiteur mainUneVoitureSePresenteVisiteur = new MainUneVoitureSePresenteVisiteur(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur5 = loader.getController();
			controleur5.setMainUneVoitureSePresenteVisiteur(mainUneVoitureSePresenteVisiteur);
			
			// fen�tre simulation une voiture sort du parking visiteur 
			
			// instanciation de la classe MainUneVoiturePartVisiteur
			MainUneVoiturePartVisiteur mainUneVoiturePartVisiteur = new MainUneVoiturePartVisiteur(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal
			ControleurParking controleur6 = loader.getController();
			controleur6.setMainUneVoiturePartVisiteur(mainUneVoiturePartVisiteur);
			
			// fen�tre simulation une voiture entre mais la barri�re est en panne 
			
			// instanciation de la classe MainBarriereEnPanne
			MainBarriereEnPanne mainBarriereEnPanne = new MainBarriereEnPanne(primaryStage);
			// donne la r�f�rence de l'objet au contr�leur principal.
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