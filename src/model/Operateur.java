package model;

import java.io.Serializable;
import javax.persistence.*;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

/**
 * The persistent class for the operateur database table.
 * 
 */
@Entity
@NamedQuery(name="Operateur.findAll", query="SELECT o FROM Operateur o")
public class Operateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	private String login;

	private String mdp;

	/*
	 * constructeur de la classe sans argument.
	 */
	public Operateur() {
	}
	
	/*
	 * constructeur de la classe avec arguments.
	 * @param login, mdp
	 */
	public Operateur(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}

	/*
	 * méthode qui permet l'affichage des chaînes de caractères login + mdp
	 */
	public String toString() {
		return "login: " +login + " mdp : " +mdp;
	}
	
	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}