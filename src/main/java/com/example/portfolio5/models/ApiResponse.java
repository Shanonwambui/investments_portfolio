package com.example.portfolio5.models;

import com.example.portfolio5.entities.User;
import java.util.List;

public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data; // Modified to hold a list of users

    public ApiResponse(Boolean success, String message){
        this.success=success;
        this.message=message;
    }
    public ApiResponse(Boolean success,String message, Object data){
        this.success=success;
        this.message=message;
        this.data=data;
    }
    public Object getData(){
        return data;
    }
    public void setData(List<User> data){
        this.data=data;
    }
    public Boolean getSuccess(){
        return success;
    }
    public void setSuccess(Boolean success){
        this.success=success;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
}
