package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkYear;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class WorkYearMapper {

    private final WorkDayMapper workDayMapper;

    public WorkYear toEntity(WorkYearDto workYearDto) {
        return WorkYear.builder()
                .id(workYearDto.getId())
                .year(workYearDto.getYear())
                .workDayList(getWorkDayList(workYearDto))
                .build();
    }

    private List<WorkDay> getWorkDayList(WorkYearDto workYearDto) {
        return workYearDto.getWorkDayList().stream().map(workDayMapper::toEntity).collect(Collectors.toList());
    }

    public WorkYearDto toDto(WorkYear workYear) {
        return WorkYearDto.builder()
                .id(workYear.getId())
                .year(workYear.getYear())
                .workDayList(getWorkDayDtoList(workYear.getWorkDayList()))
                .build();
    }

    private List<WorkDayDto> getWorkDayDtoList(List<WorkDay> workDays) {
        return workDays.stream().map(workDayMapper::toDto).collect(Collectors.toList());
    }

    public WorkYear toNewEntity(CreateWorkYearDto createWorkYearDto) {
        return WorkYear.builder()
                .year(createWorkYearDto.getYear())
                //.workDayList(createWorkYearDto.getWorkDayList()) //TUUUUUUUU
                .build();
    }

//    private List<WorkDay> getWorkDayList(CreateWorkYearDto createWorkYearDto) {
//     return createWorkYearDto.getWorkDayList().stream().map(workDayMapper::toEntity).collect(Collectors.toList());
//     }

}
