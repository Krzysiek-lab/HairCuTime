package com.example.haircuttime.controller;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.mapper.AbsenceMapper;
import com.example.haircuttime.repository.AbsenceRepository;
import com.example.haircuttime.service.absence.AbsenceServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("absence")
@CrossOrigin(origins = "http://localhost:3000")
public class AbsenceController {

    private final AbsenceServiceImpl absenceService;
    private final AbsenceRepository absenceRepository;
    private final AbsenceRepositoryEventHandler absenceRepositoryEventHandler;
    private final AbsenceMapper absenceMapper;


    @GetMapping("/get")
    public List<AbsenceDto> getAllAbsences() {
        return absenceRepository.findAll().stream().map(absenceMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/get/id")
    public AbsenceDto getAbsencesById(@RequestParam Long id) {
        return absenceService.getAbsenceById(id);
    }

    @GetMapping("/get/barber")
    public List<AbsenceDto> getAbsencesByBarber(@RequestParam Long id) {
        return absenceService.getAbsenceByBarber(id);
    }

    @GetMapping("/absence/get/workday")
    public List<AbsenceDto> getAbsencesByWorkDay(@RequestParam Long id) {
        return absenceService.getAbsenceByWorkDay(id);
    }

    @PostMapping("/create")
    public AbsenceDto createAbsence(@RequestBody @Valid CreateAbsenceDto absenceDto) {
        absenceMapper.getBarberAndWorkYearIds(absenceDto);//dodane
        absenceRepositoryEventHandler.handleAbsenceBeforeCreate(absenceMapper.toNewEntity(absenceDto));
        return absenceService.addAbsence(absenceDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAbsence(@PathVariable("id") long id, @RequestBody @Valid AbsenceDto absence) {
        absenceService.updateAbsence(id, absence);
        return new ResponseEntity<>("Absence was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable("id") long id) {
        absenceRepositoryEventHandler.handleAbsenceBeforeDelete(absenceRepository.getReferenceById(id));
        absenceService.removeAbsence(id);
        return new ResponseEntity<>("Absence was deleted.", HttpStatus.OK);
    }
}
