package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.classes.Vehicle;
import fr.diginamic.java17.gestiondepersonnes.classes.Voiture;
import fr.diginamic.java17.gestiondepersonnes.classes.VoiturePoste;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;
import fr.diginamic.java17.gestiondepersonnes.interfaces.Ifacteur;

public class App01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * On va gérer des Personnes et des Vehicles, On va créer des Facteurs et des
		 * Voitures pour la Poste, On va gérer ces créations dans des listes, On va les
		 * trier, les filter .....; JDK 1.8 -> JDK 17
		 */
		Personne p1 = new Facteur("", "", Genre.MR, 0);
		Facteur f1 = new Facteur("Martin", "Martine", Genre.MME, 0);
		Facteur f2 = new Facteur("Dupond", "Martine", Genre.MME, 0);
		Facteur f3 = new Facteur("Germain", "Christophe", Genre.MR, 0);
		Object o1 = new Facteur("Martin", "Martine", Genre.MME, 0);

		Vehicle v1 = new VoiturePoste("102-256-58");
		Voiture vt1 = new VoiturePoste("102-256-58");
		VoiturePoste vp1 = new VoiturePoste("102-256-58");
		Ifacteur ivp1 = new VoiturePoste("102-256-58");

		List<Personne> lp = new ArrayList<>();
		List<Facteur> lf = new ArrayList<>();
		List<Object> lo = new ArrayList<>();
		List<Ifacteur> ilf = new ArrayList<>();

		/**
		 * Add ? dans ilf 3 possibilités par rapport aux déclariations de nos variables
		 */
		ilf.add(f1);
		ilf.add(ivp1);
		ilf.add(vp1);

		ilf.forEach(i -> i.trier());

		/**
		 * Ajouter des facteurs dans lf et je vais afficher uniquement que le Genre.MME
		 */
		lf.add(f1);
		lf.add(f2);
		lf.add(f3);
		// foreach classique de java 1.5 :
//		for (Facteur f : lf) {
//			if (f.getGenre() == Genre.MME) {
//				System.out.println(f);
//			}
//		}
//		for (Facteur l : lf) {
//			switch (l.getGenre()) {
//			case MME:
//				System.out.println(l);
//				break;
//			default:
//				break;
//			}
//		}
		Predicate<Facteur> pfmme = f -> f.getGenre() == Genre.MME;
		Predicate<Facteur> pfmr = f -> f.getGenre() == Genre.MR;

		lf.stream().filter(pfmme).forEach(f -> System.out.println(f));
		lf.stream().filter(pfmr).forEach(f -> System.out.println(f));
		/**
		 * Une liste d'objets
		 */
		lo.add(o1);
		lo.add(f1);
		lo.add(p1);
		lo.add(new String());

		lo.add(v1);
		lo.add(vt1);
		lo.add(vp1);
		lo.add(ivp1);

		// lo.forEach(o->{Sytem.out.println(o);});
		// lamda expression avec le stream()
	}

}
