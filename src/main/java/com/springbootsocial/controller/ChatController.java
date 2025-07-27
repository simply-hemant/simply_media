package com.springbootsocial.controller;

import com.springbootsocial.entity.Chat;
import com.springbootsocial.entity.User;
import com.springbootsocial.exception.ChatException;
import com.springbootsocial.request.CreateChatRequest;
import com.springbootsocial.services.ChatService;
import com.springbootsocial.services.ServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
@AllArgsConstructor
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ServiceInt userService;

    @PostMapping()
    public Chat createChat(@RequestHeader("Authorization") String token,@RequestBody CreateChatRequest req){
        User reqUser = userService.getUserFromToken(token);
        User user2 = userService.getUserById(req.getUserId());
        return chatService.createChat(reqUser, user2);
    }

    @GetMapping()
    public List<Chat> findUsersChats(@RequestHeader("Authorization") String token){
        User user = userService.getUserFromToken(token);
        return chatService.getChatsByUserId(user.getId());
    }

    @GetMapping("{chatId}")
    public Chat findChatById(@PathVariable Long chatId) throws ChatException {
        return chatService.getChatById(chatId);
    }
}
