/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.interfaces;

import greendock.interfaces.inheritance.emissionCalc;
import greendock.structures.node;
import greendock.structures.SLL;
import greendock.structures.ReviewQueue;
import greendock.structures.veiwedStack;

/**
 * emissionManager.java
 * @author Amelia Maxwell
 *x23471092
 * this class implements the manager interface and does the logic for all the needed operations for the application (not the personal claculator tho )
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

    //SETTERS AND GETTERS 
    public SLL getRecordList() {
        return recordList;
    }
    public void setRecordList(SLL recordList) {
        this.recordList = recordList;
    }
    public ReviewQueue getFlaggedAreas() {
        return flaggedAreas;
    }
    public void setFlaggedAreas(ReviewQueue flaggedAreas) {
        this.flaggedAreas = flaggedAreas;
    }
    public veiwedStack getViewedHistory() {
        return viewedHistory;
    }
    public void setViewedHistory(veiwedStack viewedHistory) {
        this.viewedHistory = viewedHistory;
    }

    
    
    
    @Override
    public void addRecord(calculate record) {//adds record to the linke dlist
        recordList.add(record);
    }

    
    
    @Override
    public calculate  findRecord(String areaName) {//seraches for record in linke dlist using area name
        calculate found = recordList.find(areaName);
        if (found == null) {
            return null;//null if theres no match
        }
        emissionCalc record = (emissionCalc) found;//casts to emission calc so we can add it to the recently veiwed stack 
        viewedHistory.push(record);
        return record;//returns found record
    }

    
    
    @Override
    public boolean updateRecord(String areaName, double totalCo2, int population, String sector) {
        calculate found = recordList.find(areaName);//searche by area name
        if (found == null) {
            return false;//error hadnling 
        }
        emissionCalc record = (emissionCalc) found;//casted to emissioncalc so setters can be used
        record.setTotalCo2(totalCo2);//setting the recordd new values
        record.setPopulation(population);
        record.setSector(sector);
        return true;
    }

    
    
    @Override
    public boolean deleteRecord(String areaName) {
        return recordList.delete(areaName);//deltes by name
    }

    
    //traverses all record and collects the one that the flaggedarea() method says are flagged
    @Override
    public void collectFlaggedAreas() {
        flaggedAreas = new ReviewQueue();//creates a fresh queue
        node current = recordList.getHead();//starts at the 1st

        while (current != null) {//goes through every nod etill we reach the end
            calculate record = current.data;
            if (record.flaggedArea()) {//and if any of thos erecords are flagge dthey are added to the queue
                flaggedAreas.enqueue(record);
            }
            current = current.next;
        }
    }

   //displays records
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