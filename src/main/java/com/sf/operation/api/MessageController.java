package com.sf.operation.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.operation.model.Message;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	List<Message> messages=new ArrayList<>();
	
	public MessageController() {
		Message m= new Message(1,"hello");
		Message m1= new Message(2,"hello wold");
		Message m2= new Message(3,"hello message");
		messages.add(m);
		messages.add(m1);
		messages.add(m2);
	}

	@RequestMapping("/message")
	public List<Message> getAllMessages(){
		return messages;
	}
	@RequestMapping("/message/{id}")
	public Message getAllMessages(@PathVariable Integer id){
		for (Message m : messages){
			if(m.getId()==id){
				return m;
			}
		}
		return null;
	}
	@PostMapping("/message")
	public Message saveMessage(@RequestBody Message message){
		messages.add(message);
		return message;
	}
	@DeleteMapping("/message/{id}")
	public Message removeMessage(@RequestBody Message message){
		System.out.println("Message =" + message);
		messages.remove(message);
		return message;
	}
}
