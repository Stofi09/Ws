package com.poker.ws.game;

import java.util.ArrayList;
import java.util.HashMap;

import com.poker.ws.card.Card;



public class Game implements iGame{
	
	private Player player1;
	private Player player2;
	private static int numOfPlayerNeeded = 2;
	
	private static ArrayList<Card>deck1;
	
	private int boardCredit;
	
	// Can I init. later?
	HashMap<String, Player> players = new HashMap<>();

	// Sets player at the start of a game.
	@Override
	public void setPlayer(Player player) {
		if (player1 == null) {
			this.player1 = player;
			players.put("player1", this.player1);
		}
		else {
			this.player2 = player;
			players.put("player2", this.player2);
		}
		
	}

	// Do I need a failsafe here?
	public void setPlayersHand() {
		this.player1.setHand(deck1.get(0), deck1.get(1));
		this.player2.setHand(deck1.get(2), deck1.get(3));
	}
	// If it gives back true, the game can start.
	@Override
	public boolean numOfPlayers() {
		int playersNum = players.size();
		if (playersNum == numOfPlayerNeeded)	return true;
		else 	return false;
	}

	// If true, next turn./ when to set false the booleans?
	@Override
	public boolean hasTurned() {
		if (this.player1.getHasTurned() && this.player2.getHasTurned())return true;
		else return false;
	}

	// Set deck at the start of a new game.
	@Override
	public void setDeck(ArrayList<Card> deck) {
		deck1 = deck;
	}

	@Override
	public void nullDeck() {
		deck1.clear();
	}

	// Credit from player to board.
	@Override
	public void giveCredit(Player player, int credit) {
		player.raiseCredit(credit);
		setBoardCredit(credit);
		
		
	}

	
	@Override
	public void creditToPlayer(Player player, int credit) {
		player.setCredit(credit);
		nullBoardCredit();
		
	}
	
	@Override
	public void creditToBothPlayers(Player player1, Player player2, int credit) {
		player1.setCredit(credit);
		player2.setCredit(credit);
		nullBoardCredit();
		
	}

	@Override
	public void nullBoardCredit() {
		this.boardCredit = 0;
		
	}

	@Override
	public int getBoardCredit() {
		return this.boardCredit;
	}

	@Override
	public void setBoardCredit(int credit) {
		this.boardCredit = this.boardCredit+credit;
		
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public static ArrayList<Card> getDeck() {
		return deck1;
	}

	

	

}
