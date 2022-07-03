package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppStream02Reduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lp = new ArrayList<>();
		lp.add(new Facteur("Fact01", "Jean", Genre.MR, 20));
		lp.add(new Facteur("Fact02", "Martine", Genre.MME, 50));
		lp.add(new Facteur("Fact03", "Pauline", Genre.MELLE, 30));
		lp.add(new Facteur("Fact04", "Paul", Genre.MR, 55));

		/**
		 * 1 Cumul de tous les âges de la liste de personne; 2 Cumul des âges pour les
		 * Genre.MMe de la liste de personne; 3 Cumul des âges pour âge >= 50 de la
		 * liste de Personne; 4 Nombre des âges pour âge >= 50 de la liste de Personne;
		 * 5 Count des Genre.MR de la liste de Personne
		 */

		/**
		 * 1 Cumul de tous les âges de la liste de personne
		 */
		int cumul = lp.stream()// Point de départ c'est le stream de ma liste
				.map(p -> p.getAge())// je cible sur quoi je vais travailler
				.reduce((ageCalcule, ageCourant) -> ageCalcule + ageCourant)
				// Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu
				.get();
		System.out.println(cumul);

		/**
		 * 2 Cumul des âges pour les Genre.MMe de la liste de personne
		 */
		int cumulMme = lp.stream()// Point de départ c'est le stream de ma liste
				// Ici j'ai un objet Personne
				.filter(p -> p.getGenre() == Genre.MME)
				// Je peux faire filtre sur le genre
				.map(p -> p.getAge())// je cible sur quoi je vais travailler
				.reduce((ageCalcule, ageCourant) -> ageCalcule + ageCourant)
				// Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu
				.get();
		System.out.println(cumulMme);

		/**
		 * . 3 Cumul des âges pour âge >= 50 de la liste de Personne;
		 */
		int cumulPlusEq50 = lp.stream()// Point de départ c'est le stream de ma liste
				// Ici j'ai un objet Personne

				// Je peux faire filtre sur le genre
				.map(p -> p.getAge())// je cible sur quoi je vais travailler
				.filter(age -> age >= 50)// Filtre sur âge en direct par le map(...)
				.reduce((ageCalcule, ageCourant) -> ageCalcule + ageCourant)
				// Traitement attendu : je mets en place l'agrégat
				// de la formule de calcul attendu
				.get();
		System.out.println(cumulPlusEq50);

		/**
		 * 4 Nombre des âges pour âge >= 50 de la liste de Personne;
		 */
		long nombrePlusEq50 = lp.stream()// Point de départ c'est le stream de ma liste
				.filter(p -> p.getAge() >= 50)// Filtre sur âge en direct par le map(...)
				.count();
		System.out.println(nombrePlusEq50);

		/**
		 * 5 Count des Genre.MR de la liste de Personne
		 */
		long nombreMr = lp.stream()// Point de départ c'est le stream de ma liste
				.filter(p -> p.getGenre() == Genre.MR)// Filtre sur âge en direct par le map(...)
				.count();
		System.out.println(nombreMr);
	}

}
