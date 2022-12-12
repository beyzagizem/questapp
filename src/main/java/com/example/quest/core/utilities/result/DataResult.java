package com.example.quest.core.utilities.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResult<T> {
    private boolean success;
    private String message;
    private T data;
    DataResult(boolean success, String message,T data){
        this.success=success;
        this.message=message;
        this.data=data;
    }
}
