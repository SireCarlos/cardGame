package cards;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
public class game  extends JFrame{
    private player[] players;
    private deck deck;
    private table table;
    private int turncounter;
	private int playernumber;
	private int current;
	private boolean gamerunning;
	public Random randomiser;
	public Scanner scan = new Scanner(System.in);
	
	public game(player players[], deck deck){
		this.gamerunning = true; 
		this.players = players;
		this.deck = deck;
		this.table = new table();
		this.turncounter = 1;
		this.playernumber = players.length - 1;
		initGame();
	}
	
	private void nextPlayer(){
		if(current == playernumber){
			current = 0;
		}
		else{
			current++;
		}
	}	
	
	private void initGame() {
		for(int i = 0; i <= playernumber; i++){
			for(int j = 0; j < 5; j++){
				players[i].getHand().setHandCard(deck.dealCard(), j);
			}
		}
		//System.out.println(players[0].getHand().getHandCard(1).getName());
		//int first = randomiser.nextInt((playernumber+1));
		int first = 1;
		System.out.println("Spieler " + first + " fängt an.");
		while(gamerunning){
			turn();
			nextPlayer();
		}	
		return;
	}
	
	private void turn(){
		if (table.getCardOnTop().getNumber() != 0){
			System.out.println("Oberste Karte: " + table.getCardOnTop().printCard());
		}
		else {
			System.out.println("Keine Karte auf dem Tisch.");
		}
		System.out.println("Karten auf dem Tisch: " + table.getNumberOfCardsInPlay());
		for (int i = 0; i < players[current].getHand().getNumberOfCards() ; i++){
			System.out.print("Karte " + (i+1) + ": " + players[current].getHand().getHandCard(i).printCard());
			if(playCard(i, false)){
				System.out.print(" nicht spielbar\n");
			}
			else{
				System.out.print(" spielbar\n");
			}
		}
		int number = 0;
		do{
			System.out.println("Welche Karte spielen? (11 fuer Karte ziehen)");
			number = scan.nextInt() - 1;
			if (number == 10){
				System.out.println(players[current].getName() + " zieht eine Karte.");
				waitForClick();
				drawCard(1);
				break;
			}
			else if(number == 11){
				break;
			}
		}while(playCard(number, true));
		
		if(players[current].getHand().getNumberOfCards() == 0){
			if(table.getCardOnTop().getValue() == 9){
				System.out.println("Letzte Karte war eine 9! " + players[current].getName() + " muss 2 Karten ziehen!");
				drawCard(2);
				waitForClick();
			}
			else{
				gamerunning = false;
				System.out.println(players[current].getName() + " hat gewonnen.");
			}
		}
		if(table.getCardOnTop().getValue() == 9){
			System.out.println(players[current].getName() + " muss neue Karte spielen.");
			number = scan.nextInt() - 1;
			table.addCard(players[current].getHand().getHandCard(number));
			players[current].getHand().removeHandCard(number);
			
		}
		return;
	}
	
	private boolean playCard(int number, boolean mode){
		//False if card is playable, True if not
		card card = players[current].getHand().getHandCard(number);
		if(mode){
			if (table.getCardOnTop().getNumber() == 0){
				table.addCard(card);
				players[current].getHand().removeHandCard(number);
				return false;
			}
			else if(card.getValue() < table.getCardOnTop().getValue()){
				System.out.println("Nicht moeglich!");
				return true;
			}
			else{
				if (card.getColour() == table.getCardOnTop().getColour()){
					table.addCard(card);
					players[current].getHand().removeHandCard(number);
					System.out.println(players[current].getName() + " zieht eine Karte.");
					waitForClick();
					drawCard(1);
				}
				switch(card.getColour()){
					case 1:
						if(table.getCardOnTop().getColour() == 3){
							System.out.println("Nicht moeglich!");
							return true;
						}
						else{
							table.addCard(card);
							players[current].getHand().removeHandCard(number);
							return false;
						}
					case 2:
						if(table.getCardOnTop().getColour() == 1){
							System.out.println("Nicht moeglich!");
							return true;
						}
						else{
							table.addCard(card);
							players[current].getHand().removeHandCard(number);
							return false;
						}
					case 3:
						if(table.getCardOnTop().getColour() == 2){
							System.out.println("Nicht moeglich!");
							return true;
						}
						else{
							table.addCard(card);
							players[current].getHand().removeHandCard(number);
							return false;
						}
					default:
						System.out.println("Ein Fehler ist aufgetreten!");
						return true;
				}
			}
		}
		else{
			if (table.getCardOnTop().getNumber() == 0){
				return false;
			}
			else if(card.getValue() < table.getCardOnTop().getValue()){
				return true;
			}
			else{
				switch(card.getColour()){
					case 1:
						if(table.getCardOnTop().getColour() == 3){
							return true;
						}
						else{
							return false;
						}
					case 2:
						if(table.getCardOnTop().getColour() == 1){
							return true;
						}
						else{
							table.addCard(card);
							return false;
						}
					case 3:
						if(table.getCardOnTop().getColour() == 2){
							return true;
						}
						else{
							return false;
						}
					default:
						return true;
				}
			}
		}
	}
	
	private void redeck(){
		/*
		card[] newdeck = new card[30];
		for (int i = 0; i < table.getNumberOfCardsInPlay(); i++){
			newdeck[i] = table.getCard(i);
		}
		for(int j = table.getNumberOfCardsInPlay(); j < deck.getNumberOfCardsInDeck() - deck.getCounter(); j++){
			int k = 0;
			newdeck[j] = deck.getCard(deck.getCounter() + k++);
		}
		*/
		deck = new deck(table.getCards());
		table = new table();
	}
	
	private void drawCard(int number){
		for(int i = 0; i < number; i++){
			if(deck.getCounter() == deck.getNumberOfCardsInDeck()){
				card temp = table.getCardOnTop();
				redeck();
				table.addCard(temp);
			}
			if(players[current].getHand().getNumberOfCards() == 10){
				System.out.println("Zu viele Karten. Welche Karte entfernen?");
				players[current].getHand().setHandCard(deck.dealCard(), scan.nextInt() - 1);
			}
			else{
				players[current].getHand().setHandCard(deck.dealCard(), players[current].getHand().getNumberOfCards());
			}
		}
	}
	 
    public void waitForClick(){
    	try {
			System.in.read();
		} catch (IOException e) {}
    	return;
    }
    
	public static void main(String[] args){
		player[] player = {new player("Player1", new hand()), new player("Player2", new hand())}; 
		new display();
		new game(player,  new deck());
		return;
	}
}
