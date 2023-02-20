package com.example.haircuttime.service.comment;

import com.example.haircuttime.model.dto.comment.CommentDto;
import com.example.haircuttime.model.mapper.CommentMapper;
import com.example.haircuttime.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    @Override
    public List<CommentDto> getComments() {
        return commentRepository.findAll().stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return commentMapper.toDto(commentRepository.save(commentMapper.toNewEntity(commentDto)));
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto) {
        return commentRepository.findById(commentDto.getId())
                .map(comment -> {
                    comment.setContent(comment.getContent());
                    comment.setGrade(comment.getGrade());
                    return commentMapper.toDto(comment);
                }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
