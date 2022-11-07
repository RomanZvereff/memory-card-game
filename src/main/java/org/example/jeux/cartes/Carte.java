package org.example.jeux.cartes;

import java.awt.Color;

public class Carte {

	// il faut une constante pour le texte du dos de la carte [***]
	// une face étant du genre [ D♥]
	private static final String DOS = "[***]";

	private final Famille famille;
	private final Valeur valeur;
	// on ajoute un attribut booléen :
	// qui permet de gérer si la carte est face visible ou cachée
	// on a regardé quel effet du mot clé final ou static
	//private boolean visible=true;
	private boolean visible=false;

	public Carte(Famille famille, Valeur valeur) {
		super();
		this.famille = famille;
		this.valeur = valeur;
	}

	public Carte(int iFamille, int iValeur) {
		super();
		this.famille = Famille.get(iFamille);
		this.valeur = Valeur.get(iValeur);
	}

	
	/**
	 * 	cette méthode retourne physiquement une carte
	 * (face visible ou face cachée)
	 */
	public void retourner() {
//		if (this.visible) {
//			this.visible=false;
//		}
//		else {
//			this.visible=true;
//		}
		this.visible = ! this.visible; // ! java <=> not python
	}

	public boolean estEgale(Carte carte) {
		return this.valeur==carte.valeur;
	}

	public boolean estSuperieure(Carte carte) {
		return this.valeur.estSuperieure(carte.valeur);
	}

	
	public boolean estPaire(Carte autreCarte) {
		/*
		boolean rep=false;
		// implicitement, un paramètre this qui correspond à une instance de Carte
		if (this.valeur==autreCarte.valeur && this.getCouleur()==autreCarte.getCouleur())
		{
			rep=true;
		}
		else
		{
			rep=false;
		}
		return rep;
		*/
		return (this.valeur == autreCarte.valeur && this.getCouleur() == autreCarte.getCouleur());
	}	

	private Color getCouleur() {
		return this.famille.getCouleur();
	}	

	public boolean estVisible() {
		return this.visible;
	}

	/**
	 * gère si la carte est visible (valeur et famille) ou non (DOS) 		
	 */
	@Override
	public String toString() {
		String texte;
//		if (this.visible == true) {
		if (this.visible) {
			texte="["+valeur+famille+"]";
		}
		else {
			texte=DOS;
		}
		return texte;
	}


}
