/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package greendock;

import greendock.data.emissionCalc;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */


public class GreenDock {
    
    
    //fake data so data exists already in our app when a user opens it 
     public static void sampleData(emissionsManager manager) {
            manager.addRecord(new emissionCalc("IFSC", "Commercial", 11000, 800));//String areaName, String sector, double totalCo2, int population
            manager.addRecord(new emissionCalc("Grand canal dock", "Transport", 3200, 200));
            manager.addRecord(new emissionCalc("Spencer dock", "Mixed Use", 8000, 500));
            manager.addRecord(new emissionCalc("Point village", "Residential", 6600, 250));
            manager.addRecord(new emissionCalc("North wall", "Industrial", 8000, 300));
        }
    
    public static void main(String[] args) {
        emissionsManager manager = new emissionsManager();//craetes manager object so i can handle emmisions records
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
        manager.flagHighEmissionArea("IFSC", 10);
        System.out.println(manager.displayFlaggedAreas());

        System.out.println("\nhistory stack:");
        System.out.println(manager.displayViewedHistory());

        System.out.println("\ndelete record:");
        manager.deleteRecord("Grand Canal");
        System.out.println(manager.displayAllRecords());
    }
}


//main class where im testing the app