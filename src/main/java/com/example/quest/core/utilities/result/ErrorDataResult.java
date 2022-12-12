package com.example.quest.core.utilities.result;

public class ErrorDataResult<T> extends DataResult{
    public ErrorDataResult(String message) {
        super(false, message, null);
    }
    ErrorDataResult(T data){
        super(false,"",data);
    }
}
