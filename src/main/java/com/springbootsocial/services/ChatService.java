package com.springbootsocial.services;

import com.springbootsocial.entity.Chat;
import com.springbootsocial.entity.User;
import com.springbootsocial.exception.ChatException;

import java.util.List;

public interface ChatService {
    Chat createChat(User reqUser, User user2);
    Chat getChatById(Long chatId) throws ChatException;
    List<Chat> getChatsByUserId(Long userId);
}
