package controller;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Barriere {

	// variables 
	String ouverture= "La barri�re est ouverte";
	String fermeture= "La barri�re est ferm�e";
	String bloquee= "La barri�re est bloqu�e";

	// instanciation de la classe Feu pour acc�der aux m�thodes de la classe.
	
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
	 * m�thode qui permet l'action de la barri�re 
	 * @return ouverture
	 */
	public String actionnerBarriereOuverture() {
		System.out.println(ouverture);
		System.out.println("");
		return ouverture;

	}
	
	/*
	 * m�thode qui permet l'action de la barri�re 
	 * @return fermeture
	 */
	
	public String actionnerBarriereFermeture() {
		System.out.println(fermeture);
		System.out.println("");
		return fermeture;
	}
	
	/*
	 * m�thode qui permet de g�rer la panne de la barri�re
	 * @return bloquee
	 */
	public String barriereBloquee() {
		System.out.println(bloquee);
		System.out.println("");
		return bloquee;
		
	}
}
