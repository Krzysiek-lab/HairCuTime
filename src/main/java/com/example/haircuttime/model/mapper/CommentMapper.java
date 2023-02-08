package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.comment.CommentDto;
import com.example.haircuttime.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    // private final ServiceMapper serviceMapper;

    public CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .grade(comment.getGrade())
                //.serviceDtos(getServices(comment.getServices()))
                .build();
    }
    /* private List<ServiceDto> getServices(List<Service> services) {
        return services.stream()
                .map(serviceMapper::toDto)
                .collect(Collectors.toList);
    }*/

    public Comment toNewEntity(CommentDto commentDto) {
        return Comment.builder()
                .content(commentDto.getContent())
                .grade(commentDto.getGrade())
                .build();
    }
}
