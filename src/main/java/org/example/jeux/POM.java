package org.example.jeux;

import org.example.jeux.cartes.Carte;
import org.example.jeux.cartes.Paquet32;

public class POM {
	
	private Paquet32 paquet = new Paquet32();
	private int score = 10;
	private boolean fini=false;
	private int indiceCarteCourante = 0;
	
	public POM() {
		super();
	}

	public boolean estTerminee() {
		return fini;
	}

	public int getScore() {
		return score;
	}

	/**
	 * Il faut connaitre la position de la carte courante
	 * @return la carte courante visible, liée à l'indiceCarteCourante
	 */
	public Carte getEtRetournerCarteCourante() {
		Carte carteCourante = paquet.get(indiceCarteCourante);
		carteCourante.retourner();
		return carteCourante;
	}

	// aGagne -> pour affichage de fin 
	public boolean aGagne() {
//		fini=false;
//		if (score>=20) {
//			fini=true;
//		}
		return score>=20;
	}
	
	// aPerdu -> pour affichage de fin
	public boolean aPerdu() {
		return score<=0;
	}
	
	// gagnerUnPoint --> inutile
	// perdreUnPoint --> inutile
	/**
	 * 
	 * @param pariProchaineSuperieure
	 * @return si le pari a été gagné ou non
	 */
	public boolean gererLePari(boolean pariProchaineSuperieure) {
		boolean gagne=true;
		Carte carteCourante = this.paquet.get(indiceCarteCourante);
		Carte carteSuivante = this.paquet.get(indiceCarteCourante+1);
		if (carteSuivante.estEgale(carteCourante)) {
			gagne = true;
		}
		else if (carteSuivante.estSuperieure(carteCourante)) {
			gagne = pariProchaineSuperieure;
		}
		else {
			gagne = !pariProchaineSuperieure;
		}
		return gagne;
	}

	public void passerCarteSuivante() {
		indiceCarteCourante++;
		// gérer fin du paquet et fin de partie
		fini = this.aGagne() || this.aPerdu() || this.indiceCarteCourante==this.paquet.size()-1;
	}

	@Override
	public String toString() {
		return "POM{" +
				"paquet=" + paquet +
				", score=" + score +
				", fini=" + fini +
				", indiceCarteCourante=" + indiceCarteCourante +
				'}';
	}
}
