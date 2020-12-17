package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Carte;
import model.Stationnement;
import model.Stationnementvisiteur;

/*
 * @author Geoffrey Robelot
 * @date 05/2020
 * @project Parking 
 */

public class TestDao {

	/*
	 * classe de test de la classe Dao
	 */

	public static void main(String[] args) {

		// Spécifie le nom de l'unité de la persistence en paramètre
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("parking");
		EntityManager em;
		em = factory.createEntityManager();

		System.out.println("");
		System.out.println("Liste des cartes dans la base de données : ");
		System.out.println("");

		/*
		 * affiche la liste des cartes de la table carte de la base de données
		 */
		TypedQuery<Carte> query = em.createQuery("SELECT c FROM Carte c", Carte.class);
		List<Carte> liste = query.getResultList();
		liste.stream().forEach(i -> System.out
				.println("numCarte : " + i.getNum() + ", utilisateur : " + i.getNom() + ", type : " + i.getType()));
		System.out.println("");

		System.out.println("");
		System.out.println("Liste des stationnements dans la base de données : ");
		System.out.println("");

		/*
		 * affiche la liste des stationnements de la table stationnement de la base de
		 * données
		 */
		TypedQuery<Stationnement> querystationnement = em.createQuery("SELECT s FROM Stationnement s",
				Stationnement.class);
		List<Stationnement> listestationnement = querystationnement.getResultList();
		listestationnement.stream().forEach(i -> System.out.println("Utilisateur : " + i.getCarte() + " / "
				+ " date entrée : " + i.getDateentree() + " / " + " Date sortie : " + i.getDatesortie()));
		System.out.println("");

		/*
		 * affiche la liste des cartes de la table carte où le champs type est égal à
		 * employé
		 */
		TypedQuery<Carte> querycarte = em.createQuery("SELECT c FROM Carte c WHERE c.type='Employe'", Carte.class);
		List<Carte> listecarteemploye = querycarte.getResultList();
		listecarteemploye.stream()
				.forEach(i -> System.out.println(i.getType() + " " + i.getNom() + " " + i.getPrenom()));
		System.out.println("");

		/*
		 * affiche la liste des stationnements visiteur de la table stationnementvisiteur de la base de données 
		 */
		TypedQuery<Stationnementvisiteur> querystationnementvisiteur = em
				.createQuery("SELECT s FROM Stationnementvisiteur s", Stationnementvisiteur.class);
		List<Stationnementvisiteur> listestationnementvisiteur = querystationnementvisiteur.getResultList();
		listestationnementvisiteur.stream().forEach(i -> System.out.println("Utilisateur : " + i.getCarte() + " / "
				+ " date entrée : " + i.getDateentree() + " / " + " Date sortie : " + i.getDatesortie()));
		System.out.println("");

		/*
		 * ajouter une nouvelle carte dans la base de données
		 */

		/*
		 * Carte carte = new Carte("Durand", "Alphonse", "Employe", 4);
		 * em.getTransaction().begin(); em.persist(carte); em.getTransaction().commit();
		 * System.out.println("Vous avez ajouté : " +carte); System.out.println("");
		 */

		/*
		 * méthode qui permet de supprimer une carte dans la base de données
		 */

		/*
		 * Carte c = liste.get(0); em.getTransaction().begin(); em.remove(c);
		 * em.getTransaction().commit();
		 */

	}
}
