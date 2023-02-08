package com.example.haircuttime.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
@Setter
@Getter
@Table(name = "work_day")
@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class WorkDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Max(365)
    @NonNull
    @Column(name = "day_in_year")
    private Long dayInYear;

//    @Column(name = "work_year_id")
//    private Long workYearId;

    @ManyToOne
    @JsonBackReference
    private WorkYear workYear;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_definition_id", referencedColumnName = "id")
    private WorkDefinition workDefinition;
    /*@OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Availability> availabilities = new ArrayList<>();
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Absence> absences = new ArrayList<>();*/
}

