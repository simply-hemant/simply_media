package com.springbootsocial.controller;

import com.springbootsocial.entity.Story;
import com.springbootsocial.entity.User;
import com.springbootsocial.services.ServiceInt;
import com.springbootsocial.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
@AllArgsConstructor
public class StoryController {
    @Autowired
    private StoryService storyService;
    @Autowired
    private ServiceInt userService;

    @PostMapping
    public Story createStory(@RequestBody Story story, @RequestHeader("Authorization") String jwt){
        User reqUser = userService.getUserFromToken(jwt);
        return storyService.createStory(story,reqUser);
    }
    @GetMapping("/user/{userId}")
    public List<Story> findStoriesByUserId(@PathVariable Long userId, @RequestHeader("Authorization") String jwt){
        User reqUser = userService.getUserFromToken(jwt);
        return storyService.findStoriesByUserId(userId);
    }
}
