/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package greendock.interfaces;

import greendock.interfaces.calculate;

/**
 * manager.java
 * @author Amelia Maxwell
 *x23471092
 * INTERFACE
 * this interface defines all operations that can be done on emissions record
 */ 

public interface manager {
    
    void addRecord(calculate record);
    
    calculate findRecord(String areaName);
    
    boolean updateRecord(String areaName, double totalCo2, int population, String sector);
    
    boolean deleteRecord(String areaName);
    
    void collectFlaggedAreas();
        
    String displayFlaggedAreas() ;
      
    String displayViewedHistory(); 
    
     String displayAllRecords();
             
    calculate getMostRecentViewed();
    
}

