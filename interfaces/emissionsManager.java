/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.interfaces;

import greendock.interfaces.inheritance.emissionCalc;
import greendock.interfaces.manager;
import greendock.structures.node;
import greendock.interfaces.calculate;
import greendock.interfaces.calculate;
import greendock.interfaces.manager;
import greendock.structures.SLL;
import greendock.structures.ReviewQueue;
import greendock.structures.veiwedStack;

/**
 * emissionManager.java
 * @author Amelia Maxwell
 *x23471092
 */

public class emissionsManager implements manager {
    private SLL recordList;
    private ReviewQueue flaggedAreas;
    private veiwedStack viewedHistory;

    public emissionsManager() {
        recordList = new SLL();
        flaggedAreas = new ReviewQueue();
        viewedHistory = new veiwedStack();
    }

    
    
    
    @Override
    public void addRecord(calculate record) {
        recordList.add(record);
    }

    
    
    @Override
    public calculate  findRecord(String areaName) {
        calculate found = recordList.find(areaName);
        if (found == null) {
            return null;
        }
        emissionCalc record = (emissionCalc) found;
        viewedHistory.push(record);
        return record;
    }

    
    
    @Override
    public boolean updateRecord(String areaName, double totalCo2, int population, String sector) {
        calculate found = recordList.find(areaName);
        if (found == null) {
            return false;
        }
        emissionCalc record = (emissionCalc) found;
        record.setTotalCo2(totalCo2);
        record.setPopulation(population);
        record.setSector(sector);
        return true;
    }

    
    
    @Override
    public boolean deleteRecord(String areaName) {
        return recordList.delete(areaName);
    }

    
    
    
    public void collectFlaggedAreas() {
        flaggedAreas = new ReviewQueue();
        node current = recordList.getHead();

        while (current != null) {
            calculate record = current.data;
            if (record.flaggedArea()) {
                flaggedAreas.enqueue(record);
            }
            current = current.next;
        }
    }

    @Override
    public String displayFlaggedAreas() {
        return recordList.getFlaggedAreas().displayQueue();
    }
    @Override
    public String displayViewedHistory() {
        return viewedHistory.displayStack();
    }
    @Override
     public String displayAllRecords() {
        return recordList.displayAll();
    }
     @Override
    public calculate getMostRecentViewed() {
        return viewedHistory.peek();
    }
}