package org.example.controleur;

import org.example.ihm.IOKeyBoardConsole;
import org.example.jeux.POM;

public class POMControleur {

	private POM pom;

	public POMControleur() {
		super();
		this.pom = new POM();
		//this.ihm = new IOKeyBoardConsole();
		
		this.jouer();
	}

	private void jouer() {
		
		// TQ la partie n'est pas finie
		while (!this.pom.estTerminee()) {
			// afficher la carte
			IOKeyBoardConsole.print("la carte courante est : "+pom.getEtRetournerCarteCourante().toString());
			// demander le pari
			boolean pari = IOKeyBoardConsole.readABoolean("La carte suivante sera-t-elle supérieure ?");
			// vérifier le pari, compter les points
			if (pom.gererLePari(pari)) {
				IOKeyBoardConsole.print("bravo");
			}
			else {
				IOKeyBoardConsole.print("dommage");
			}			
			pom.passerCarteSuivante();
		}
		if (pom.aGagne()) {
			IOKeyBoardConsole.print("fin de partie : victoire " + pom.getScore());
		}
		else if (pom.aPerdu()) {
			IOKeyBoardConsole.print("fin de partie : défaite " + pom.getScore());
		}
		else {
			IOKeyBoardConsole.print("fin de partie : " + pom.getScore());
		}
	}

	
	
}
