package org.example.jeux.cartes;

public enum Valeur {
	SEPT(" 7"), HUIT(" 8"), NEUF(" 9"),
	DIX("10"), VALET(" V"), DAME(" D"),
	ROI(" R"), AS("AS");

	private static final Valeur[] ELEMENTS = Valeur.values();

	private String texte;

	private Valeur(String texte) {
		this.texte=texte;
	}
	
	
	public static Valeur get(int i) {
		return ELEMENTS[i];
	}

	@Override
	public String toString() {
		return texte;
	}

	/**
	 * ordinal permet de connaitre l'index d'une instance d'un enum
	 * @param valeur qu'on compare
	 * @return si l'instance this est supérieure à la valeur en paramètre
	 */
	boolean estSuperieure(Valeur valeur) {
		return this.ordinal()>valeur.ordinal();
	}
	
}
