/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock;

import greendock.data.emissionCalc;
import greendock.interfaces.manager;
import greendock.structures.SLL;
import greendock.structures.ReviewQueue;
import greendock.structures.veiwedStack;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */

public class emissionsManager implements manager {
    private SLL recordList; //stores all the records
    private ReviewQueue flaggedAreas; // fifo queue for high co2 areas
    private veiwedStack viewedHistory; // a stack for the users last viewed records

    public emissionsManager() {
        recordList = new SLL();
        flaggedAreas = new ReviewQueue();
        viewedHistory = new veiwedStack();
    }
    
    

    //adds new record to the list 
    @Override
    public void addRecord(emissionCalc record) {
        recordList.add(record);
    }

    
    
    //finds a record based off its area name and adds it to our stack for recently veiwed records
    @Override
    public emissionCalc findRecord(String areaName) {
        emissionCalc record = recordList.find(areaName);
        if (record != null) {
            viewedHistory.push(record);
        }
        return record;
    }

    
    
    //updates the datas values in a record
    @Override
    public boolean updateRecord(String areaName, double totalCo2, int population, String sector) {
        emissionCalc record = recordList.find(areaName);

        if (record == null) {
            return false;
        }

        record.setTotalCo2(totalCo2);
        record.setPopulation(population);
        record.setSector(sector);
        return true;
    }

    
    //deletes record by name
    @Override
    public boolean deleteRecord(String areaName) {
        return recordList.delete(areaName);
    }

    
    
    public String displayAllRecords() {
        return recordList.displayAll();
    }
    
    
    
//adds high co2 areas to or queue based on a co2 threshold
    public void flagHighEmissionArea(String areaName, double threshold) {
        emissionCalc record = recordList.find(areaName);

        if (record != null && record.calculatePerCapita() > threshold) {
            flaggedAreas.enqueue(record);
        }
    }
    
    
    

    public String displayFlaggedAreas() {
        return flaggedAreas.displayQueue();
    }
    
    

    public String displayViewedHistory() {
        return viewedHistory.displayStack();
    }
    
    

    public emissionCalc getMostRecentViewed() {
        return viewedHistory.peek();
    }
}

//this is the implementation for the manager interface