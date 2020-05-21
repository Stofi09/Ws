package com.poker.ws.controller;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


import com.poker.ws.chatmassage.ChatMessage;
import com.poker.ws.game.Game;
import com.poker.ws.game.Player;
import com.poker.ws.card.Card;

@Controller
public class HomeController {
	private static int playerNum = 1;
	private static int turn;
	private static Game game;
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		chatMessage.setPlayerNo(incNum());
		// reg. players. // How to init new Players?
		if (game == null) {
			game = new Game();
			Player player = new Player(chatMessage.getSender(),500);
			game.setPlayer(player);
		}else {
		Player player2 = new Player(chatMessage.getSender(),500);
		game.setPlayer(player2);
		}
		return chatMessage;
	}
	
	@MessageMapping("/chat.start")
	@SendTo("/topic/public")
	public ChatMessage startMessage(@Payload ChatMessage chatMessage) {
		
		turn = game.turnCounter();
		
		ArrayList<Card> deck = new ArrayList<>();
		deck = Card.makeDeck();
		Collections.shuffle(deck);		
				
		
		chatMessage.setCard1(deck.get(0).getImg());
		chatMessage.setCard2(deck.get(1).getImg());
		chatMessage.setCard3(deck.get(2).getImg());
		chatMessage.setCard4(deck.get(3).getImg());
		chatMessage.setCard5(deck.get(4).getImg());
		chatMessage.setCard6(deck.get(5).getImg());
		chatMessage.setCard7(deck.get(6).getImg());
		chatMessage.setCard8(deck.get(7).getImg());
		chatMessage.setCard9(deck.get(8).getImg());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/chat.check")
	@SendTo("/topic/public")
	public ChatMessage cehckMessage(@Payload ChatMessage chatMessage) {
		game.setTurned(chatMessage.getSender());
		turn = game.turnCounter();
		System.out.println(turn);
		chatMessage.setTurn(turn);
		return chatMessage;
	}
	@MessageMapping("/chat.raise")
	@SendTo("/topic/public")
	public ChatMessage raiseMessage(@Payload ChatMessage chatMessage) {
		if (chatMessage.getReCall() == 0) {
			turn = turn - 2;
		}
		turn++;
		chatMessage.setTurn(turn);
		return chatMessage;
	}
	@MessageMapping("/chat.call")
	@SendTo("/topic/public")
	public ChatMessage callMessage(@Payload ChatMessage chatMessage) {
		turn--;
		chatMessage.setTurn(turn);
		return chatMessage;
	}
	//Increment the number of players.
	public int incNum() {
		return  playerNum++;
	}
	public int getTurn() {
		return turn;
	}
	
	
}
