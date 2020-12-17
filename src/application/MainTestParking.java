package application;

import controller.Parking;
import model.Carte;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class MainTestParking {

	public static void main(String[] args) {

		 Carte carte1 = new Carte("Bernard", "Jean", "Employe", null);
		// Carte carte2 = new Carte("Louis", "rene", "Visiteur", null);

		Parking parking = new Parking();

		 parking.ajouteUtilisateur(carte1);

		// parking.ajouteUtilisateur(carte2);

		// System.out.println(carte1);
		System.out.println("places dispos :" + parking.nbPlaceDispo());
		System.out.println("places occupées :" + parking.nbPlaceOccupee());

	}

}
