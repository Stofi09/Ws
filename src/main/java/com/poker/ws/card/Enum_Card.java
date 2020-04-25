package com.poker.ws.card;


public enum Enum_Card {
//Four types of cards: Heart,Diamond,Spade,Club
// Length: Ace 2 3 4 5 6 7 8 9 10 Jack Queen King
	
//Hearts	

H2	(1 ,2 ,2,"2H.png"),
H3	(1 ,3 ,3,"3H.png"),
H4	(1 ,4 ,4,"4H.png"),
H5	(1 ,5 ,5,"5H.png"),
H6	(1 ,6 ,6,"6H.png"),
H7	(1 ,7 ,7,"7H.png"),
H8	(1 ,8 ,8,"8H.png"),
H9	(1 ,9 ,9,"9H.png"),
H10	(1 ,10 ,10,"10H.png"),
HJ	(1 ,11 ,11,"JH.png"),
HQ	(1 ,12 ,12,"QH.png"),
HK	(1 ,13 ,13,"KH.png"),
HA	(1, 14, 14,"AH.png"),

//Diamonds

D2	(2 ,2 ,15,"2D.png"),
D3	(2 ,3 ,16,"3D.png"),
D4	(2 ,4 ,17,"4D.png"),
D5	(2 ,5 ,18,"5D.png"),
D6	(2 ,6 ,19,"6D.png"),
D7	(2 ,7 ,20,"7D.png"),
D8	(2 ,8 ,21,"8D.png"),
D9	(2 ,9 ,22,"9D.png"),
D10	(2 ,10 ,23,"10D.png"),
DJ	(2 ,11 ,24,"JD.png"),
DQ	(2 ,12 ,25,"QD.png"),
DK	(2 ,13 ,26,"KD.png"),
DA	(2, 14, 27,"AD.png"),

//Spades

S2	(3, 2, 28,"2S.png"),
S3	(3 ,3 ,29,"3S.png"),
S4	(3 ,4 ,30,"4S.png"),
S5	(3 ,5 ,31,"5S.png"),
S6	(3 ,6 ,32,"6S.png"),
S7	(3 ,7 ,33,"7S.png"),
S8	(3 ,8 ,34,"8S.png"),
S9	(3 ,9 ,35,"9S.png"),
S10	(3 ,10 ,36,"10S.png"),
SJ	(3 ,11 ,37,"JS.png"),
SQ	(3 ,12 ,38,"QS.png"),
SK	(3 ,13 ,39,"KS.png"),
SA	(3, 14, 40,"AS.png"),

//Clubs

C2	(4 ,2 ,41,"2C.png"),
C3	(4 ,3 ,42,"3C.png"),
C4	(4 ,4 ,43,"4C.png"),
C5	(4 ,5 ,44,"5C.png"),
C6	(4 ,6 ,45,"6C.png"),
C7	(4 ,7 ,46,"7C.png"),
C8	(4 ,8 ,47,"8C.png"),
C9	(4 ,9 ,48,"9C.png"),
C10	(4 ,10 ,49,"10C.png"),
CJ	(4 ,11 ,50,"JC.png"),
CQ	(4 ,12 ,51,"QC.png"),
CK	(4 ,13 ,52,"KC.png"),
CA	(4, 14, 53,"AC.png");

private final int color;
private final int rank;
private final int id;
private final String img;

Enum_Card(int color,int rank,int id,String img){
	this.color = color;
	this.rank  = rank;
	this.id	   = id;
	this.img = img;
}

public int getColor() {
	return color;
}

public int getRank() {
	return rank;
}

public int getId() {
	return id;
}
public String getImg() {
	return img;
}

}
