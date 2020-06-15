package com.poker.ws.result;

import com.poker.ws.card.Card;
import com.poker.ws.result.checker.Checker;

public class Result {

private boolean pair = false;
private boolean twoPair = false;
private boolean threeOfAKind = false;
private boolean fourOfAKind = false;
private boolean color5OfAKind = false;
private boolean Seq = false;
private boolean flushSeq = false;
private boolean royalFlush = false;

private int res1;
private int res2;

private  Checker check;

	public Result (Card card1, Card card2, Card card3, Card card4, Card card5, Card card6,Card card7) {
		this.check = new Checker(card1,card2,card3,card4,card5,card6,card7);
	}
	
public void checkBooleans() {
	this.check.doCheck();
	if (this.check.getPairRes1()==1) this.pair = true;
	if (this.check.getPairRes1()==1&&this.check.getPairRes2()==1) this.twoPair = true;
	if(this.check.getPairRes1()==2)this.threeOfAKind = true;
	if(this.check.getPairRes2()==2)this.threeOfAKind = true;
	if(this.check.getPairRes1()==3)this.fourOfAKind = true;
	if(this.check.getColorRes1()==5||this.check.getColorRes2()==5)this.color5OfAKind = true;
	if(this.check.getSeq()==1)this.Seq = true;
	if(this.check.getSeq()==2)this.flushSeq = true;
	if(this.check.getSeq()==3)this.royalFlush = true;
	doReSolve();
}


public void doReSolve() {
	if(this.pair) reSolver(2);
	if(this.twoPair) reSolver(3);
	if(this.threeOfAKind) reSolver(4);
	if(this.Seq) reSolver(5);
	if(this.color5OfAKind) reSolver(6);
	if(this.threeOfAKind&&this.pair) reSolver(7);
	if(this.fourOfAKind) reSolver(8);
	if(this.flushSeq) reSolver(9);
	if (this.royalFlush) reSolver(10);
	System.out.println("The two results are: "+this.res1 + " " + this.res2);
}

private void reSolver(int result ) {
	
	if(this.res1 > result) 	this.res2 = result;
	else this.res1 = result;
 
}

public int getRes1() {
	return this.res1;
}

public int getRes2() {
	return this.res2;
}
public int getCHeckerHigher() {
	return this.check.getHigherCard();
}
public int getCheckerLesser() {
	return this.check.getLesserCard();
}

@Override
public String toString() {
	return "Result [pair=" + pair + ", twoPair=" + twoPair + ", threeOfAKind=" + threeOfAKind + ", fourOfAKind="
			+ fourOfAKind + ", color5OfAKind=" + color5OfAKind + ", Seq=" + Seq + ", flushSeq=" + flushSeq
			+ ", royalFlush=" + royalFlush + "]";
}
	

	
	
}
