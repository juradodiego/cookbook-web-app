package com.fooddude.cookbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private ArrayList<Integer> savedRecipeIds;
    // TODO add friends list

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.email = email;
        this.password = password;
        this.savedRecipeIds = new ArrayList<Integer>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Integer> getSavedRecipeIds() {
        return savedRecipeIds;
    }

    public void setSavedRecipeIds(ArrayList<Integer> savedRecipeIds) {
        this.savedRecipeIds = savedRecipeIds;
    }

    public void addSavedRecipeId(Integer recipeId){
        this.savedRecipeIds.add(recipeId);
    }

} // end of User class
