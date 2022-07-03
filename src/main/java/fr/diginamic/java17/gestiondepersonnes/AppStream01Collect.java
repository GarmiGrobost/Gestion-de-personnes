package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppStream01Collect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lp = new ArrayList<>();
		lp.add(new Facteur("Fact01", "Jean", Genre.MR, 0));
		lp.add(new Facteur("Fact02", "Martine", Genre.MME, 0));
		lp.add(new Facteur("Fact03", "Pauline", Genre.MELLE, 0));
		lp.add(new Facteur("Fact04", "Paul", Genre.MR, 0));

		/**
		 * 1 Récupére la liste des nom des Facteurs; 2 Récupérer les noms des Facteurs
		 * dans une chaîne (sans séparateur explicite); 3 Récupérer les noms des
		 * Facteurs dans une chaîne (avec un séparateur)
		 */
		// 1
		/**
		 * List<String> lnoms c'est le résultat attendu -> IMMPOSER EN STREAM ? noms des
		 * facteurs : map(p->p.getNom())-> metrre en mémoire de ma liste :
		 * List<Personne> => uniquement le nom du Facteur; Collect : Traitement qui me
		 * retourne un flux d'information correspondant au type attendu en résultat
		 * List<String>; collect(Collector.toList()); Collector.toList(): C'est le type
		 * de List du contenu dépendant du map. C'est pour cela que j'obtiens une liste
		 * de String.
		 */
		List<String> lnoms = lp.stream().map(p -> p.getNom()).collect(Collectors.toList());
		/**
		 * forEach(System.out::println) Je dépend du type de Lambda Expression de la
		 * méthode () -> forEach(s-> avec la variable)
		 *
		 * forEach(System.out::println) lnoms est une List<String> donc s est un string
		 * forEach(s -> System.out.println(s)) On appelle de façon "statique" la méthode
		 * println de System.out System.out::println : c'est une synthase "alias" Java
		 * fait un callback = il traduit en Lambda Expression selon la définition de la
		 * méthode de la classe avec le ou les paramétres attendues par cette méthode et
		 * aussi de l'appelant : forEach
		 *
		 */
		lnoms.forEach(System.out::println);

		/**
		 * 2 Récuperer les noms des facteurs dans une chaîne(sans séparateur explicite)
		 */
		String nomsDesPersonnes = lp.stream().map(p -> p.getNom()).collect(Collectors.joining());
		// Une concaténation les noms dans le String

		System.out.println(nomsDesPersonnes);

		/**
		 * 3 Récupérer les noms des Facteurs dans une chaîne (avec un séparateur)
		 */
		String nomsDesPersonnesSep = lp.stream().map(p -> p.getNom()).collect(Collectors.joining(";"));
		System.out.println(nomsDesPersonnesSep);
	}

}
