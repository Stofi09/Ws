package com.poker.ws.game;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poker.ws.card.Card;


@Component
public class Game implements iGame{
	
	@Autowired
	private Player player1;
	@Autowired
	private Player player2;
	private static int numOfPlayerNeeded = 2;
	
	private static ArrayList<Card>deck1;
	private static int firstRaise;
	private static int secondRaise;
	private int boardCredit;
	private int turn;
	public Game() {}
	
	// Can I init. later?
	private HashMap<String, Player> players = new HashMap<>();
	
	public void setRaiseTurned(String name) {
		if (name.equals(this.player1.getName())) {
			this.player2.setHasTurned(false);
		}
		else {
			this.player1.setHasTurned(false);
		}
	}
	public int setRaiseTurn(boolean bol1,boolean bol2, boolean bol3) {
		System.out.println(bol1+""+bol2+""+bol3);
		if (bol2 && !bol1 && !bol3) {
			turn++;
		}
		else if (bol1 && bol3)	{
			turn++;
		}
		System.out.println(turn);
		return turn;
	}
	
	public void setCheckTurned(String name) {
		if (name.equals(this.player1.getName())) { 
			this.player1.setHasTurned(true);}
		else if (name.equals(this.player2.getName())) {this.player2.setHasTurned(true);
		}
		else {
			System.err.println(this.player1.getName() +"\\"+ this.player2.getName() );
			System.err.print("There is a problem with names..."+name);
		}
		//implement this later...
		//players.get(name).setHasTurned(true);
	}

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
	public int turnRaiseCounter() {
		
		
		return turn;
	}

	public int turnCounter() {
	
		if (hasTurned()) {
			turn++;
			setTurnFalse();
		}
		// for new games, 7 might not be good?
		if (turn == 7) {
			turn = 0;
		}
		return turn;
	}
	private void setTurnFalse() {
		this.player1.setHasTurned(false);
		this.player2.setHasTurned(false);
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
	
	public int getPlayersSize() {
		return players.size();
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

	public String getBothPlayers() {
		return getPlayer1() +""+ getPlayer2();
	}

	public void nullTurn() {
		this.turn = 0;
	}

}
