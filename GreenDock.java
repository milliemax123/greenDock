/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package greendock;

import greendock.interfaces.manager;
import greendock.interfaces.emissionsManager;
import greendock.interfaces.calculate;
import greendock.interfaces.inheritance.emissionCalc;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */


public class GreenDock {
    
    
    //fake data so data exists already in our app when a user opens it 
     public static void sampleData(manager manager) {
            manager.addRecord(new emissionCalc("IFSC", "Commercial", 13600, 800)); //17 pp                       //String areaName, String sector, double totalCo2, int population
            manager.addRecord(new emissionCalc("Grand canal dock", "Transport", 3200, 200));//16pp
            manager.addRecord(new emissionCalc("Spencer dock", "Mixed Use", 7000, 500));//14 pp
            manager.addRecord(new emissionCalc("Point village", "Residential", 2250, 250));//9pp
            manager.addRecord(new emissionCalc("North wall", "Industrial", 4200, 300));//14pp
        }
    
    public static void main(String[] args) {
        manager manager = new emissionsManager();//craetes manager object so i can handle emmisions records
        sampleData(manager);//loads the smaple data into the main method 

        
        //no gui yet so using this
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
        manager.deleteRecord("Grand Canal");
        System.out.println(manager.displayAllRecords());
    }
}


//main class where im testing the app