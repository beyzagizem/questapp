package com.example.quest.core.utility.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class SuccessResult extends Result {
    public SuccessResult(String message){
        super(true,message);
    }
    public SuccessResult(){
        super(true,"");
    }

}