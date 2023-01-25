package com.example.haircuttime.model.entity;

import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table (name = "work_years")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long year;

    @Column(name = "barber_id")
    private Long barberId;

    @ElementCollection
    @CollectionTable(name = "workyear_weeks", joinColumns = @JoinColumn(name = "work_year_id"))
    private Map<Integer, WorkWeek> yearSchedule= new TreeMap<>();

}
