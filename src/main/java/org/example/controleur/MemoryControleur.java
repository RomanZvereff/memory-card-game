package org.example.controleur;

import org.example.ihm.IOKeyBoardConsole;
import org.example.jeux.Joueur;
import org.example.jeux.Memory;
import org.example.jeux.cartes.Carte;

import java.util.ArrayList;
import java.util.List;

public class MemoryControleur {

    private final Memory memory;

    // TODO constructeur

    public MemoryControleur() {
        this.memory = new Memory();
        this.playGame();
    }

    private void playGame() {
        memory.setLesJoueurs(initPlayers());
        List<Joueur> players = memory.getLesJoueurs();
        setFirstActivePlayer(players);
        IOKeyBoardConsole.print("Start the Memory game \n" + memory.getLesCartes());

        while (memory.getLesCartes().size() != 0) {
            memory.getLesCartes().clearIndexes();
            Joueur activePlayer = getActivePlayer(players);
            Carte firstCard = memory.getLesCartes().openCard(activePlayer);
            printCards();
            Carte secondCard = memory.getLesCartes().openCard(activePlayer);
            printCards();
            if (firstCard.estPaire(secondCard)) {
                activePlayer.getCartesGagnees().add(firstCard);
                activePlayer.getCartesGagnees().add(secondCard);
                for (Integer index : memory.getLesCartes().getIndexes()) {
                    memory.getLesCartes().remove(index);
                }
            } else {
                firstCard.retourner();
                secondCard.retourner();
                switchActivePlayer(players);
            }
        }
    }

    private List<Joueur> initPlayers() {
        List<Joueur> players = new ArrayList<>(2);
        String firstName = IOKeyBoardConsole.readAString("Enter first player name: ");
        String secondName = IOKeyBoardConsole.readAString("Enter second player name: ");
        players.add(new Joueur(firstName));
        players.add(new Joueur(secondName));
        return players;
    }

    private void setFirstActivePlayer(List<Joueur> players) {
        Joueur activePlayer = players.get(0);
        activePlayer.setActive(true);
    }

    private Joueur getActivePlayer(List<Joueur> players) {
        for (Joueur player : players) {
            if (player.isActive()) {
                return player;
            }
        }
        return null;
    }

    private void switchActivePlayer(List<Joueur> players) {
        for (Joueur player : players) {
            player.setActive(!player.isActive());
        }
    }

    private void printCards() {
        IOKeyBoardConsole.print(memory.getLesCartes() + "\n");
    }


    //this.ihm = new IOKeyBoardConsole();


    // TODO méthode jouer
    /*
     * 	 Demander combien il y a de joueurs
     * 	 Demander le pseudo de chaque joueur
     * 	 Tirer au sort un 1er joueur
     *
     *   TQ la partie n'est pas finie :
     *   		demander une carte au joueur courant
     *   		afficher les cartes
     *   		demander une 2e carte au joueur courant
     * 			afficher les cartes
     * 			vérifier si c'est une paire
     * 				--> si oui, le joueur ne change pas et il gagne les cartes
     * 				--> si non, on cache les cartes, on change de joueur.
     */

    // TODO jouer avec des cartes dessinées

}
