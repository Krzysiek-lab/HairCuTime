package com.example.haircuttime.controller;

import com.example.haircuttime.EventHandler.AbsenceRepositoryEventHandler;
import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.model.mapper.AbsenceMapper;
import com.example.haircuttime.repository.AbsenceRepository;
import com.example.haircuttime.service.absence.AbsenceServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class AbsenceController {

    private final AbsenceServiceImpl absenceService;
    private final AbsenceRepository absenceRepository;
    private final AbsenceRepositoryEventHandler absenceRepositoryEventHandler;

    private final AbsenceMapper absenceMapper;


    @GetMapping("/absences")
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @GetMapping("/absencesById")
    public AbsenceDto getAbsencesById(@RequestParam Long id) {
        return absenceService.getAbsenceById(id);
    }

    @GetMapping("/absencesByBarber")
    public List<AbsenceDto> getAbsencesByBarber(@RequestParam Long id) {
        return absenceService.getAbsenceByBarber(id);
    }


    @GetMapping("/absencesByWorkDay")
    public List<AbsenceDto> getAbsencesByWorkDay(@RequestParam Long id) {
        return absenceService.getAbsenceByWorkDay(id);
    }

    @PostMapping("/absence")
    public AbsenceDto createAbsence(@RequestBody @Valid CreateAbsenceDto absenceDto) {
        absenceRepositoryEventHandler.handleAbsenceBeforeCreate(absenceMapper.toNewEntity(absenceDto));
        return absenceService.addAbsence(absenceDto);
    }


    @PutMapping("/update/absence/{id}")
    public ResponseEntity<String> updateAbsence(@PathVariable("id") long id, @RequestBody @Valid AbsenceDto absence) {
        absenceService.updateAbsence(id, absence);
        return new ResponseEntity<>("Absence was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/delete/absence/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable("id") long id) {
        absenceRepositoryEventHandler.handleAbsenceBeforeDelete(absenceRepository.getReferenceById(id));
        absenceService.removeAbsence(id);
        return new ResponseEntity<>("Absence was deleted.", HttpStatus.OK);
    }
}
