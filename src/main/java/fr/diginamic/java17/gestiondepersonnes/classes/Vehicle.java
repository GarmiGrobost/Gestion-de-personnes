package fr.diginamic.java17.gestiondepersonnes.classes;

public abstract class Vehicle {
	private String immatriculation;

	// Constructor
	public Vehicle(String immatriculation) {
		super();
		this.immatriculation = immatriculation;
	}

	// Getter
	public String getImmatriculation() {
		return immatriculation;
	}

	@Override
	public String toString() {
		return "Vehicle [immatriculation = " + immatriculation + "]";
	}

}
