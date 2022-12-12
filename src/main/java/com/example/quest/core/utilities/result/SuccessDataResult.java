package com.example.quest.core.utilities.result;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data,String message) {
        super(true, message, data);
    }
    SuccessDataResult(T data){
        super(true,"",data);
    }
}
