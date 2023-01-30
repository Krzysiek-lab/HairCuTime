package com.example.haircuttime.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorkWeekMapper {

//    public WorkDayNew toEntity (WorkWeekDto workWeekDto) {
//        return WorkDayNew.builder()
//                .id(workWeekDto.getId())
//                .
//                .weekAvailability(getWorkDaysDtoToEntities(workWeekDto))
//                .build();
//    }
//
//    public WorkWeekDto toDto (WorkDayNew workDayNew) {
//        return WorkWeekDto.builder()
//                .id(workDayNew.getId())
//                .weekNumber(workDayNew.getDayInYear())
//                .weekAvailability(getWorkDaysEntityToDto(workDayNew))
//                .build();
//    }
//
//    public WorkDayNew toNewEntity(CreateWorkWeekDto createWorkWeekDto) {
//        return WorkDayNew.builder()
//                .weekNumber(createWorkWeekDto.getWeekNumber())
//                .weekAvailability(getWorkDaysDtoToEntities(createWorkWeekDto))
//                .build();
//    }
//    private Map<Day, WorkDay> getWorkDaysDtoToEntities(WorkWeekDto workWeekDto) {
//        return workWeekDto
//                .getWeekAvailability()
//                .entrySet()
//                .stream()
//                .map((entry) -> new AbstractMap.SimpleEntry<>
//                        (entry.getKey(), workDayMapper.toEntity(entry.getValue())))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
//
//    private Map<Day, WorkDay> getWorkDaysDtoToEntities(CreateWorkWeekDto createWorkWeekDto) {
//        return createWorkWeekDto
//                .getWeekAvailability()
//                .entrySet()
//                .stream()
//                .map((entry) -> new AbstractMap.SimpleEntry<>
//                        (entry.getKey(), workDayMapper.toEntity(entry.getValue())))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
//
//    private Map<Day, WorkDayDto> getWorkDaysEntityToDto(WorkDayNew workDayNew) {
//        return workDayNew
//                .getWeekAvailability()
//                .entrySet()
//                .stream()
//                .map((entry) -> new AbstractMap.SimpleEntry<>
//                        (entry.getKey(), workDayMapper.toDto(entry.getValue())))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//    }
}
