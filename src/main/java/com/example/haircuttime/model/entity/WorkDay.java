package com.example.haircuttime.model.entity;

import com.example.haircuttime.model.enums.WorkDefinition;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_day")
@Embeddable
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Max(365)
    @NonNull
    @Column(name = "day_in_year")
    private Long dayInYear;
    @ManyToOne
    @JoinColumn(name = "work_year_id")
    private WorkYear workYear;
    @Enumerated
    @NotNull
    private WorkDefinition workDefinition;

    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Availability> availabilities = new ArrayList<>();
    @OneToMany(mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Absence> absences = new ArrayList<>();

}
