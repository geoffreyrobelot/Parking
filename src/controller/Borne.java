package controller;

import model.Carte;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Borne {

	// instanciation de la classe Carte afin d'accèder aux méthodes de la classe.
	Carte carte = new Carte();

	/*
	 * constructeur de la classe sans argument.
	 */
	public Borne() {

	}

	/*
	 * méthode qui gère le refus d'une carte 
	 * @return true
	 */
	public boolean refuserCarte() {
		if (!carte.equals(carte)) {
			System.out.println("je suis la borne : je n'accepte pas la carte");
			System.out.println("");
			return true;

		}
		System.out.println("borne : j'accepte la carte");
		return false;
	}
	
	/*
	 * méthode qui gère l'acceptation d'une carte
	 * @return true
	 */

	public boolean accepterCarte() {

		if (carte.equals(carte)) {
			System.out.println("borne : j'accepte la carte");
			System.out.println("");
			return true;

		}
		System.out.println("borne : je n'accepte pas la carte");
		return false;
		

	}

	@Override
	public String toString() {
		return "Borne [carte=" + carte + "]";
	}
}