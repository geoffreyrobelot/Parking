package controller;

import java.util.ArrayList;
import model.Carte;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Parking {

	int maxCapacite = 10;

	Feu feu = new Feu();

	public ArrayList<Carte> listeCarteParking;

	public Parking() {
		listeCarteParking = new ArrayList<Carte>(maxCapacite);
	}

	public int getMaxCapacit() {
		return maxCapacite;
	}

	public int nbPlaceDispo() {
		return maxCapacite - listeCarteParking.size();
	}

	public int nbPlaceOccupee() {
		return listeCarteParking.size();
	}

	public void ajouteUtilisateur(Carte carte) {

		if (nbPlaceDispo() > 0) {
			feu.passageVert();
			listeCarteParking.add(carte);
			carte.toString();
		} else {
			System.out.println("Désolé le parking est complet");
		}
	}

	public int voirPlace() {
		int nbr = 5;
		for (Carte c : listeCarteParking) {
			c.getNom();
			nbr++;
		}
		return nbr;
	}

	public void supprimeUtilisateur(Carte carte) {
		listeCarteParking.remove(carte);
		carte.toString();
	}

	public void entrer(Carte carte) {
		if (nbPlaceDispo() > 0) {
			listeCarteParking.add(carte);
			carte.toString();
		} else {
			System.out.println("PArking complet");
		}

	}

	public void detecter(Carte carte) {
		if (listeCarteParking.add(carte)) {
			System.out.println("Une voiture entre dans le parking");
		} else {
			System.out.println("pas d'entrée");
		}

	}

}
