/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todomaster;

import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author capta
 */

/**
 * Manages a list of ToDo tasks, including adding, deleting, completing,
 * saving to file, and loading from file.
 */
public class ToDoProManager {
    //List of ToDo objects
    private ArrayList<ToDo> todos;
    
    //Model for displaying tasks in a GUI component like JList
    private DefaultListModel<String> listModel;
    
    public ToDoProManager() {
        todos = new ArrayList<>();
        listModel = new DefaultListModel<>();
    }
    
    //Adds a task to the list if the description is not empty
    public boolean addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            return false;
        }
        
        ToDo newTodo = new ToDo(description.trim());
        todos.add(newTodo);
        updateListModel(); //Update GUI list display
        return true;
    }
    
    //Marks the task at the specified index as completed
    public boolean markTaskAsCompleted(int index) {
        if (index < 0 || index >= todos.size()) {
            return false;
        }
        
        ToDo todo = todos.get(index);
        todo.markAsCompleted();
        updateListModel();
        return true;
    }
    
    //Deletes the task at the specified index
    public boolean deleteTask(int index) {
        if (index < 0 || index >= todos.size()) {
            return false;
        }
        
        todos.remove(index);
        updateListModel();
        return true;
    }
    
    //Removes all completed tasks from the list and returns how many were removed
    public int clearCompletedTasks() {
        int count = 0;
        //Iterate in reverse to avoid index issues when removing items
        for (int i = todos.size() - 1; i >= 0; i--) {
            if (todos.get(i).isCompleted()) {
                todos.remove(i);
                count++;
            }
        }
        
        if (count > 0) {
            updateListModel();
        }
        return count;
    }
    
    //Returns the list model used in the GUI
    public DefaultListModel<String> getListModel() {
        return listModel;
    }
    
    //Updates the list model based on the current state of the task list
    private void updateListModel() {
        listModel.clear();
        for (ToDo todo : todos) {
            listModel.addElement(todo.toString());
        }
    }
    
    //Saves the tasks to a file selected by the user
    public boolean saveTasksToFile(java.awt.Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save ToDos");
        
        if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            //Ensure file has the correct extension
            if (!file.getName().toLowerCase().endsWith(".todos")) {
                file = new File(file.getAbsolutePath() + ".todos");
            }
            
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(todos);
                return true;
            } catch (IOException ex) {
                //Show error message if saving fails
                JOptionPane.showMessageDialog(parent, 
                    "Error saving todos: " + ex.getMessage(), 
                    "Save Error", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    //Loads tasks from a file selected by the user
    @SuppressWarnings("unchecked")
    public boolean loadTasksFromFile(java.awt.Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load ToDos");
        
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                todos = (ArrayList<ToDo>) in.readObject();
                updateListModel();
                return true;
            } catch (IOException | ClassNotFoundException ex) {
                //Show error message if loading fails
                JOptionPane.showMessageDialog(parent, 
                    "Error loading todos: " + ex.getMessage(), 
                    "Load Error", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return false;
    }
    
    //Returns the total number of tasks
    public int getTaskCount() {
        return todos.size();
    }
    //Returns the number of completed tasks
    public int getCompletedTaskCount() {
        int count = 0;
        for (ToDo todo : todos) {
            if (todo.isCompleted()) {
                count++;
            }
        }
        return count;
    }
}
