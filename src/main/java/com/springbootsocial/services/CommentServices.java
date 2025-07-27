package com.springbootsocial.services;

import com.springbootsocial.entity.Comment;

public interface CommentServices {
    Comment createComment(Comment comment, Long postId, Long userId) throws Exception;
    Comment likeComment(Long commentId, Long userId) throws Exception;
    Comment findCommentById(Long commentId) throws Exception;
}
