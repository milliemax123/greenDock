/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package greendock;

import greendock.data.emissionRecords;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */


public class GreenDock {
    public static void main(String[] args) {
        emissionsManager manager = new emissionsManager();//craetes manager object so i can handle emmisions records

        
        //sample records
        emissionRecords r1 = new emissionRecords("Grand Canal", "Transport", 5000, 200);
        emissionRecords r2 = new emissionRecords("IFSC", "Commercial", 12000, 800);
        emissionRecords r3 = new emissionRecords("Docklands South", "Residential", 7000, 300);

        
        //adding the samples to the apps sll list 
        manager.addRecord(r1);
        manager.addRecord(r2);
        manager.addRecord(r3);

        
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