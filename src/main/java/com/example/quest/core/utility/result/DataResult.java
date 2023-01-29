package com.example.quest.core.utility.result;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class DataResult<T> extends Result{
    private T data;

    public DataResult(boolean success, T data, String message) {
        super(success, message);
        this.data = data;
    }
    public DataResult(boolean success,  T data) {
        super(success, "");
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}