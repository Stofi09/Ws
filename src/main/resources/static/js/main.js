'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var raiseForm = document.querySelector('#raiseForm');
var raiseInput = document.querySelector('#credit');
var messaheCheck = "Check";
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
    username = document.querySelector('#name').value.trim();
    
//  Set client name individually  
    document.getElementById("playerName1").innerHTML = username;
    
    if(username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/javatechie');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server
    stompClient.send("/app/chat.register",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function send(event) {
    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}

function raise(event) {
	
    var messageContent = raiseInput.value.trim();
    if (raiseInput.value <= document.getElementById("credit1").innerHTML){
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: raiseInput.value,
            type: 'RAISE'
        };

        stompClient.send("/app/chat.raise", {}, JSON.stringify(chatMessage));
        raiseInput.value = '';
    }    
    }
    else{
    alert(raiseInput.value +"is bigger than"+ document.getElementById("credit1").innerHTML);
    }
    event.preventDefault();
}

function check(event) {
	var messageContent = messaheCheck;

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messaheCheck,
            type: 'CHECK'
        };

        stompClient.send("/app/chat.check", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}



function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    }else if(message.type === 'CHECK'){
    	document.getElementById("status").innerHTML = message.content;
        
    }
    else if(message.type === 'RAISE'){
    	if (message.sender === document.getElementById("playerName1").innerHTML){
    	document.getElementById("credit1").innerHTML = message.content;
    	}
    	else {
    	document.getElementById("credit2").innerHTML = message.content;
    	}
    }else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }

    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)
checkForm.addEventListener('submit', check, true)
raiseForm.addEventListener('submit', raise, true)
