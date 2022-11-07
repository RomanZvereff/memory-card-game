package org.example.jeux.cartes;

import java.awt.Color;

import javax.lang.model.element.ElementKind;

public enum Famille {
	PIQUE("♠", Color.BLACK),
	COEUR("♥", Color.RED),
	CARREAU("♦", Color.RED),
	TREFLE("♣", Color.BLACK);

	private static final Famille[] ELEMENTS = Famille.values();
	
	private String texte;
	private Color couleur;

	private Famille(String caractere, Color couleur) {
		this.texte=caractere;
		this.couleur=couleur;
		
	}

	public Color getCouleur() {
		return couleur;
	}

	public static Famille get(int i) {
		return ELEMENTS[i];
	}
	
	public String toString() {
		//return texte+"("+couleur+")";
		return texte;
	}
	
}
