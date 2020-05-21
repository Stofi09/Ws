package com.poker.ws.result.checker;

public class High {

	// Function to decide which checker has higher card
	// run this func. twice if return =0;
	public static int high(int card1,int card2) {
		if (card1>card2)return 1;
		else if(card1<card2)return 2;
		else return 0;		
	}
}
