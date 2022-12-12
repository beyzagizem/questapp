package com.example.quest.core.utilities.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResult extends Result {
    public SuccessResult(String message){
        super(true,message);
    }
    SuccessResult(){
        super(true,"");
    }
}
