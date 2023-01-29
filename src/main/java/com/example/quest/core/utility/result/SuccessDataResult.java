package com.example.quest.core.utility.result;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data,String message) {
        super(true,data, message);
    }
    public SuccessDataResult(T data){
        super(true,data,"");
    }
}