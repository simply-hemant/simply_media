package com.springbootsocial.repository;

import com.springbootsocial.entity.Reels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReelsRepo extends JpaRepository<Reels, Long> {
    List<Reels> findByUserId(Long userId);
}
