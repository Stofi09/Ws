package com.poker.ws.card;

import java.util.ArrayList;



public class cards implements Comparable<cards> {
	public static ArrayList<cards> deck;
	private final int  color;
	private final int rank;
	private final int id;
	private final String img;
	
	public cards(int color,int rank,int id,String img) {
		this.color = color;
		this.rank  = rank;
		this.id	   =id;
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

	@Override
	public String toString() {
		return "Card [color=" + color + ", rank=" + rank + ", id=" + id + "]";
	}
	public static ArrayList<cards> makeDeck() {
		ArrayList<cards> deck = new ArrayList<>(); 
		for (Enum_Card e:Enum_Card.values()) {
			deck.add(new cards(e.getColor(),e.getRank(),e.getId(),e.getImg()));
		}
		return deck;
		}
	


	@Override
	public int compareTo(cards o) {
		if (rank == o.rank)return 0;
		else if(rank < o.rank)return 1;
		else return -1;
	}


	
}
