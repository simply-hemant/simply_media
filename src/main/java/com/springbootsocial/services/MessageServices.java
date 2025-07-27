package com.springbootsocial.services;

import com.springbootsocial.entity.Message;
import com.springbootsocial.entity.User;

import java.util.List;

public interface MessageServices {
    Message createMessage(User reqUser, Long chatId, Message req) throws Exception;
    List<Message> findChatsMessages(Long chatId) throws Exception;
}
