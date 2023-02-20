package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.comment.CommentDto;
import com.example.haircuttime.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/comment")

public class CommentController {

    private final CommentService commentService;

    @GetMapping("/all")
    public List<CommentDto> getComments() {
        return commentService.getComments();
    }

    @PostMapping("/add")
    public CommentDto saveComment(@RequestBody @Valid CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PutMapping("/update")
    public CommentDto updateComment(@RequestBody @Valid CommentDto commentDto) {
        return commentService.updateComment(commentDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }
}
