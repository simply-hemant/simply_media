package com.springbootsocial.services;

import com.springbootsocial.entity.Reels;
import com.springbootsocial.entity.User;

import java.util.List;

public interface ReelsService {
    Reels createReel(Reels reels, User user);
    List<Reels> findAllReels();
    List<Reels> findReelsByUserId(Long userId);
}
