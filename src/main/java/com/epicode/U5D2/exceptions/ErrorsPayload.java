package com.epicode.U5D2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorsPayload {
    private String message;
    private String timestamp;
}
