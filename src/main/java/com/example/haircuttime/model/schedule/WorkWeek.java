package com.example.haircuttime.model.schedule;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "work_weeks")
@Embeddable
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "week_number")
    @Max(52)
    @NonNull
    private Long weekNumber;

    @ElementCollection
    @CollectionTable(name = "workweek_days", joinColumns = @JoinColumn(name = "week_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyClass(Days.class)
    @MapKeyColumn(name = "day")
    private Map<Days, WorkDay> weekAvailability = new TreeMap<>();
}
