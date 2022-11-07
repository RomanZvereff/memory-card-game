package org.example.jeux;

import java.util.ArrayList;
import java.util.List;

import org.example.jeux.cartes.Carte;

public class Joueur {

	private String pseudo;
	private List<Carte> cartesGagnees;
	private boolean isActive = false;

	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		this.cartesGagnees = new ArrayList<>();
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Carte> getCartesGagnees() {
		return cartesGagnees;
	}

	public void setCartesGagnees(List<Carte> cartesGagnees) {
		this.cartesGagnees = cartesGagnees;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public int chooseCard(int capacity) {
		return (int) (Math.random() * capacity);
	}

}
