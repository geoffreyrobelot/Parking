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
 * The persistent class for the carte database table.
 * 
 */
@Entity
@NamedQuery(name="Carte.findAll", query="SELECT c FROM Carte c")
public class Carte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int num;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String nom;

	private String prenom;

	private String type;

	//bi-directional many-to-one association to Stationnement
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="num", referencedColumnName="numCarte", insertable=false, updatable=false)
	private Stationnement stationnement;

	//bi-directional many-to-one association to Stationnement
	@OneToMany(mappedBy="carte")
	private List<Stationnement> stationnements;

	public Carte() {
	}
	
	/*
	 * constructeur de la classe avec arguments. 
	 * @param nom, prenom, type, date
	 */
	public Carte(String nom, String prenom, String type, Date date) {
		this.nom = nom;
		this.prenom = prenom;
		this.type = type; 
		this.date = date;
	}
	
	/*
	 * méthode qui permet l'affichage des chaînes de caractères nom + prenom + type
	 */
	public String toString() {
		return nom + " " + prenom + " : " + type;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Stationnement getStationnement() {
		return this.stationnement;
	}

	public void setStationnement(Stationnement stationnement) {
		this.stationnement = stationnement;
	}

	public List<Stationnement> getStationnements() {
		return this.stationnements;
	}

	public void setStationnements(List<Stationnement> stationnements) {
		this.stationnements = stationnements;
	}
	
	public Stationnement addStationnement(Stationnement stationnement) {
		getStationnements().add(stationnement);
		stationnement.setCarte(this);

		return stationnement;
	}

	public Stationnement removeStationnement(Stationnement stationnement) {
		getStationnements().remove(stationnement);
		stationnement.setCarte(null);

		return stationnement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + num;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Carte other = (Carte) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (num != other.num)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

}