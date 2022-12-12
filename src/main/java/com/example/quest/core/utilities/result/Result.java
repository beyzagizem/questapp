package com.example.quest.core.utilities.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private boolean success;
    private String message;

    Result (boolean success, String message){
        this.success=success;
        this.message=message;
    }
}
