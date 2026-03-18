/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package greendock.personalEmissions;
import greendock.personalEmissions.personalEmissions;

import java.io.File; // this is here so we can mimic a disk file 
import java.io.FileInputStream;//reads from file
import java.io.FileOutputStream;//writes to file
import java.io.IOException;//daels with read and write errors
import java.io.ObjectInputStream;//reads our task array list objects from file ie deserializes
import java.io.ObjectOutputStream;//writes our task array list objects to file ie serializes
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * fileHandler.java
 * @author Amelia Maxwell
 *x23471092
 

public class fileHandler implements{

    private String filePath;

    public fileTaskRepository(String filePath) {
        this.filePath = filePath;
    }


                // METHODS__________________________________________________________
                    public void saveTask(Task task) {
                ArrayList<Task> tasks = findAll(); // read what is already in the file
                tasks.add(task);                   // add the new task

                ObjectOutputStream out = null;// i delacred my stream here so try and finaly can use it 

                /*
                try catch and finally are used in these methods to deal with errors 
                
                try {
                    out = new ObjectOutputStream(new FileOutputStream(filePath));//creates stream so we can write into file
                    out.writeObject(tasks); // write updated list back into file
                    JOptionPane.showMessageDialog(null, "Thy task saved and treasured. (saved to file)");//shows user the task was saved 
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Saving thee burden has failed us. (error saving to file)");
                } finally {
                    try {
                        if (out != null) { 
                            out.close();//closes the stream after we used it
                        }
                    } catch (IOException e) {//runs if something goes wrong closing file
                        JOptionPane.showMessageDialog(null, "An error befell upon us whilst thy file closed. (error closing file)");//shows an error  if the file wont close
                    }
                }
            }

                //_____________________________________________________________    
                    // this method doenst need Object Input/output  Stream as it uses the findAll method
                    public void deleteTask(int id) {
                ArrayList<Task> tasks = findAll();//reads all tasks from array list
                // this will be empty until we find the task but we create it here so our next statements can run
                Task toRemove = null;

                // this will find the task with the same id number
                for (Task t : tasks) {//loops through all the tasks
                    if (t.getId() == id) {//checks for same id
                        toRemove = t; //stores that  t task to be deleted
                        break;
                    }
                }

                if (toRemove == null) {
                    JOptionPane.showMessageDialog(null, "No burden to be found");
                    return;//stops the method
                }

                tasks.remove(toRemove);//using the remove function to delete the selected task

                ObjectOutputStream out = null;//new stream for updated list

                try {
                    out = new ObjectOutputStream(new FileOutputStream(filePath));
                    out.writeObject(tasks); // write updated list
                    JOptionPane.showMessageDialog(null, "Smite Thy Task! (Task deleted)");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "An error befell upon up whilst smiting thy task! (error deleting task)");
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error whilst closing thy file");
                    }
                }
            }

               //____________________________________________________________     
                    public Task findById(int id) { //https://www.w3schools.com/java/java_arrays_reallife.asp
                ArrayList<Task> tasks = findAll();

                for (Task t : tasks) {
                    if (t.getId() == id) {
                        return t; // found the task
                    }
                }

                return null; // task wasnt found
            }

                    //_____________________________________________________________
                    public ArrayList<Task> findAll() {
                ArrayList<Task> tasks = new ArrayList<>();
                ObjectInputStream in = null; //its in because it reads from file not write to file

                File file = new File(filePath);//this creates a file object so we can check if the file even exists first

                if (!file.exists()) {
                    return tasks; //closes method as nothing exists
                }

                try {
                    in = new ObjectInputStream(new FileInputStream(filePath));
                    tasks = (ArrayList<Task>) in.readObject(); //read ie deserialise the task arraylist from the file
                } catch (IOException | ClassNotFoundException e) {//shows error if file cant be accessed
                    JOptionPane.showMessageDialog(null, "Error reading thy files");
                } finally {//runs no matter what
                    try {
                        if (in != null) {// if stream is not empty we close it to avo
                            in.close();
                        }
                    } catch (IOException e) {//else we print this error
                        JOptionPane.showMessageDialog(null, "Error closing thy file");
                    }
                }

                return tasks;
            }

                    //______________________________________________________________
                    public void updateTask(Task updated) {
                ArrayList<Task> tasks = findAll();

                // find matching task and replace it
                for (int i = 0; i < tasks.size(); i++) {//loops through tasks
                    if (tasks.get(i).getId() == updated.getId()) {//matches task we are trying to find with id
                        tasks.set(i, updated);//replaces the task with the matching i position in the array with the new task
                        break;//stops the loop when task is updated
                    }
                }

                ObjectOutputStream out = null;

                try {
                    out = new ObjectOutputStream(new FileOutputStream(filePath));
                    out.writeObject(tasks); // write updated list
                    JOptionPane.showMessageDialog(null, "Task updated");
                } catch (IOException e) {//gives an error message if update couldnt be done like if we dont have writing permission
                    JOptionPane.showMessageDialog(null, "Error updating task");
                } finally {
                    try {
                        if (out != null) {
                            out.close();//closes our stream 
                        }
                    } catch (IOException e) {//error message when it cant be closed
                        JOptionPane.showMessageDialog(null, "Error closing file");
                    }
                }
            }



}
 /*
SOURCES THAT HELPED ME 
Frances sheridans videos were my main source but i used these for some particular confusions 

https://www.baeldung.com/spring-data-repositories
--- showed me how to make a repository store data and uses an interface for crud (read create update and dlete) operations
https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/#:~:text=In%20Java%2C%20ArrayList%20class%20is,to%20deserialize%20an%20arraylist%20object.
---showed me how to serialize an arraylist not just objects
https://www.baeldung.com/java-dao-vs-repository --- "“repository is a mechanism for encapsulating storage, retrieval, and search behavior, which emulates a collection of objects."-from the article
this is one of the things i read thar helped me choose a repository pattern, (separating data storage from gui, allows easier changeswithout harming the entire application, )
*/