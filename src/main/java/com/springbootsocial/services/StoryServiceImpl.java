package com.springbootsocial.services;

import com.springbootsocial.entity.Story;
import com.springbootsocial.entity.User;
import com.springbootsocial.repository.StoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StoryServiceImpl implements StoryService{
    @Autowired
    private StoryRepo storyRepo;

    @Autowired
    private ServiceInt userService;
    @Override
    public Story createStory(Story story, User user) {
        Story createdStory = new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setImageUrl(story.getImageUrl());
        createdStory.setUser(user);
        createdStory.setTimestamp(LocalDateTime.now());

        return storyRepo.save(createdStory);
    }

    @Override
    public List<Story> findStoriesByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return storyRepo.findByUserId(userId);
    }
}
