package org.example.jeux;

import org.example.jeux.cartes.Paquet32;

import java.util.ArrayList;
import java.util.List;

public class Memory {

	private Paquet32 lesCartes = new Paquet32();
	private List<Joueur> lesJoueurs = new ArrayList<>();

	public Paquet32 getLesCartes() {
		return lesCartes;
	}

	public void setLesCartes(Paquet32 lesCartes) {
		this.lesCartes = lesCartes;
	}

	public List<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}

	public void setLesJoueurs(List<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	public boolean estTerminee() {
		boolean fini = true;
		int i = 0;
		while (fini && i < lesCartes.size()) { // i gère la fin du paquet
			fini = lesCartes.get(i).estVisible();
			i++;			
		}
		return fini;
	}
		
	
}
