package com.example.haircuttime.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessages {
    //BLEDY OTOGRAFICZNE
    EMAIL_IS_ALREADY_EXIST("Given email already exist"),

    LOGIN_IS_ALREADY_EXIST("Given login already exist");

    private final String message;

}
