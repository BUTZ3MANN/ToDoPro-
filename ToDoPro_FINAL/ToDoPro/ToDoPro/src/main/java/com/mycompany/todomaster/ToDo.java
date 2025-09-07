/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todomaster;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author capta
 */
public class ToDo implements Serializable {
    private String description;
    private boolean completed;
    private Date creationDate;
    private Date completionDate;
    
    //Creates a new task with the given description
    public ToDo(String description) {
        this.description = description;
        this.completed = false;
        this.creationDate = new Date();
        this.completionDate = null;
    }
    
    //Marks the task as completed and sets the completion date
    public void markAsCompleted() {
        this.completed = true;
        this.completionDate = new Date();
    }
    
    //Marks the task as not completed
    public void markAsIncomplete() {
        this.completed = false;
        this.completionDate = null;
    }
    
    //Checks if the task is completed
    public boolean isCompleted() {
        return completed;
    }
    
    //Gets the task description
    public String getDescription() {
        return description;
    }
    
    //Sets a new description for the task
    public void setDescription(String description) {
        this.description = description;
    }
    
    //Gets the creation date of the task
    public Date getCreationDate() {
        return creationDate;
    }
    
    //Gets the completion date of the task
    public Date getCompletionDate() {
        return completionDate;
    }
    
    //Returns a formatted string representation of this task
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd | HH:mm");
        StringBuilder sb = new StringBuilder();
        
        sb.append(completed ? "[✔️]" : "[ ] ");
        sb.append(description);
        sb.append(" (Created: ").append(dateFormat.format(creationDate)).append(")");
        
        if (completed && completionDate != null) {
            sb.append(" (Completed: ").append(dateFormat.format(completionDate)).append(")");
        }
        
        return sb.toString();
    }
}
