'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var raiseForm = document.querySelector('#raiseForm');
var raiseInput = document.querySelector('#credit');
var startForm = document.querySelector('#startForm');
var messaheCheck = "Check";
var messageStart = "Start";
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var inc = 0;
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

function start(event) {
	
    var messageContent = messageStart;

   
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageStart,
            type: 'START'
        };

        stompClient.send("/app/chat.start", {}, JSON.stringify(chatMessage));
           
    }
    
    event.preventDefault();
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
    var x = document.getElementById("credit1").innerHTML

    if (+raiseInput.value <= +x){
   
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


// when turn 8 reset the game, fold will set turn to 8.
function onMessageReceived(payload) {
	
    var message = JSON.parse(payload.body);
    var num = message.playerNo;
    
    var messageElement = document.createElement('li');

    if(message.type === 'JOIN') {
    	if (message.sender === document.getElementById("playerName1").innerHTML){    		
    		document.getElementById("start").disabled = true;
    		}
    	else{
    		
    		document.getElementById("start").disabled = false;    		
    		}
    	document.getElementById("check").disabled = true;
		document.getElementById("fold").disabled = true;
		document.getElementById("raise").disabled = true;
		
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    }else if(message.type === 'START'){
    	var card1 = message.card1;
    	var card2 = message.card2;
    	var card3 = message.card3;
    	var card4 = message.card4;
    	var card5 = message.card5;
    	var card6 = message.card6;
    	var card7 = message.card7;
    	var card8 = message.card8;
    	var card9 = message.card9;
    	alert("lefut");
    	document.getElementById('card1').src= card1;
    	document.getElementById('card2').src= card2;
    	document.getElementById('card3').src= card3;
    	document.getElementById('card4').src= card4;
    	document.getElementById('card5').src= card5;
    	document.getElementById('card6').src= card6;
    	document.getElementById('card7').src= card7;
    	document.getElementById('card8').src= card8;
    	document.getElementById('card9').src= card9;
    	
    	if (message.sender === document.getElementById("playerName1").innerHTML){
    		document.getElementById("card3").style.visibility = "hidden";
        	document.getElementById("card4").style.visibility = "hidden";
        	document.getElementById("card1").style.visibility = "visible";
        	document.getElementById("card2").style.visibility = "visible";
    	}
    	else{
    		document.getElementById("card1").style.visibility = "hidden";
        	document.getElementById("card2").style.visibility = "hidden";
        	document.getElementById("card3").style.visibility = "visible";
        	document.getElementById("card4").style.visibility = "visible";
    	}
    	
    	
    	document.getElementById("card5").style.visibility = "hidden";
    	document.getElementById("card6").style.visibility = "hidden";
    	document.getElementById("card7").style.visibility = "hidden";
    	document.getElementById("card8").style.visibility = "hidden";
    	document.getElementById("card9").style.visibility = "hidden";
    	
if (message.sender === document.getElementById("playerName1").innerHTML){
    		
    		document.getElementById("check").disabled = false;
    		document.getElementById("fold").disabled = false;
    		document.getElementById("raise").disabled = false;
    		}
    	else{
    		
    		document.getElementById("check").disabled = true;
    		document.getElementById("fold").disabled = true;
    		document.getElementById("raise").disabled = true;
    		
    		}
			document.getElementById("start").disabled = true;
			document.getElementById("card1").disabled = true;
			
    }else if(message.type === 'CHECK'){
    	var turn = message.turn;
    	alert(turn);
    	document.getElementById("status").innerHTML = message.content;
    	if (message.sender === document.getElementById("playerName1").innerHTML){
    		
    		document.getElementById("check").disabled = true;
    		document.getElementById("fold").disabled = true;
    		document.getElementById("raise").disabled = true;
    		}
    	else{
    		
    		document.getElementById("check").disabled = false;
    		document.getElementById("fold").disabled = false;
    		document.getElementById("raise").disabled = false;
    		
    		}
    	
    	if (+turn === 2){
    		document.getElementById("start").disabled = false; 
    		document.getElementById("card5").style.visibility = "visible";
        	document.getElementById("card6").style.visibility = "visible";
        	document.getElementById("card7").style.visibility = "visible";
    	}else if(+turn ===4){
    		document.getElementById("card8").style.visibility = "visible";
    	}else if(+turn ===6){
    		document.getElementById("card9").style.visibility = "visible";
    	}
//    	else if(+turn ===2){
//    		document.getElementById("start").disabled = false; 
//    	}
//    	
    	
    	
    	}
    else if(message.type === 'RAISE'){
    	var turn = message.turn;
    	alert(turn);
    	document.getElementById("status").innerHTML = message.type;
    	if (message.sender === document.getElementById("playerName1").innerHTML){
    		 document.getElementById("credit1").innerHTML = document.getElementById("credit1").innerHTML - message.content;
    		 document.getElementById("boardCredit").innerHTML = +document.getElementById("boardCredit").innerHTML + +message.content;
    		 document.getElementById("check").disabled = true;
     		 document.getElementById("fold").disabled = true;
     		 document.getElementById("raise").disabled = true;
    	}
    	else {
    		
    		document.getElementById("credit2").innerHTML = document.getElementById("credit2").innerHTML - message.content;
    		document.getElementById("boardCredit").innerHTML = +document.getElementById("boardCredit").innerHTML + +message.content;
    		document.getElementById("check").disabled = false;
    		document.getElementById("fold").disabled = false;
    		document.getElementById("raise").disabled = false;
    		
    	}
    	
    	if (+turn === 2){
    		document.getElementById("card5").style.visibility = "visible";
        	document.getElementById("card6").style.visibility = "visible";
        	document.getElementById("card7").style.visibility = "visible";
    	}else if(+turn ===4){
    		document.getElementById("card8").style.visibility = "visible";
    	}else if(+turn ===6){
    		document.getElementById("card9").style.visibility = "visible";
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
//function incTurn() {
//	  document.getElementById("turn").innerHTML = +document.getElementById("turn").innerHTML + +1;
//	}

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
startForm.addEventListener('submit', start, true)
