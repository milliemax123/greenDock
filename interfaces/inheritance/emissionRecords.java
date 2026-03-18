/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.interfaces.inheritance;


/**
 * emissionsRecords.java
 * @author Amelia Maxwell
 *x23471092
 * INHERITANCE
 */

public abstract class emissionRecords {
    protected double totalCo2;

    public emissionRecords(double totalCo2){
        this.totalCo2=totalCo2;
    }
    
    //getters and setters 
    public double getTotalCo2() {
        return totalCo2;
    }
    public void setTotalCo2(double totalCo2) {
        this.totalCo2 = totalCo2;
    }
   

    public String getEmissionCategory() {
        double value = totalCo2;
        if (value < 5) return "Low";
        else if (value < 10) return "Moderate";
        else return "High";
    }
    
    public String getEmissionSummary() {
        return "CO2: " + totalCo2 + " tonnes";
}
}