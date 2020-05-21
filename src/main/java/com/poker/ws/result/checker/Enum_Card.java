package com.poker.ws.result.checker;


public enum Enum_Card {
//Four types of cards: Heart,Diamond,Spade,Club
// Length: Ace 2 3 4 5 6 7 8 9 10 Jack Queen King
	
//Hearts	

H2	(1 ,2 ,2),
H3	(1 ,3 ,3),
H4	(1 ,4 ,4),
H5	(1 ,5 ,5),
H6	(1 ,6 ,6),
H7	(1 ,7 ,7),
H8	(1 ,8 ,8),
H9	(1 ,9 ,9),
H10	(1 ,10 ,10),
HJ	(1 ,11 ,11),
HQ	(1 ,12 ,12),
HK	(1 ,13 ,13),
HA	(1, 14, 14),

//Diamonds

D2	(2 ,2 ,15),
D3	(2 ,3 ,16),
D4	(2 ,4 ,17),
D5	(2 ,5 ,18),
D6	(2 ,6 ,19),
D7	(2 ,7 ,20),
D8	(2 ,8 ,21),
D9	(2 ,9 ,22),
D10	(2 ,10 ,23),
DJ	(2 ,11 ,24),
DQ	(2 ,12 ,25),
DK	(2 ,13 ,26),
DA	(2, 14, 27),

//Spades

S2	(3, 2, 28),
S3	(3 ,3 ,29),
S4	(3 ,4 ,30),
S5	(3 ,5 ,31),
S6	(3 ,6 ,32),
S7	(3 ,7 ,33),
S8	(3 ,8 ,34),
S9	(3 ,9 ,35),
S10	(3 ,10 ,36),
SJ	(3 ,11 ,37),
SQ	(3 ,12 ,38),
SK	(3 ,13 ,39),
SA	(3, 14, 40),

//Clubs

C2	(4 ,2 ,41),
C3	(4 ,3 ,42),
C4	(4 ,4 ,43),
C5	(4 ,5 ,44),
C6	(4 ,6 ,45),
C7	(4 ,7 ,46),
C8	(4 ,8 ,47),
C9	(4 ,9 ,48),
C10	(4 ,10 ,49),
CJ	(4 ,11 ,50),
CQ	(4 ,12 ,51),
CK	(4 ,13 ,52),
CA	(4, 14, 53);

private final int color;
private final int rank;
private final int id;

Enum_Card(int color,int rank,int id){
	this.color = color;
	this.rank  = rank;
	this.id	   = id;
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

}
