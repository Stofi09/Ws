package com.poker.ws.game;

import org.springframework.stereotype.Component;

import com.poker.ws.card.Card;

@Component
public class Player {
	
	private int credit;
	
	private Card card1;
	private Card card2;
	
	private String name;
	
	private boolean hasTurned;
	
	public Player() {}
	public Player(String name, int credit) {
		this.name = name;
		this.credit = credit;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// take credit from player
	public void raiseCredit(int raiseCredit) {
		this.credit = this.credit - raiseCredit;
	}
	
	public void setHand(Card card1, Card card2) {
		this.card1 = card1;
		this.card2 = card2;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = this.credit+credit;
	}

	public Card getCard1() {
		return card1;
	}

	public void setCard1(Card card1) {
		this.card1 = card1;
	}

	public Card getCard2() {
		return card2;
	}

	public void setCard2(Card card2) {
		this.card2 = card2;
	}

	public boolean getHasTurned() {
		return hasTurned;
	}

	public void setHasTurned(boolean hasTurned) {
		this.hasTurned = hasTurned;
	}
	@Override
	public String toString() {
		return "Player [credit=" + credit + ", card1=" + card1 + ", card2=" + card2 + ", name=" + name + "]";
	}
	
	
}
