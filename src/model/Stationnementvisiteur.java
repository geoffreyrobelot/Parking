package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

/**
 * The persistent class for the stationnementvisiteur database table.
 * 
 */
@Entity
@NamedQuery(name="Stationnementvisiteur.findAll", query="SELECT s FROM Stationnementvisiteur s")
public class Stationnementvisiteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	@Temporal(TemporalType.DATE)
	private Date dateentree;

	@Temporal(TemporalType.DATE)
	private Date datesortie;

	//bi-directional many-to-one association to Carte
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="numCarte")
	private Carte carte;

	public Stationnementvisiteur() {
	}
	
	public Stationnementvisiteur(Date dateentree, Date datesortie, Carte carte) {
		this.dateentree = dateentree;
		this.datesortie = datesortie;
		this.carte = carte;
	}
	
	public String toString() {
		return carte.getNom() + " " + carte.getPrenom() + " " + carte.getType();
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDateentree() {
		return this.dateentree;
	}

	public void setDateentree(Date dateentree) {
		this.dateentree = dateentree;
	}

	public Date getDatesortie() {
		return this.datesortie;
	}

	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}

	public Carte getCarte() {
		return this.carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carte == null) ? 0 : carte.hashCode());
		result = prime * result + ((datesortie == null) ? 0 : datesortie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stationnementvisiteur other = (Stationnementvisiteur) obj;
		if (carte == null) {
			if (other.carte != null)
				return false;
		} else if (!carte.equals(other.carte))
			return false;
		if (datesortie == null) {
			if (other.datesortie != null)
				return false;
		} else if (!datesortie.equals(other.datesortie))
			return false;
		return true;
	}

}