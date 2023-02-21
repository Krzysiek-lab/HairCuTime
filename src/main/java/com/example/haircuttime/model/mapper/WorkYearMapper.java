package com.example.haircuttime.model.mapper;

import com.example.haircuttime.model.dto.workday.WorkDayDto;
import com.example.haircuttime.model.dto.workyear.CreateWorkYearDto;
import com.example.haircuttime.model.dto.workyear.WorkYearDto;
import com.example.haircuttime.model.entity.WorkDay;
import com.example.haircuttime.model.entity.WorkYear;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class WorkYearMapper {
    private final WorkDayMapper workDayMapper;

    private final BarberMapper barberMapper;

    public WorkYearMapper(@Lazy WorkDayMapper workDayMapper,@Lazy BarberMapper barberMapper) {
        this.workDayMapper = workDayMapper;
        this.barberMapper = barberMapper;
    }


    public WorkYear toEntity(WorkYearDto workYearDto) {
        return WorkYear.builder()
                .id(workYearDto.getId())
                .year(workYearDto.getYear())
                .barber(workYearDto.getBarber())
                .workDayList(getWorkDayList(workYearDto))
                .build();
    }

    private List<WorkDay> getWorkDayList(WorkYearDto workYearDto) {
        return workYearDto.getWorkDayList()
                .stream()
                .map(workDayMapper::toEntity)
                .collect(Collectors.toList());
    }

    public WorkYearDto toDto(WorkYear workYear) {
        return WorkYearDto.builder()
                .id(workYear.getId())
                .year(workYear.getYear())
                .barber(workYear.getBarber())
                .workDayList(getWorkDayListDto(workYear))
                .build();
    }
    public WorkYear toNewEntity(CreateWorkYearDto createWorkYearDto) {
        return WorkYear.builder()
                .year(createWorkYearDto.getYear())
                .build();
    }

    private List<WorkDayDto> getWorkDayListDto(WorkYear workYear) {
     return workYear.getWorkDayList()
             .stream()
             .map(workDayMapper::toDto)
             .collect(Collectors.toList());
     }
}
