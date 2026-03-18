/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package greendock.interfaces;

import greendock.data.emissionCalc;

/**
 * manager.java
 * @author Amelia Maxwell
 *x23471092
 */

public interface manager {
    
    void addRecord(emissionCalc record);
    
    emissionCalc findRecord(String areaName);
    
    boolean updateRecord(String areaName, double totalCo2, int population, String sector);
    
    boolean deleteRecord(String areaName);
}

//this interface defines the operations needed to manage the emmision recordss