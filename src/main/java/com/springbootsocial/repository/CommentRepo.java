package com.springbootsocial.repository;

import com.springbootsocial.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {

}
