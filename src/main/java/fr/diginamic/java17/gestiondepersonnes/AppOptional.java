package fr.diginamic.java17.gestiondepersonnes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.diginamic.java17.gestiondepersonnes.classes.Facteur;
import fr.diginamic.java17.gestiondepersonnes.classes.Personne;
import fr.diginamic.java17.gestiondepersonnes.classes.PersonneServices;
import fr.diginamic.java17.gestiondepersonnes.enums.Genre;

public class AppOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Personne> lf = new ArrayList<>();
		lf.add(new Facteur("Jolie", "Sylvie", Genre.MELLE));
		lf.add(new Facteur("Morand", "Yassine", Genre.MME));
		lf.add(new Facteur("Dutour", "Jean", Genre.MR));

		Optional<Personne> op = PersonneServices.findByNamePersonne(lf, "Jolie");
		if (op.isEmpty()) {
			System.out.println("Personne non trouvée");
		}
		if (op.isPresent()) {
			System.out.println("Personne trouvée : " + op.get());
		}
	}

}
