package com.example.haircuttime.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public enum WorkDefinition {
    _8__8_16    (LocalTime.of(8 ,0),LocalTime.of(8 ,0), LocalTime.of(16,0)),
    _8__9_17    (LocalTime.of(8 ,0),LocalTime.of(9 ,0), LocalTime.of(17,0)),
    _8__10_18   (LocalTime.of(8 ,0),LocalTime.of(10,0), LocalTime.of(18,0)),
    _8__11_19   (LocalTime.of(8 ,0),LocalTime.of(11,0), LocalTime.of(19,0)),
    _8__12_20   (LocalTime.of(8 ,0),LocalTime.of(12,0), LocalTime.of(20,0)),
    _9__8_17    (LocalTime.of(9 ,0),LocalTime.of(8 ,0), LocalTime.of(17,0)),
    _9__9_18    (LocalTime.of(9 ,0),LocalTime.of(9 ,0), LocalTime.of(18,0)),
    _9__10_19   (LocalTime.of(9 ,0),LocalTime.of(10,0), LocalTime.of(19,0)),
    _9__11_20   (LocalTime.of(9 ,0),LocalTime.of(11,0), LocalTime.of(20,0)),
    _10__8_18   (LocalTime.of(10,0),LocalTime.of(10,0), LocalTime.of(18,0)),
    _10__9_19   (LocalTime.of(10,0),LocalTime.of(10,0), LocalTime.of(19,0)),
    _10__10_20  (LocalTime.of(10,0),LocalTime.of(10,0), LocalTime.of(20,0)),
    _0__        (LocalTime.of(0 ,0),LocalTime.of(0,0), LocalTime.of(0,0));

    private final LocalTime dayLength;
    private final LocalTime start;
    private final LocalTime end;

    WorkDefinition(LocalTime dayLength, LocalTime start, LocalTime end) {
        this.dayLength = dayLength;
        this.start = start;
        this.end = end;
    }

    @JsonValue
    public String getName() {
        return name();
    }

}
