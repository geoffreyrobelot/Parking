package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

/**
 * The persistent class for the stationnement database table.
 * 
 */
@Entity
@NamedQuery(name="Stationnement.findAll", query="SELECT s FROM Stationnement s")
public class Stationnement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	@Temporal(TemporalType.DATE)
	private Date dateentree;

	@Temporal(TemporalType.DATE)
	private Date datesortie;

	//bi-directional many-to-one association to Carte
	@OneToMany(mappedBy="stationnement")
	private List<Carte> cartes;

	//bi-directional many-to-one association to Carte
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="numCarte")
	private Carte carte;

	/*
	 * constructeur de la classe sans argument.
	 */
	public Stationnement() {
	}
	
	/*
	 * constructeur de la classe avec arguments
	 * @param dateentree, datesortie, carte
	 */
	
	public Stationnement(Date dateentree, Date datesortie, Carte carte) {
		this.dateentree = dateentree;
		this.datesortie = datesortie;
		this.carte = carte;
		
	}
	
	/*
	 * méthode qui permet l'affichage des données d'une carte
	 */
	public String toString() {
		return carte.getNom() + " " +carte.getPrenom() + " / " +carte.getType();
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

	public List<Carte> getCartes() {
		return this.cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public Carte addCarte(Carte carte) {
		getCartes().add(carte);
		carte.setStationnement(this);

		return carte;
	}

	public Carte removeCarte(Carte carte) {
		getCartes().remove(carte);
		carte.setStationnement(null);

		return carte;
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
		Stationnement other = (Stationnement) obj;
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