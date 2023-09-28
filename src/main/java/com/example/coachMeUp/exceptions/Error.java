package com.example.coachMeUp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
