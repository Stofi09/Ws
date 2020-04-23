package com.poker.ws.controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.poker.ws.chatmassage.ChatMessage;

@Controller
public class HomeController {
	private static int playerNum = 1;

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		chatMessage.setPlayerNo(incNum());
		return chatMessage;
	}
	
	@MessageMapping("/chat.start")
	@SendTo("/topic/public")
	public ChatMessage startMessage(@Payload ChatMessage chatMessage) {
		chatMessage.setCard1(1);
		chatMessage.setCard2(2);
		chatMessage.setCard3(3);
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
		return chatMessage;
	}
	@MessageMapping("/chat.raise")
	@SendTo("/topic/public")
	public ChatMessage raiseMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	//Increment the number of players.
	public int incNum() {
		return  playerNum++;
	}
	
}
