package com.springbootsocial.controller;

import com.springbootsocial.entity.Comment;
import com.springbootsocial.entity.User;
import com.springbootsocial.services.CommentServices;
import com.springbootsocial.services.ServiceInt;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentServices commentServices;
    @Autowired
    private ServiceInt userService;

    @PostMapping("post/{postId}")
    public Comment createComment(@RequestBody Comment comment, @RequestHeader("Authorization") String jwt, @PathVariable("postId") Long postId) throws Exception {
        User user = userService.getUserFromToken(jwt);
        return commentServices.createComment(comment, postId, user.getId());
    }

    @PutMapping("like/{commentId}")
    public Comment likeComment(@RequestHeader("Authorization") String jwt, @PathVariable("commentId") Long commentId) throws Exception {
        User user = userService.getUserFromToken(jwt);
        return commentServices.likeComment(commentId, user.getId());
    }
}
