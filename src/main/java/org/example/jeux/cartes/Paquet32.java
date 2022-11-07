package org.example.jeux.cartes;

import org.example.ihm.IOKeyBoardConsole;
import org.example.jeux.Joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet32 {

	private static final int NBR_FAMILLES = 4;
	private static final int NBR_VALEURS = 8;
	// On refait une façade sur une liste de cartes (avec les méthodes get/add/size...)
	// 32 est indicatif, mais il pourra évoluer au besoin
	// Si vous savez que 32 sera rarement vérifié, autant ne rien mettre.
	private List<Carte> cartes = new ArrayList<Carte>(32);
	private int openedCardCount = 0;
	private List<Integer> indexes = new ArrayList<>(2);

	public Paquet32() {
		super();
		// pour chaque famille  -> int de 0 à 3
		for (int iFamille = 0; iFamille < NBR_FAMILLES; iFamille++) {
			// pour chaque valeur  -> int de 0 à 7
			for (int iValeur = 0; iValeur < NBR_VALEURS; iValeur++) {
				// créer une carte et l'ajouter au paquet this.
				this.add(new Carte(iFamille,iValeur));
			}
		}
		// mélanger
		Collections.shuffle(cartes);
	}
	
	public Carte get(int i) {
		return this.cartes.get(i);
	}

	public boolean add(Carte c) {
		return this.cartes.add(c);
	}

	public void remove(int index) {
		cartes.remove(index);
	}
	
	public int size() {
		return this.cartes.size();
	}

	public Carte openCard(Joueur player) {
		while (true) {
			int cardNum = IOKeyBoardConsole.readANumber(player.getPseudo() +  " choose a card number:");
			if (cardNum > cartes.size() - 1 || cardNum < 0) {
				IOKeyBoardConsole.print("wrong number. from <0> to <" + (cartes.size() - 1) + ">");
				continue;
			}
			Carte carte = cartes.get(cardNum);
			if (!carte.estVisible()) {
				carte.retourner();
				openedCardCount++;
				indexes.add(cardNum);
				return carte;
			} else {
				IOKeyBoardConsole.print("Card with number <" + cardNum + "> is already opened");
			}
		}
	}

	public int getOpenCardCount() {
		return openedCardCount;
	}

	public List<Integer> getIndexes() {
		return indexes;
	}

	public void clearIndexes() {
		indexes.clear();
	}

	@Override
	public String toString() {
		String texte="";
		// TODO plus tard, gérer les cartes déjà gagnées
		for (int i = 0; i < this.size(); i++) {
			// on gère les chiffres pour affichage sur 2 caractères
			if (i<10) {
				texte+=" ";
			}
			texte += i;
			texte += this.get(i)+" ";
			// Utiliser modulo 5 et "\n" pour sauter des lignes
			if (i%5 == 4) {
				texte+="\n";
			}
		}
		return texte;
	}
	
	
}
