package com.example.quest.core.utility.result;

public class ErrorDataResult<T> extends DataResult{
    public ErrorDataResult(T data,String message) {

        super(false, data, message);
    }
    public ErrorDataResult(T data){
        super(false,data,"");
    }
}