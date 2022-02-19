package com.eric.messageBoardApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.eric.messageBoardApi.data.messageBoardDb.dao.messagesdb.entity.Messages;
import com.eric.messageBoardApi.service.MessageBoardApiService;

@RestController
@RequestMapping("api/v1/Forum")
public class MessageBoardApiController {
	
	@Autowired
	MessageBoardApiService mbaService;

	@CrossOrigin
	@GetMapping("/AllPostsByUser/{userid}")
	public List<Messages> fetchPostsByUser (@PathVariable String userid) {
		return this.mbaService.getAllMessagesByUser(userid);
	}
	
	@CrossOrigin
	@GetMapping("/AllPosts")
	public List<Messages> fetchPosts () {
		return this.mbaService.getAllMessages();
	}
	
	@CrossOrigin
	@PostMapping("/PostMessage")
	public void postMessage (
			@RequestBody Messages message) {
		this.mbaService.postMessage(message);
	}


}