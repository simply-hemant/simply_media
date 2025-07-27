package com.springbootsocial.controller;

import com.springbootsocial.entity.Reels;
import com.springbootsocial.entity.User;
import com.springbootsocial.services.ReelsService;
import com.springbootsocial.services.ServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reels")
@AllArgsConstructor
public class ReelsController {
    @Autowired
    private ReelsService reelsService;
    @Autowired
    private ServiceInt userService;

    @PostMapping()
    public Reels createReels(@RequestHeader("Authorization") String jwt, @RequestBody Reels reels) {
        User reqUser = userService.getUserFromToken(jwt);
        return reelsService.createReel(reels, reqUser);
    }
    @GetMapping()
    public List<Reels> getAllReels() {
        return reelsService.findAllReels();
    }
    @GetMapping("/user/{userId}")
    public List<Reels> getUserReels(@PathVariable("userId") Long userId) {
        return reelsService.findReelsByUserId(userId);
    }
}
