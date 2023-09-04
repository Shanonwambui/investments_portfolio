package com.example.portfolio5.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import com.example.portfolio5.entities.*;
public class AppSummary implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Boolean isActive;

    public AppSummary(){

    }
    public UUID getId(){
        return id;
    }
    public void setId(UUID id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public  void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public Boolean getIsActive(){
        return isActive;
    }
    public void setIsActive(Boolean isActive){
        this.isActive=isActive;
    }







}
