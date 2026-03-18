/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.personalEmissions;
import greendock.interfaces.inheritance.personalEmissions;

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
 */

public class fileHandler{

    private String filePath;

    public fileHandler(String filePath) {
        this.filePath = filePath;
    }


//SAVING EMISSION REPORT 
         public void saveEmission(personalEmissions emission) {
                ArrayList<personalEmissions> emissions = findAll(); // read what is already in the file
                emissions.add(emission);                   // add the new emission report

                ObjectOutputStream out = null;// i delacred my stream here so try and finaly can use it 

                /*
                try catch and finally are used in these methods to deal with errors 
                */
                try {
                    out = new ObjectOutputStream(new FileOutputStream(filePath));//creates stream so we can write into file
                    out.writeObject(emissions); // write updated list back into file
                    JOptionPane.showMessageDialog(null, "emission report sucessfully saved");//shows user the report was saved 
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "error saving emission report to file");
                } finally {
                    try {
                        if (out != null) { 
                            out.close();//closes the stream after we used it
                        }
                    } catch (IOException e) {//runs if something goes wrong closing file
                        JOptionPane.showMessageDialog(null, "error closing file");//shows an error  if the file wont close
                    }
                }
            }

                    
 //FINDING ALL THE EMISSION REPORTs         
        public ArrayList<personalEmissions> findAll() {
                ArrayList<personalEmissions> emissions = new ArrayList<>();
                ObjectInputStream in = null; //its in because it reads from file not write to file

                File file = new File(filePath);//this creates a file object so we can check if the file even exists first

                if (!file.exists()) {
                    return emissions; //closes method as nothing exists
                }

                try {
                    in = new ObjectInputStream(new FileInputStream(filePath));
                    emissions = (ArrayList<personalEmissions>) in.readObject(); //read ie deserialise the task arraylist from the file
                } catch (IOException | ClassNotFoundException e) {//shows error if file cant be accessed
                    JOptionPane.showMessageDialog(null, "Error reading the emission reports form file");
                } finally {//runs no matter what
                    try {
                        if (in != null) {// if stream is not empty we close it to avo
                            in.close();
                        }
                    } catch (IOException e) {//else we print this error
                        JOptionPane.showMessageDialog(null, "Error closing the file");
                    }
                }

                return emissions;
            }



}
