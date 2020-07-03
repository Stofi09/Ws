package com.poker.ws.chatmassage;

import org.springframework.beans.factory.annotation.Autowired;

import com.poker.ws.result.Result;

// Needs to refactor.
public class ChatMessage {

	private String content;
	private String sender;
	private MessageType type;
	private int playerNo;
	private int oppRaise;
	private int reCall;
	private int overRaise;
	private boolean hasFirstRaised;
	private boolean hasCallRaised;
	private boolean hasOverRaised;
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
	private int rk11;
	private int rk22;
	private int rk33;
	private int rk44;
	
//	@Autowired
//	private ResultKeeper rk1;
//
//	@Autowired
//	private ResultKeeper rk2;
//	
//	public void setRK(Result res1, Result res2) {
//		//Erase previous results.
////		this.rk1.eraser();
////		this.rk2.eraser();
//		//Set results.
//		this.rk1.getRes(res1.getRes1(),res1.getRes2());
//		this.rk11 = rk1.getRes1();
//		this.rk22 = rk1.getRes2();
//		this.rk2.getRes(res2.getRes1(),res2.getRes2());
//		this.rk33= rk2.getRes1();
//		this.rk44 =rk2.getRes2();
//	}

	
	

	public int getRk11() {
		return rk11;
	}




	public void setRk11(int rk11) {
		this.rk11 = rk11;
	}




	public void setRk22(int rk22) {
		this.rk22 = rk22;
	}




	public void setRk33(int rk33) {
		this.rk33 = rk33;
	}




	public void setRk44(int rk44) {
		this.rk44 = rk44;
	}




	public int getRk22() {
		return rk22;
	}




	public int getRk33() {
		return rk33;
	}




	public int getRk44() {
		return rk44;
	}




	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public enum MessageType {
		CHAT, LEAVE, JOIN, CHECK, RAISE, START, CALL, CALLRAISE
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

	public int getOppRaise() {
		return oppRaise;
	}

	public void setOppRaise(int oppRaise) {
		this.oppRaise = oppRaise;
	}

	public int getReCall() {
		return reCall;
	}

	public void setReCall(int reCall) {
		this.reCall = reCall;
	}

	public int getOverRaise() {
		return overRaise;
	}

	public void setOverRaise(int overRaise) {
		this.overRaise = overRaise;
	}

	public boolean isHasFirstRaised() {
		return hasFirstRaised;
	}

	public void setHasFirstRaised(boolean hasFirstRaised) {
		this.hasFirstRaised = hasFirstRaised;
	}

	public boolean isHasCallRaised() {
		return hasCallRaised;
	}

	public void setHasCallRaised(boolean hasCallRaised) {
		this.hasCallRaised = hasCallRaised;
	}

	public boolean isHasOverRaised() {
		return hasOverRaised;
	}

	public void setHasOverRaised(boolean hasOverRaised) {
		this.hasOverRaised = hasOverRaised;
	}




	
	
}
