package com.springbootsocial.services;

import com.springbootsocial.entity.Story;
import com.springbootsocial.entity.User;

import java.util.List;

public interface StoryService {
    Story createStory(Story story, User user);
    List<Story> findStoriesByUserId(Long userId);
}
