package controller;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Barriere {

	// variables 
	String ouverture= "La barrière est ouverte";
	String fermeture= "La barrière est fermée";
	String bloquee= "La barrière est bloquée";

	// instanciation de la classe Feu pour accèder aux méthodes de la classe.
	
	Feu feu = new Feu();

	// constructeur de la classe sans argument.
	public Barriere() {

	}
	
	/*
	 * constructeur de la classe avec arguments.
	 * @param ouverture, fermeture
	 */

	public Barriere(String ouverture, String fermeture, String bloquee) {
		this.ouverture = ouverture;
		this.fermeture = fermeture;
		this.bloquee = bloquee;
	}

	/*
	 * méthode qui permet l'action de la barrière 
	 * @return ouverture
	 */
	public String actionnerBarriereOuverture() {
		System.out.println(ouverture);
		System.out.println("");
		return ouverture;

	}
	
	/*
	 * méthode qui permet l'action de la barrière 
	 * @return fermeture
	 */
	
	public String actionnerBarriereFermeture() {
		System.out.println(fermeture);
		System.out.println("");
		return fermeture;
	}
	
	/*
	 * méthode qui permet de gérer la panne de la barrière
	 * @return bloquee
	 */
	public String barriereBloquee() {
		System.out.println(bloquee);
		System.out.println("");
		return bloquee;
		
	}
}
