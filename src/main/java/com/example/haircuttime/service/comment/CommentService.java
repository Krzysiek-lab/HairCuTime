package com.example.haircuttime.service.comment;

import com.example.haircuttime.model.dto.comment.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getComments();

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(CommentDto commentDto);

    void deleteComment(Long id);


}
