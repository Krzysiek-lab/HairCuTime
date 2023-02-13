package com.example.haircuttime.controller;

import com.example.haircuttime.model.dto.absence.AbsenceDto;
import com.example.haircuttime.model.dto.absence.CreateAbsenceDto;
import com.example.haircuttime.model.entity.Absence;
import com.example.haircuttime.repository.AbsenceRepository;
import com.example.haircuttime.service.absence.AbsenceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")

public class AbsenceController {

    private final AbsenceServiceImpl absenceService;
    private final AbsenceRepository absenceRepository;

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
        return absenceService.addAbsence(absenceDto);
    }


    @PutMapping("/update/absence/{id}")
    public ResponseEntity<String> updateAbsence(@PathVariable("id") long id, @RequestBody @Valid AbsenceDto absence) {
        absenceService.updateAbsence(id, absence);
        return new ResponseEntity<>("Absence was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/delete/absence/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable("id") long id) {
        absenceService.removeAbsence(id);
        return new ResponseEntity<>("Absence was deleted.", HttpStatus.OK);
    }
}