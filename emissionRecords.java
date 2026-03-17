/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.data;

import greendock.interfaces.calculate;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */


public class emissionRecords implements calculate {
    private String areaName;
    private String sector;
    private double totalCo2;
    private int population;

    public emissionRecords(String areaName, String sector, double totalCo2, int population) {
        this.areaName = areaName;
        this.sector = sector;
        this.totalCo2 = totalCo2;
        this.population = population;
    }

    
    
    //getters
    public String getAreaName() {
        return areaName;
    }
    public String getSector() {
        return sector;
    }
    public double getTotalCo2() {
        return totalCo2;
    }
    public int getPopulation() {
        return population;
    }

    
    //setters
    public void setSector(String sector) {
        this.sector = sector;
    }
    public void setTotalCo2(double totalCo2) {
        this.totalCo2 = totalCo2;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    
    
//co2 per person 
    @Override
    public double calculatePerCapita() {
        if (population <= 0) {
            return 0;
        }
        return totalCo2 / population;
    }

    
    //this returns a record in a formatted string so its easier to read
    @Override
    public String toString() {
        return "area: " + areaName
                + ", sector: " + sector
                + ", total CO2: " + totalCo2
                + ", population: " + population
                + ", CO2 per person: " + String.format("%.2f", calculatePerCapita());
    }
}

//this makes emission record for specific areas and stores co2 data
//and calculates the co2 emissions per cpaita in each area