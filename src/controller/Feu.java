package controller;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Feu {
	
	// variables 
	
	String rouge = "Le feu est rouge";
	String vert = "Le feu est vert";

	/*
	 * constructeur de la classe sans argument.
	 */
	public Feu() {

	}
	
	/*
	 * constructeur de la classe avec arguments.
	 * @param rouge, vert
	 */
	public Feu(String rouge, String vert) {
		this.rouge = rouge;
		this.vert = vert;
	}
	
	public String toString(String rouge, String vert) {
		return rouge;
		
	}
	
	public String getRouge() {
		return this.rouge;
	}
	
	public void setRouge(String rouge) {
		this.rouge = rouge;
	}
	
	public String getVert() {
		return this.vert;
	}
	
	public void setVert(String vert) {
		this.vert = vert;
	}
	

	/*
	 * méthode qui gère la couleur du feu 
	 * @return vert;
	 */
	public String passageVert() {
		System.out.println(vert);
		System.out.println("");
		return vert;
			
	}
	
	/*
	 * méthode qui gère la couleur du feu
	 * @return rouge;
	 */
	public String passageRouge() {
		System.out.println(rouge);
		System.out.println("");
		return rouge;
		
	}
}
