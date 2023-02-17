package com.example.haircuttime.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "work_years")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkYear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private Long year;
    @ManyToOne
    @JsonBackReference
    private Barber barber;


//    @Column(name = "barber_id")
   /* @ManyToOne
    @JsonBackReference
    private Barber barberId;*/

    @OneToMany(mappedBy = "workYear", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<WorkDay> workDayList;

    /*public Barber getBarberId() {
        return barberId;
    }*/


}
