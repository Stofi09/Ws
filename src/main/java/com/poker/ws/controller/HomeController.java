package com.poker.ws.controller;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poker.ws.card.Card;
import com.poker.ws.chatmassage.ChatMessage;
import com.poker.ws.game.Game;
import com.poker.ws.game.Player;

@Controller
public class HomeController {
	private static int playerNum = 1;
	private static int turn;
	private static Game game;
	private static String lobbyName = "No players are waiting";
	
	
	@RequestMapping("/proba")
	public String proba(Model model) {
		model.addAttribute("title","asd");
		return "proba";
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("status", lobbyName);
		System.out.println("sikerult");
		return "index";
	}
	//Registering new Player
	//Checking if there is already a player in game or not.
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		chatMessage.setPlayerNo(incNum());
		if (lobbyName.equals("No players are waiting")) {
			lobbyName = chatMessage.getSender() + "" + " is waiting.";
		}
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
		game.setCheckTurned(chatMessage.getSender());
		turn = game.turnCounter();
		System.out.println(turn);
		chatMessage.setTurn(turn);
		return chatMessage;
	}
	@MessageMapping("/chat.raise")
	@SendTo("/topic/public")
	public ChatMessage raiseMessage(@Payload ChatMessage chatMessage) {
		game.setRaiseTurned(chatMessage.getSender());
		turn = game.setRaiseTurn(chatMessage.isHasFirstRaised(), chatMessage.isHasCallRaised(),chatMessage.isHasOverRaised());
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
