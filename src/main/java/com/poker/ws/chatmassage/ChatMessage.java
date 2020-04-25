package com.poker.ws.chatmassage;

public class ChatMessage {

	private String content;
	private String sender;
	private MessageType type;
	private int playerNo;
	private String card1;
	private String card2;
	private String card3;
	private String card4;
	private String card5;
	private String card6;
	private String card7;
	private String card8;
	private String card9;
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

	public String getCard1() {
		return card1;
	}

	public void setCard1(String card1) {
		this.card1 = card1;
	}

	public String getCard2() {
		return card2;
	}

	public void setCard2(String card2) {
		this.card2 = card2;
	}

	public String getCard3() {
		return card3;
	}

	public void setCard3(String card3) {
		this.card3 = card3;
	}

	public String getCard4() {
		return card4;
	}

	public void setCard4(String card4) {
		this.card4 = card4;
	}

	public String getCard5() {
		return card5;
	}

	public void setCard5(String card5) {
		this.card5 = card5;
	}

	public String getCard6() {
		return card6;
	}

	public void setCard6(String card6) {
		this.card6 = card6;
	}

	public String getCard7() {
		return card7;
	}

	public void setCard7(String card7) {
		this.card7 = card7;
	}

	public String getCard8() {
		return card8;
	}

	public void setCard8(String card8) {
		this.card8 = card8;
	}

	public String getCard9() {
		return card9;
	}

	public void setCard9(String card9) {
		this.card9 = card9;
	}

	
	
	
}
