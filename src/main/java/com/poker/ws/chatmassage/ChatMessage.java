package com.poker.ws.chatmassage;

public class ChatMessage {

	private String content;
	private String sender;
	private MessageType type;
	private int playerNo;
	private int card1;
	private int card2;
	private int card3;
	private int card4;
	private int card5;
	private int turn;

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public enum MessageType {
		CHAT, LEAVE, JOIN, CHECK, RAISE, START
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public int getCard1() {
		return card1;
	}

	public void setCard1(int card1) {
		this.card1 = card1;
	}

	public int getCard2() {
		return card2;
	}

	public void setCard2(int card2) {
		this.card2 = card2;
	}

	public int getCard3() {
		return card3;
	}

	public void setCard3(int card3) {
		this.card3 = card3;
	}

	public int getCard4() {
		return card4;
	}

	public void setCard4(int card4) {
		this.card4 = card4;
	}

	public int getCard5() {
		return card5;
	}

	public void setCard5(int card5) {
		this.card5 = card5;
	}

	
	
	
}
