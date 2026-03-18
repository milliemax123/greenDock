/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.structures;
import greendock.data.emissionCalc;

/**
 * node.java
 * @author Amelia Maxwell
 *x23471092
 */

public class node {
    emissionCalc data;
    node next;

    public node(emissionCalc data) {
        this.data = data;
        this.next = null;
    }
}


//thsi class stores an emssion record with a node pointing to the next node so it can be used in linked strcutures like sll