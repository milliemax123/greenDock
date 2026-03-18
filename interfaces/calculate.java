/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package greendock.interfaces;

/**
 * .java
 * @author Amelia Maxwell
 *x23471092
 */

public interface calculate {
    
    double calculatePerCapita();
    
    String emissionDensity();
    
    boolean flaggedArea();
   
    String getAreaName();
    
    @Override
    String toString();
}

//this interface defines all calculations our app will use such as the average per capita in each area and also the reslts from an indiviuals calcu;ator score