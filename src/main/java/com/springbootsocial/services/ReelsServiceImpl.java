package com.springbootsocial.services;

import com.springbootsocial.entity.Reels;
import com.springbootsocial.entity.User;
import com.springbootsocial.repository.ReelsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReelsServiceImpl implements ReelsService{
    @Autowired
    private ReelsRepo reelsRepo;
    @Autowired
    private ServiceInt userService;

    @Override
    public Reels createReel(Reels reels, User user) {
        Reels createdReel = new Reels();
        createdReel.setTitle(reels.getTitle());
        createdReel.setVideo(reels.getVideo());
        createdReel.setUser(user);
        return reelsRepo.save(createdReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepo.findAll();
    }

    @Override
    public List<Reels> findReelsByUserId(Long userId) {
        userService.getUserById(userId);
        return reelsRepo.findByUserId(userId);
    }
}
