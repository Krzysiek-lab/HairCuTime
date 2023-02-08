package com.example.haircuttime.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @JsonValue
    public String getName() {
        return name();
    }
}
