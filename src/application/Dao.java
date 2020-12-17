package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Carte;
import model.Stationnement;
import model.Stationnementvisiteur;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class Dao {

	/*
	 * Initialisation de JPA
	 * 
	 */

	private EntityManager em;

	public Dao() {

		// Sp�cifie le nom de l'unit� de la persistence en param�tre
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("parking");
		em = factory.createEntityManager();
	}

	/*
	 * m�thode qui permet d'ajouter une carte dans la base de donn�es
	 * 
	 * @param carte
	 */

	public void ajouterCarte(Carte carte) {
		em.getTransaction().begin();
		em.persist(carte);
		em.getTransaction().commit();

	}

	/*
	 * m�thode qui permet d'ajouter un stationnement dans la base de donn�es
	 * 
	 * @param stationnement
	 */

	public void ajouterStationnement(Stationnement stationnement) {
		em.getTransaction().begin();
		em.persist(stationnement);
		em.getTransaction().commit();
	}
	
	/*
	 * m�thode qui permet d'ajouter un stationnement visiteur dans la base de donn�es
	 * 
	 * @param stationnementvisiteur
	 */
	
	public void ajouterStationnementVisiteur(Stationnementvisiteur stationnementvisiteur) {
		em.getTransaction().begin();
		em.persist(stationnementvisiteur);
		em.getTransaction().commit();
	}

	/*
	 * m�thode qui permet de supprimer une carte dans la base de donn�es
	 * 
	 * @param carte
	 */

	public void supprimerCarte(Carte carte) {
		em.getTransaction().begin();
		em.remove(carte);
		em.getTransaction().commit();
	}

	/*
	 * m�thode qui permet de supprimer un stationnement dans la base de donn�es
	 * 
	 * @param stationnement
	 */

	public void supprimerStationnement(Stationnement stationnement) {
		em.getTransaction().begin();
		em.remove(stationnement);
		em.getTransaction().commit();
	}
	

	
	/*
	 * m�thode qui permet de mettre � jour un stationnement dans la base de donn�es
	 * 
	 * @param stationnement
	 */
	
	public void updateStationnement(Stationnement stationnement) {
		em.getTransaction().begin();
		em.merge(stationnement);
		em.getTransaction().commit();
	}
	
	
	/*
	 * m�thode qui permet de mettre � jour un stationnementvisiteur dans la base de donn�es
	 * 
	 * @param stationnementvisiteur
	 */
	
	public void updateStationnementvisiteur(Stationnementvisiteur stationnementvisiteur) {
		em.getTransaction().begin();
		em.merge(stationnementvisiteur);
		em.getTransaction().commit();
	}

	/*
	 * m�thode pour afficher la liste des cartes de la table carte de la base de
	 * donn�es
	 * 
	 * @return liste
	 */

	public List<Carte> afficherListeCarte() {

		TypedQuery<Carte> query = em.createQuery("SELECT c FROM Carte c", Carte.class);
		List<Carte> liste = query.getResultList();
		return liste;

	}

	/*
	 * m�thode pour afficher la liste des stationnements de la table stationnement
	 * de la base de donn�es
	 * 
	 * @return listeStationnement
	 */

	public List<Stationnement> afficherVehiculeStationne() {
		TypedQuery<Stationnement> query = em.createQuery("SELECT s FROM Stationnement s", Stationnement.class);
		List<Stationnement> listeStationnement = query.getResultList();
		return listeStationnement;
	}
	
	
	 /*
	  * m�thode pour afficher les stationnements o� le champs datesortie de la table stationnement n'est pas nul
	  * 
	  * @param s
	  * @return listestatio
	  */
	
	@SuppressWarnings("unchecked")
	public List<Stationnement> afficherVehiculeStationneEnCours(Stationnement s){
		String requete = ("SELECT s FROM Stationnement s WHERE s.datesortie is null");
		Query query = em.createQuery(requete);
		List<Stationnement> listestatio = null;
		listestatio = query.getResultList();
		return listestatio;
		
	}
	
      /*
	  * m�thode pour afficher les stationnements o� le champs datesortie de la table stationnementvisiteur n'est pas nul
	  * 
	  * @param s
	  * @return listestatiovisiteur
	  */
	
	@SuppressWarnings("unchecked")
	public List<Stationnementvisiteur> afficherStationnementVisiteurEnCours (Stationnementvisiteur s){
		String requete = ("SELECT s FROM Stationnementvisiteur s WHERE s.datesortie is null");
		Query query = em.createQuery(requete);
		List<Stationnementvisiteur> listestatiovisiteur = null;
		listestatiovisiteur = query.getResultList();
		return listestatiovisiteur;
		
	}
	
	
	/*
	 * m�thode qui permet d'afficher les cartes o� le champs type est �gal � Employe
	 * 
	 * @return listecarteemploye
	 */
	
	@SuppressWarnings("unchecked")
	public List<Carte> afficherCarteEmploye(){
		String requete = ("SELECT c FROM Carte c WHERE c.type='Employe'");
		Query query = em.createQuery(requete);
		List<Carte> listecarteemploye = null;
		listecarteemploye = query.getResultList();
		return listecarteemploye;
	}
	
	/*
	 * m�thode qui permet d'afficher les cartes o� le champs type est �gal � Visiteur
	 * 
	 * @return listecarteemploye
	 */
	
	@SuppressWarnings("unchecked")
	public List<Carte> afficherCarteVisiteur(){
		String requete = ("SELECT c FROM Carte c WHERE c.type='Visiteur'");
		Query query = em.createQuery(requete);
		List<Carte> listecartevisiteur = null;
		listecartevisiteur = query.getResultList();
		return listecartevisiteur;
	}
		
	

	/*
	 * m�thode pour afficher les cartes en fonction du stationnement s�l�ctionn� cr�ation
	 * d'une requ�te qui s�lectionne le(s) carte(s) d'un stationnement 
	 * Instanciation de la requ�te cr�ation d'une liste vide
	 * 
	 * @param stationnement
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<Carte> afficheCarteDunStationnement(Stationnement stationnement){
		String requete = ("SELECT c FROM Carte c WHERE c.stationnement=?1");
		Query query = em.createQuery(requete);
		List<Carte> listecarte = null;
		query.setParameter(1, stationnement);
		listecarte = query.getResultList();
		return listecarte;
		
	}

}
