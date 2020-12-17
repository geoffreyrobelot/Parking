package controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import application.Dao;
import application.MainBarriereEnPanne;
import application.MainCarteEmploye;
import application.MainCarteVisiteur;

import application.MainSimulateur;
import application.MainUneVoiturePart;
import application.MainUneVoiturePartVisiteur;
import application.MainUneVoitureSePresente;
import application.MainUneVoitureSePresenteVisiteur;
import controller.Barriere;
import controller.Borne;
import controller.Feu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import model.Carte;
import model.Stationnement;
import model.Stationnementvisiteur;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class ControleurParking {

	private Dao dao;

	private MainCarteEmploye mainCarteEmploye;

	private MainSimulateur mainsimulateur;

	private MainCarteVisiteur mainCarteVisiteur;

	private MainUneVoitureSePresente mainUneVoitureSePresente;

	private MainUneVoitureSePresenteVisiteur mainUneVoitureSePresenteVisiteur;

	private MainUneVoiturePart mainUneVoiturePart;
	
	private MainUneVoiturePartVisiteur mainUneVoiturePartVisiteur;
	
	private MainBarriereEnPanne mainBarriereEnPanne;

	// instanciation de la classe Borne 
	Borne borne = new Borne();
	// instanciation de la classe Feu
	Feu feu = new Feu();
	// instanciation de la classe Barriere
	Barriere barriere = new Barriere();
	
	
	public ControleurParking() {
		dao = new Dao();
	}

	@FXML
	private ToggleGroup user;

	@FXML
	private RadioButton operateur;

	@FXML
	private RadioButton administrateur;

	@FXML
	private Label utilisateurparking;

	@FXML
	private Label utilisateurparkingvisiteur;

	@FXML
	public ListView<Carte> listViewCarte;
	public ObservableList<Carte> observableCarte = FXCollections.observableArrayList();

	@FXML
	private ListView<Carte> listViewCarteVisiteur;
	private ObservableList<Carte> observableCarteVisiteur = FXCollections.observableArrayList();

	@FXML
	private ListView<Stationnement> listViewParking;
	private ObservableList<Stationnement> observableParking = FXCollections.observableArrayList();

	@FXML
	private ListView<Stationnementvisiteur> listViewParkingVisiteur;
	private ObservableList<Stationnementvisiteur> observableParkingVisiteur = FXCollections.observableArrayList();

	/*
	 * m�thode initialis�e lors du d�marrage de l'application.
	 */
	@FXML
	private void initialize() {

		listViewCarte.setItems(observableCarte);
		listViewCarteVisiteur.setItems(observableCarteVisiteur);
		listViewParking.setItems(observableParking);
		listViewParkingVisiteur.setItems(observableParkingVisiteur);

		afficheCompteurVehicule();
		afficheCompteurVehiculeVisiteur();
		stationnementVehiculeEnCours();
		stationnementVisiteurEnCours();

	}

	///////////// Contr�le d'acc�s au parking ////////////////

	/*
	 * accesseur r�f�rence sur l'objet de type MainCarteEmploye
	 */
	public void setMainCarteEmploye(MainCarteEmploye mainCarteEmploye) {
		this.mainCarteEmploye = mainCarteEmploye;
	}

	/*
	 * m�thode qui ouvre la vue VueCarteEmploye.
	 * la vue s'ouvre seulement si le radiobutton operateur ou administrateur est s�l�ctionn�.
	 * Si pas de selection, une alerte s'affiche
	 */
	@FXML
	private void ajouterCarteEmploye() {
		if (operateur.isSelected() || administrateur.isSelected()) {
			mainCarteEmploye.montrerLaVue();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setContentText("Il faut �tre op�rateur ou administrateur pour cette action");
			alert.showAndWait();
		}
	}
	
	/*
	 * accesseur r�f�rence sur l'objet de type MainCarteVisiteur.
	 */

	public void setMainCarteVisiteur(MainCarteVisiteur mainCarteVisiteur) {
		this.mainCarteVisiteur = mainCarteVisiteur;
	}

	/*
	 * m�thode qui ouvre la vue VueCarteVisiteur.
	 * la vue s'ouvre seulement si le radiobutton operateur ou administrateur est s�l�ctionn�.
	 * Si pas de selection, une alerte s'affiche
	 */
	@FXML
	private void ajouterCarteVisiteur() {
		if (operateur.isSelected() || administrateur.isSelected()) {
			mainCarteVisiteur.montrerLaVue();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setContentText("Il faut �tre op�rateur ou administrateur pour cette action");
			alert.showAndWait();
		}
	}

	/*
	 * m�thode qui cr�ee une liste de cartes de type Employe.
	 * pour chaque objet carte de la liste, la liste observable est aliment�e.
	 */
	@FXML
	private void afficherListeCarteEmploye() {
		observableCarte.clear();
		List<Carte> listeCarte = dao.afficherCarteEmploye();
		for (Carte c : listeCarte)
			observableCarte.add(c);

	}

	/*
	 * m�thode qui cr�ee une liste de cartes de type Visiteur.
	 * pour chaque objet carte de la liste, la liste observable est aliment�e.
	 */
	@FXML
	private void afficherListeCarteVisiteur() {
		observableCarteVisiteur.clear();
		List<Carte> listeCarteVisiteur = dao.afficherCarteVisiteur();
		for (Carte c : listeCarteVisiteur)
			observableCarteVisiteur.add(c);

	}

	/*
	 * m�thode qui permet de supprimer une carte. 
	 * cette op�ration n'est possible que si le radiobutton operateur ou administrateur est s�l�ctionn�. 
	 */
	@FXML
	private void supprimerCarte() {
		if (operateur.isSelected() || administrateur.isSelected()) {
			
			Carte carte = listViewCarte.getSelectionModel().getSelectedItem();
			
			// si une carte est s�l�ctionn�e
			if (carte != null) {
				// affichage d'une fenetre de type "confirmation"
				Alert alert = new Alert(AlertType.CONFIRMATION);
				// titre de la fenetre
				alert.setTitle("Attention !");
				// texte affich� dans la fenetre
				alert.setHeaderText("Vous allez supprimer une carte");
				alert.setContentText("Etes-vous s�r de vouloir continuer ?");
				// affichage de boutons de s�lection et attente de r�ponse de l'utilisateur
				Optional<ButtonType> result = alert.showAndWait();
				// Si bouton "ok" selectionn�
				if (result.get() == ButtonType.OK) {
					// appel de la m�thode de la Dao supprimerCarte avec comme paramatre la carte
					dao.supprimerCarte(carte);
					// vide l'observabelist
					observableCarte.clear();
					// affichage de la liste des cartes employ� � jour
					afficherListeCarteEmploye();
				

				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Suppression carte");
				alert.setContentText("Aucune carte s�l�ction�e");
				alert.showAndWait();
				System.out.println("Aucune carte s�lectionn�e");
			}
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setContentText("Il faut �tre op�rateur ou administrateur pour cette action");
			alert.showAndWait();
		}
	}

	/*
	 * m�thode qui permet de supprimer une carte. 
	 * cette op�ration n'est possible que si le radiobutton operateur ou administrateur est s�l�ctionn�. 
	 */
	@FXML
	private void supprimerCarteVisiteur() {
		if (operateur.isSelected() || administrateur.isSelected()) {
			Carte cartevisiteur = listViewCarteVisiteur.getSelectionModel().getSelectedItem();

			// si une cartevisiteur est s�l�ctionn�e
			if (cartevisiteur != null) {
				// affichage d'une fenetre de type "confirmation"
				Alert alert = new Alert(AlertType.CONFIRMATION);
				// titre de la fenetre
				alert.setTitle("Attention !");
				// texte affich� dans la fenetre
				alert.setHeaderText("Vous allez supprimer une carte");
				alert.setContentText("Etes-vous s�r de vouloir continuer ?");
				// affichage de boutons de s�lection et attente de r�ponse de l'utilisateur
				Optional<ButtonType> result = alert.showAndWait();
				// Si bouton "ok" selectionn�
				if (result.get() == ButtonType.OK) {
					// appelle de la m�thode de la Dao supprimerCarte avec comme parametre la cartevisiteur
					dao.supprimerCarte(cartevisiteur);
					// vide l'observablelist
					observableCarteVisiteur.clear();
					// affichage de la liste des cartes � jour
					afficherListeCarteVisiteur();

				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Suppression carte");
				alert.setContentText("Aucune carte s�l�ction�e");
				alert.showAndWait();
				System.out.println("Aucune carte s�lectionn�e");
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Information");
			alert.setContentText("Il faut �tre op�rateur ou administrateur pour cette action");
			alert.showAndWait();
		}
	}

	///////////////// Contr�leur simulateur /////////////////////////

	/*
	 * m�thode permettant de r�cup�rer dans une liste : les stationnements en cours
	 * dans le parking. 
	 * Les stationnements pour lesquels la datesortie = null
	 */
	private void stationnementVehiculeEnCours() {
		Stationnement s = new Stationnement();

		List<Stationnement> listeParking = dao.afficherVehiculeStationneEnCours(s);
		for (Stationnement statio : listeParking)
			observableParking.add(statio);
	}

	/*
	 * m�thode permettant de r�cup�rer dans une liste : les stationnements visiteur
	 * en cours dans le parking. 
	 * Les stationnements pour lesquels la datesortie = null
	 */

	public void stationnementVisiteurEnCours() {
		Stationnementvisiteur s = new Stationnementvisiteur();
		List<Stationnementvisiteur> listeParkingVisiteur = dao.afficherStationnementVisiteurEnCours(s);
		for (Stationnementvisiteur statiovisiteur : listeParkingVisiteur)
			observableParkingVisiteur.add(statiovisiteur);
	}

	/*
	 * m�thode qui permet d'afficher le nombre de v�hicules dans le parking employe.
	 * R�cup�re les stationnements dans la base de donn�es dont le champs datesortie
	 * vaut nul. initialise une variable nombre d'utilisateur qui est �gal � la
	 * taille de la liste parking.
	 * 
	 * Convertit la variable int en chaine de caract�re afin d'affecter la valeur au
	 * label du fxml.
	 */

	private void afficheCompteurVehicule() {
		Stationnement s = new Stationnement();
		List<Stationnement> listeParking = dao.afficherVehiculeStationneEnCours(s);
		// initialise la variable nbutilisateurparking � la taille de la listeparking
		int nbutilisateurparking = listeParking.size();
		System.out.println("nb d'utilisateur dans le parking employ� : " + nbutilisateurparking);

		// convertit la variable int en string
		String userparking = Integer.toString(nbutilisateurparking);
		// affecte la cha�ne de caract�re au label dans le parking.fxml
		utilisateurparking.setText(userparking);
	}

	/*
	 * m�me m�thode que afficheCompteurVehicule mais pour le parking visiteur.
	 */

	private void afficheCompteurVehiculeVisiteur() {
		Stationnementvisiteur s = new Stationnementvisiteur();
		List<Stationnementvisiteur> listeParkingVisiteur = dao.afficherStationnementVisiteurEnCours(s);
		int nbutilisateurparkingvisiteur = listeParkingVisiteur.size();
		System.out.println("nb d'utilisateur dans le parking visiteur : " + nbutilisateurparkingvisiteur);

		String guestuserparking = Integer.toString(nbutilisateurparkingvisiteur);
		utilisateurparkingvisiteur.setText(guestuserparking);
	}

	/*
	 * m�thode bool�enne qui permet de savoir si le parking est complet ou non.
	 * 
	 * return false si le parking est complet
	 * 
	 * return true s'il reste des places
	 */

	private boolean indicateurVisiteurComplet() {
		Stationnementvisiteur s = new Stationnementvisiteur();
		List<Stationnementvisiteur> listeParkingVisiteur = dao.afficherStationnementVisiteurEnCours(s);
		int nbutilisateurparkingvisiteur = listeParkingVisiteur.size();
		String guestuserparking = Integer.toString(nbutilisateurparkingvisiteur);
		utilisateurparkingvisiteur.setText(guestuserparking);

		if (nbutilisateurparkingvisiteur >= 2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Parking visiteur complet");
			alert.showAndWait();
			System.out.println("Parking visiteur complet");

			return false;

		} else

			return true;

	}

	/*
	 * m�thode bool�enne qui permet de savoir si le parking Employ� est complet ou
	 * non.
	 * 
	 * return false si le parking est complet
	 * 
	 * return true s'il reste des places
	 */

	private boolean indicateurComplet() {
		Stationnement s = new Stationnement();
		List<Stationnement> listeParking = dao.afficherVehiculeStationneEnCours(s);
		// initialise la variable nbutilisateurparking � la taille de la listeparking
		int nbutilisateurparking = listeParking.size();
		// convertit la variable int en string
		String userparking = Integer.toString(nbutilisateurparking);
		// affecte la cha�ne de caract�re au label dans le parking.fxml
		utilisateurparking.setText(userparking);

		if (nbutilisateurparking >= 10) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Parking complet");
			alert.showAndWait();
			System.out.println("Parking complet");

			return false;

		} else

			return true;
	}

	/*
	 * m�thode qui permet d'ajouter un stationnement dans le parking visiteur. avant
	 * d'ins�rer un nouveau stationnement, v�rification si le parking n'est pas
	 * complet.
	 * 
	 * affiche le nombre de v�hicule actualis� dans le parking visiteur.
	 * 
	 * Si pas d'objet carte s�lectionn� dans la listViewCarteVisiteur, cr�ation
	 * d'une alerte.
	 */

	@FXML
	private void entreeParkingVisiteur() {

		if (indicateurVisiteurComplet()) {

			Date dateentree = new Date();
			Date datesortie = null;
			Carte carte = listViewCarteVisiteur.getSelectionModel().getSelectedItem();

			if (carte != null && borne.accepterCarte()) {

				Stationnementvisiteur statiovisiteur = new Stationnementvisiteur(dateentree, datesortie, carte);

				// si l'observablelist ne contient pas l'objet statiovisiteur
				if (!observableParkingVisiteur.contains(statiovisiteur)) {

					feu.passageVert();
					barriere.actionnerBarriereOuverture();
					
					dao.ajouterStationnementVisiteur(statiovisiteur);
					observableParkingVisiteur.add(statiovisiteur);
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("Entr�e");
					alert.setContentText("Le visiteur : " + statiovisiteur.getCarte() + " entre dans le parking le "
							+ statiovisiteur.getDateentree());
					alert.showAndWait();
					System.out.println("Le visiteur : " + statiovisiteur.getCarte() + " entre dans le parking le "
							+ statiovisiteur.getDateentree());
					System.out.println("");
					
					feu.passageRouge();
					barriere.actionnerBarriereFermeture();
					
					afficheCompteurVehiculeVisiteur();

				} else {
					System.out.println("le visiteur se trouve d�j� dans le parking");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Dupliqu�");
					alert.setContentText("Le visiteur se trouve d�j� dans le parking");
					alert.showAndWait();
				}
			} else {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Vous n'avez pas s�lectionn� d'utilisateur dans la liste");
				alert.showAndWait();

			}
		}
	}

	/*
	 * m�thode qui permet d'ajouter un stationnement dans le parking employ�. avant
	 * d'ins�rer un nouveau stationnement, v�rification si le parking n'est pas
	 * complet.
	 * 
	 * affiche le nombre de v�hicule actualis� dans le parking employ�.
	 * 
	 * Si pas d'objet carte s�lectionn� dans la listViewCarte, cr�ation d'une
	 * alerte.
	 */

	@FXML
	public void entreeParking() {

		if (indicateurComplet()) {

			Date dateentree = new Date();
			Date datesortie = null;
			Carte carte = listViewCarte.getSelectionModel().getSelectedItem();

			if (carte != null && borne.accepterCarte()) {
				
				Stationnement statio = new Stationnement(dateentree, datesortie, carte);
				
				// si l'observablelist ne contient pas l'objet statiovisiteur
				if (!observableParking.contains(statio)) {
					
					feu.passageVert();
					barriere.actionnerBarriereOuverture();
				
					dao.ajouterStationnement(statio);

					observableParking.add(statio);

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setHeaderText("Entr�e");
					alert.setContentText(
							"L'employ� : " + statio.getCarte() + " entre dans le parking le " + statio.getDateentree());
					alert.showAndWait();

					System.out.println(
							"L'employ� : " + statio.getCarte() + " entre dans le parking le " + statio.getDateentree());
					System.out.println("");

					feu.passageRouge();
					barriere.actionnerBarriereFermeture();
					
					afficheCompteurVehicule();

				} else {
					System.out.println("L'employ� se trouve d�j� dans le parking");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Dupliqu�");
					alert.setContentText("L'employ� se trouve d�j� dans le parking");
					alert.showAndWait();
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Vous n'avez pas s�lectionn� d'utilisateur dans la liste");
				alert.showAndWait();
			}
		}

	}

	/*
	 * m�thode qui met a jour les stationnements dans la liste observable parking.
	 */

	@FXML
	private void afficherStationnement() {
		observableParking.clear();
		Stationnement s = new Stationnement();
		List<Stationnement> listeStationnement = dao.afficherVehiculeStationneEnCours(s);
		for (Stationnement statio : listeStationnement)
			observableParking.add(statio);

	}

	/*
	 * m�thode qui met a jour les stationnements visiteurs dans la liste observable
	 * parking visiteur.
	 */

	@FXML
	private void afficherStationnementVisiteur() {
		observableParkingVisiteur.clear();
		Stationnementvisiteur s = new Stationnementvisiteur();
		List<Stationnementvisiteur> listeStatioVisiteur = dao.afficherStationnementVisiteurEnCours(s);
		for (Stationnementvisiteur statiovisiteur : listeStatioVisiteur)
			observableParkingVisiteur.add(statiovisiteur);
	}

	/*
	 * m�thode qui met � jour un stationnement. met � jour le champs datesortie de
	 * la table stationnementvisiteur avec la date de d�part du parking.
	 */

	@FXML
	private void sortieParkingVisiteur() {
		Stationnementvisiteur statiovisiteur = listViewParkingVisiteur.getSelectionModel().getSelectedItem();

		if (statiovisiteur != null) {

			// affichage d'une fenetre de type "confirmation"
			Alert alert = new Alert(AlertType.CONFIRMATION);
			// titre de la fenetre
			alert.setTitle("Attention !");
			// texte affich� dans la fenetre
			alert.setHeaderText("Voulez vous faire sortir l'utilisateur ? " + statiovisiteur.getCarte());
			alert.setContentText("Etes-vous s�r de vouloir continuer ?");

			// affichage de boutons de s�lection et attente de r�ponse de l'utilisateur
			Optional<ButtonType> result = alert.showAndWait();

			// Si bouton "ok" selectionn�
			if (result.get() == ButtonType.OK) {

				// nouvel objet date, donne la date du jour
				Date date = new Date();

				// alimente le champs datesortie de la table stationnement avec la date du jour
				statiovisiteur.setDatesortie(date);

				// met � jour le stationnement dans la base de donn�es
				dao.updateStationnementvisiteur(statiovisiteur);
				
				barriere.actionnerBarriereOuverture();

				// affiche une alerte
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setHeaderText("Le visiteur  " + statiovisiteur.getCarte() + " a quitt� le parking le " + date);
				alert2.showAndWait();

				System.out.println("Le visiteur : " + statiovisiteur.getCarte() + " a quitt� le parking le " + date);
				System.out.println("");
				
				barriere.actionnerBarriereFermeture();
				
				afficheCompteurVehiculeVisiteur();
				
				afficherStationnementVisiteur();

			} else {
				System.out.println("aucune sortie de parking");
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Vous n'avez pas s�lectionn� de visiteur dans la liste");
			alert.showAndWait();
		}
	}

	/*
	 * m�thode qui met � jour un stationnement. met � jour le champs datesortie de
	 * la table stationnement avec la date de d�part du parking.
	 */

	@FXML
	private void sortieParking() {
		// r�cup�re l'objet stationnement s�lectionn� dans la listViewparking
		Stationnement stationnement = listViewParking.getSelectionModel().getSelectedItem();

		// si l'objet n'est pas nul
		if (stationnement != null) {

			// affichage d'une fenetre de type "confirmation"
			Alert alert = new Alert(AlertType.CONFIRMATION);
			// titre de la fenetre
			alert.setTitle("Attention !");
			// texte affich� dans la fenetre
			alert.setHeaderText("Voulez vous faire sortir l'employ� ? " + stationnement.getCarte());
			alert.setContentText("Etes-vous s�r de vouloir continuer ?");

			// affichage de boutons de s�lection et attente de r�ponse de l'utilisateur
			Optional<ButtonType> result = alert.showAndWait();

			// Si bouton "ok" selectionn�
			if (result.get() == ButtonType.OK) {

				// nouvel objet date, donne la date du jour
				Date date = new Date();

				// alimente le champs datesortie de la table stationnement avec la date du jour
				stationnement.setDatesortie(date);

				// met � jour le stationnement dans la base de donn�es
				dao.updateStationnement(stationnement);
				
				barriere.actionnerBarriereOuverture();

				// affiche une alerte
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setHeaderText("L'employ�  " + stationnement.getCarte() + " a quitt� le parking le " + date);
				alert2.showAndWait();

				System.out.println("L'employ� : " + stationnement.getCarte() + " a quitt� le parking le " + date);
				System.out.println("");
				
				barriere.actionnerBarriereFermeture();

				afficherStationnement();
				
				afficheCompteurVehicule();

			} else {

				System.out.println("aucune sortie de parking");
				afficherStationnement();
				afficheCompteurVehicule();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Vous n'avez pas s�lectionn� d'employ� dans la liste");
			alert.showAndWait();
		}
	}

	/*
	 * m�thode simulant l'arriv�e d'un inconnu � l'entr�e du parking.
	 */

	@FXML
	private void entreeInconnu() {
		
		barriere.actionnerBarriereFermeture();
		feu.passageRouge();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Entr�e inconnu");
		alert.setContentText("Vous n'�tes pas connu. Rapprochez-vous de l'op�rateur");
		alert.showAndWait();
	}

	/*
	 * accesseur r�f�rence sur l'objet de type MainSimulateur.
	 */

	public void setMainSimulateur(MainSimulateur mainsimulateur) {
		this.mainsimulateur = mainsimulateur;
	}

	/*
	 * m�thode qui appelle la vue du simulateur.
	 */

	@FXML
	private void lancerSimulateur() {
		mainsimulateur.montrerLaVue();
	}
	
	/*
	 * accesseur r�f�rence sur l'objet de type MainUneVoiturePartVisiteur.
	 */
	public void setMainUneVoiturePartVisiteur(MainUneVoiturePartVisiteur mainUneVoiturePartVisiteur) {
		this.mainUneVoiturePartVisiteur = mainUneVoiturePartVisiteur;
	}
	
	/*
	 * m�thode qui g�re le simulateur sortie du parking visiteur. 
	 *  
	 */
	@FXML
	private void uneVoiturePartVisiteur() {
		ControleurParking controleurParking=null;
		Stationnementvisiteur statiovisiteur = listViewParkingVisiteur.getSelectionModel().getSelectedItem();

		// si l'objet statiovisiteur n'est pas nul
		if (statiovisiteur != null) {
			// nouvel objet date, donne la date � l'instant t
			Date date = new Date();
			// alimente le champs datesortie de la table stationnement avec la date � l'instant t
			statiovisiteur.setDatesortie(date);
			// met � jour le stationnement dans la base de donn�es
			dao.updateStationnementvisiteur(statiovisiteur);
			// appel de la vue UneVoiturePartVisiteur
			mainUneVoiturePartVisiteur.montrerLaVue(controleurParking);

			// affiche une alerte
			Alert alert2 = new Alert(AlertType.INFORMATION);
			// contenu de l'alerte
			alert2.setHeaderText(statiovisiteur.getCarte() + " a quitt� le parking le " + date);
			alert2.showAndWait();

			System.out.println(statiovisiteur.getCarte() + " a quitt� le parking le " + date);
			afficheCompteurVehiculeVisiteur();
			afficherStationnementVisiteur();
		} else {
			System.out.println("Vous n'avez pas s�l�ctionn� de stationnement visiteur dans la liste");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Vous n'avez pas s�l�ctionn� de stationnement visiteur dans la liste ");
			alert.showAndWait();
		}
		
	}

	/*
	 * accesseur r�f�rence sur l'objet de type MainUneVoiturePart.
	 */

	public void setMainUneVoiturePart(MainUneVoiturePart mainUneVoiturePart) {
		this.mainUneVoiturePart = mainUneVoiturePart;
	}

	/*
	 * m�thode qui g�re le simulateur sortie du parking employ�.
	 */
	@FXML
	private void uneVoiturePart() {
		ControleurParking controleurParking = null;
		Stationnement stationnement = listViewParking.getSelectionModel().getSelectedItem();
		// si l'objet stationnement n'est pas nul
		if (stationnement != null) {
			// nouvel objet date, donne la date � l'instant t
			Date date = new Date();
			// alimente le champs datesortie de la table stationnement avec la date � l'instant t
			stationnement.setDatesortie(date);
			// met � jour le stationnement dans la base de donn�es
			dao.updateStationnement(stationnement);
			// appel de la vue UneVoiturePart
			mainUneVoiturePart.montrerLaVue(controleurParking);

			// affiche une alerte
			Alert alert = new Alert(AlertType.INFORMATION);
			// contenu de l'alerte
			alert.setHeaderText(stationnement.getCarte() + " a quitt� le parking le " + date);
			alert.showAndWait();
			// appel de la m�thode pour actualiser les stationnements 
			afficherStationnement();
			// appel de la m�thode pour actualiser l'affichage du nombre de v�hicules dans le parking 
			afficheCompteurVehicule();

		} else {
			System.out.println("Aucun stationnement s�l�ctionn�");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Vous n'avez pas s�lectionn� d'employ� dans la liste");
			alert.showAndWait();
		}
	}

	/*
	 * accesseur r�f�rence sur l'objet de type MainUneVoitureSePresenteVisiteur
	 */
	public void setMainUneVoitureSePresenteVisiteur(MainUneVoitureSePresenteVisiteur mainUneVoitureSePresenteVisiteur) {
		this.mainUneVoitureSePresenteVisiteur = mainUneVoitureSePresenteVisiteur;
	}

	/*
	 * m�thode qui g�re le simulateur entr�e d'un visiteur dans le parking visiteur.
	 * similaire � la m�thode sans simulateur.
	 * appel de la vue du simulateur 
	 */
	@FXML
	private void uneVoitureSePresenteVisiteur() {
		ControleurParking controleurParking = null;
		// si le parking visiteur n'est pas complet 
		if (indicateurVisiteurComplet()) {

			Date dateentree = new Date();
			Date datesortie = null;
			Carte carte = listViewCarteVisiteur.getSelectionModel().getSelectedItem();

			if (carte != null) {

				Stationnementvisiteur statiovisiteur = new Stationnementvisiteur(dateentree, datesortie, carte);

				if (!observableParkingVisiteur.contains(statiovisiteur)) {

					dao.ajouterStationnementVisiteur(statiovisiteur);
					observableParkingVisiteur.add(statiovisiteur);
					// appel de la vue du simulateur UneVoitureSePresenteVisiteur
					mainUneVoitureSePresenteVisiteur.montrerLaVue(controleurParking);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText("Pr�sence parking visiteur");
					alert.setContentText(
							statiovisiteur.getCarte() + " est entr� dans le parking visiteur le " + statiovisiteur.getDateentree());
					alert.showAndWait();
					afficheCompteurVehiculeVisiteur();
				} else {
					System.out.println("le visiteur se trouve d�j� dans le parking");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setContentText("le visiteur se trouve d�j� dans le parking");
					alert.showAndWait();
				} 
			} else {
				System.out.println("pas de carte s�l�ctionn�e");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("S�l�ction carte");
				alert.setContentText("Vous n'avez pas de s�l�ctionner de carte dans la liste employ�");
				alert.showAndWait();
			}
		}
	}

	/*
	 * accesseur r�f�rence sur l'objet de type MainUneVoitureSePresente.
	 */

	public void setMainUneVoitureSePresente(MainUneVoitureSePresente mainUneVoitureSePresente) {
		this.mainUneVoitureSePresente = mainUneVoitureSePresente;
	}

	/*
	 * m�thode qui g�re le simulateur entr�e d'un employ� dans le parking employ�.
	 * similaire � la m�thode sans simulateur.
	 * appel de la vue du simulateur 
	 */

	@FXML
	private void uneVoitureSePresente() {
		ControleurParking controleurParking = null;

		if (indicateurComplet()) {

			Date dateentree = new Date();
			Date datesortie = null;

			Carte carte = listViewCarte.getSelectionModel().getSelectedItem();
			if (carte != null) {

				Stationnement statio = new Stationnement(dateentree, datesortie, carte);

				if (!observableParking.contains(statio)) {
					dao.ajouterStationnement(statio);
					observableParking.add(statio);
					// appel de la vue du simulateur UneVoitureSePresente
					mainUneVoitureSePresente.montrerLaVue(controleurParking);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText("Pr�sence parking");
					alert.setContentText(
							statio.getCarte() + " est entr� dans le parking employ� le " + statio.getDateentree());
					alert.showAndWait();
					afficheCompteurVehicule();

				} else {
					System.out.println("l'employ� se trouve d�j� dans le parking");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setContentText("L'employ� se trouve d�j� dans le parking");
					alert.showAndWait();
				}
			} else {
				System.out.println("pas de carte s�l�ctionn�e");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("S�l�ction carte");
				alert.setContentText("Vous n'avez pas de s�l�ctionner de carte dans la liste employ�");
				alert.showAndWait();
			}
		}
	}
	
	//////////////////////////// Gestion des pannes simulateur ////////////////////////////////////
	
	/*
	 * accesseur r�f�rence sur l'objet de type MainBarriereEnPanne 
	 */
	public void setMainBarriereEnPanne(MainBarriereEnPanne mainBarriereEnPanne) {
		this.mainBarriereEnPanne = mainBarriereEnPanne;
	}
	
	/*
	 * m�thode qui g�re la simulation d'une panne de barri�re au parking employ�.
	 * Aucun nouveau stationnement n'est ajout� car la barri�re est bloqu�e.
	 */
	@FXML
	private void barriereEnPanne() {
		ControleurParking controleurParking= null;
		
		if (indicateurComplet()) {

			Date dateentree = new Date();
			Date datesortie = null;

			Carte carte = listViewCarte.getSelectionModel().getSelectedItem();
			if (carte != null) {

				Stationnement statio = new Stationnement(dateentree, datesortie, carte);

				if (!observableParking.contains(statio)) {
					// appel de la vue du simulateur VueBarriereEnPanne
					mainBarriereEnPanne.montrerLaVue(controleurParking);
					
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("D�faillance");
					alert.setContentText("La barri�re ne s'ouvre pas. L'op�rateur va vous contacter");
					alert.showAndWait();
					
					afficheCompteurVehicule();

				} else {
					System.out.println("l'employ� se trouve d�j� dans le parking");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setContentText("L'employ� se trouve d�j� dans le parking");
					alert.showAndWait();
				}
			} else {
				System.out.println("pas de carte s�l�ctionn�e");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("S�l�ction carte");
				alert.setContentText("Vous n'avez pas de s�l�ctionner de carte dans la liste employ�");
				alert.showAndWait();
			}
		}
	
	}

}