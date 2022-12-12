package com.example.quest.core.utilities.result;

public class ErrorResult extends Result{
    ErrorResult(String message){
       super(false,message);
   }
    ErrorResult(){
        super(false,"");
    }
}
