package controller;

import java.util.Date;

import application.Dao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Carte;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class ControleurParkingCarteVisiteur {

	private Dao dao;
	
	/*
	 *  constructeur de la classe 
	 */
	public ControleurParkingCarteVisiteur() {

		dao = new Dao();

	}

	@FXML
	private TextField nom;

	@FXML
	private TextField prenom;

	@FXML
	private Label visiteur;

	@FXML
	private Button annuler;

	@FXML
	private void initialize() {

	}

	/*
	 * méthode qui permet d'ajouter une carte visiteur dans la table carte de la base de données.
	 * si les champs du formulaire ne sont pas vides alors la méthode s'execute.
	 * instanciation de la classe carte. 
	 * appel de la méthode ajouterCarte de la Dao.
	 */
	@FXML
	private void ajouterCarte() {
		if (isEmpty()) {
			String Nom = nom.getText();
			String Prenom = prenom.getText();
			String Visiteur = visiteur.getText();
			Date Date = new Date();

			Carte c = new Carte(Nom, Prenom, Visiteur, Date);
			dao.ajouterCarte(c);
			System.out.println(
					"Vous avez ajouté le visiteur : " + c.getNom() + " " + c.getPrenom() + " " + c.getType());
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setContentText("Vous avez ajouté la carte : " +c.getNom() + " " +c.getPrenom() + " : " +c.getType());
			alert.showAndWait();
			
			Stage dialogStage = (Stage) annuler.getScene().getWindow();
			// ferme la fenêtre du formulaire
			dialogStage.close();
		}
	}

	/*
	 * méthode qui gère le bouton annuler du formulaire.
	 */
	@FXML
	private void annuler() {
		Stage dialogStage = (Stage) annuler.getScene().getWindow();
		// ferme la fenêtre du formulaire
		dialogStage.close();
	}

	/*
	 * méthode qui contrôle si les champs du formulaire sont vides ou non. 
	 * @return false si un ou plusieurs champs sont vides 
	 * @return true si les champs ont une chaîne de caractère supérieure à 1.
	 */
	private boolean isEmpty() {

		String Nom = nom.getText();
		String Prenom = prenom.getText();
		if (Nom.length() < 1 || Prenom.length() < 1) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Champs vide");
			alert.setHeaderText("Veuillez saisir tous les champs du formulaire");
			if (Nom.length() < 1)
				nom.setPromptText(".....");
				prenom.setPromptText(".....");

			if (Prenom.length() < 1)
				nom.setPromptText("....");
				prenom.setPromptText("....");

			alert.showAndWait();
			return false;
		} else
			return true;
	}
}
