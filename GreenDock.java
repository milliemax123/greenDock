/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package greendock;

import greendock.interfaces.manager;
import greendock.interfaces.emissionsManager;
import greendock.interfaces.inheritance.emissionCalc;

/**
 * GreenDock.java
 * @author Amelia Maxwell
 *x23471092
 */


public class GreenDock {
    
    
    //fake data so data exists already in our app when a user opens it 
     public static void sampleData(manager manager) {
           manager.addRecord(new emissionCalc(13600, "IFSC", "Commercial", 800));
           manager.addRecord(new emissionCalc(3200, "Grand canal dock", "Transport", 200));
           manager.addRecord(new emissionCalc(7000, "Spencer dock", "Mixed Use", 500));
           manager.addRecord(new emissionCalc(2250, "Point village", "Residential", 250));
           manager.addRecord(new emissionCalc(4200, "North wall", "Industrial", 300));
        }
    
    public static void main(String[] args) {
        manager manager = new emissionsManager();//craetes manager object so i can handle emmisions records
        sampleData(manager);//loads the smaple data into the main method 
        new GUI().setVisible(true);//opens my gui 
        
        //used this for testing outputs in the console before gui 
        System.out.println("\nall records:");
        System.out.println(manager.displayAllRecords());
        System.out.println("\nfind record:");
        System.out.println(manager.findRecord("IFSC"));
        System.out.println("\nupdate record:");
        manager.updateRecord("IFSC", 15000, 850, "Commercial");
        System.out.println(manager.findRecord("IFSC"));
        System.out.println("\nhigh emmisions areas:");
        System.out.println(manager.displayFlaggedAreas());
        System.out.println("\nhistory stack:");
        System.out.println(manager.displayViewedHistory());
        System.out.println("\ndelete record:");
        manager.deleteRecord("Grand canal dock");
        System.out.println(manager.displayAllRecords());
    }
}


//main class where im testing the app