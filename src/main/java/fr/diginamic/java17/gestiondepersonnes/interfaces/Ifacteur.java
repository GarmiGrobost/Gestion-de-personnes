package fr.diginamic.java17.gestiondepersonnes.interfaces;

public interface Ifacteur {

	default void trier() {
		System.out.println("Je trie par défaut !");
	}
}
