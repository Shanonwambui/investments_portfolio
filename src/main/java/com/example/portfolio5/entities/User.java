package com.example.portfolio5.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.UUID;
import java.util.Date;

@Entity

public class User implements Serializable {
    @Id
    private UUID id;


    private String username;
    private  String email;
    private  String password;
    private  Date timestamp;
    private UUID creator;
    private Boolean isActive;

    // Constructors

    public User(){}
    public User (String username, String email, String password){
        this.username=username;
        this.email=email;
        this.password=password;
        this.id=UUID.randomUUID(); //Generate a new UUID
        this.timestamp=new Date(); //Set the current timestamp
        this.isActive=true; //Set isActive to true by default
    }

    public UUID getId(){
        return id;
    }
   public void setId(UUID id){
        this.id=id;
   }
    public String getUsername(){

        return username;
    }
    public void setUsername(String username){

        this.username=username;
    }
    public String getEmail(){

        return email;
    }
    public void setEmail(String email){

        this.email=email;
    }
    public String getPassword(){

        return password;
    }
    public void setPassword(String password){

        this.password=password;
    }
    public Date getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(Date timestamp){
        this.timestamp=timestamp;
    }
    public Boolean getIsActive(){
        return isActive;
    }
    public void setIsActive(Boolean isActive){
        this.isActive=isActive;
    }
    public UUID getCreator(){
        return creator;
    }
    public void setCreator(UUID creator){
        this.creator=creator;
    }



}
