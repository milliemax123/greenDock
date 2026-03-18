/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.interfaces.inheritance;
import greendock.interfaces.calculate;



/**
 * this class is for emissions record o specific areas not individual users
 * emissionCalc.java
 * @author Amelia Maxwell
 *x23471092
 * this class extends emissionRecords and inherits totalco2 and emissionSummary() and EmissionCategory()
 * 
 */

public class emissionCalc extends emissionRecords implements calculate{
    
    private String areaName;
    private String sector;
    private int population;
    
    
    

    public emissionCalc(double totalCo2, String areaName, String sector, int population) {//
        super(totalCo2); //passes totalco2 to parent class
        this.areaName = areaName;
        this.sector = sector;
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
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    
    
//co2 per person 
@Override
    public double calculatePerCapita() { //returns emissions per person in areas by getting the average
        if (population <= 0) {
            return 0;//error handling if population is 0 or less we cant divide with that 
        }
        return  totalCo2 / population;
    }
    
    
   
    
    @Override
     public  String emissionDensity(){//gives areas a level on how good or bad their emissions are
         double perPerson = calculatePerCapita();
         if(perPerson <=5){
             return "low";
        }else if(perPerson<=10){
            return"average";
        }else{
            return "high";
         }
      }
    
      @Override
    public boolean flaggedArea(){//this checks if an area should be flagged if emissions are unuasually high
        double perPerson = calculatePerCapita();
        if(perPerson<=15){ //using 15 tonne as its far enough from 10 to need explanation 
            return false;
        }else{
            return true;
        }
    }
    

    
    //this returns a record in a formatted string so its easier to read used in gui 
    @Override
    public String toString() {
        return "area: " + areaName
                + ", sector: " + sector
                + ", total tonnes of CO2: " + totalCo2
                + ", population: " + population
                + ", CO2 per person: " + String.format("%.2f", calculatePerCapita());
    }
    
    
        //from emissionRecords
         @Override //this method is form our parent class
        public String getEmissionSummary() {
            return super.getEmissionSummary() + ", Area Name: " + areaName;
         }
}
//this makes emission record for specific areas and stores co2 data
//and calculates the co2 emissions per cpaita in each area