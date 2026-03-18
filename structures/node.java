/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.structures;
import greendock.interfaces.calculate;

/**
 * node.java
 * @author Amelia Maxwell
 *x23471092
 */

public class node {
    public calculate data;
    public node next;

    public node(calculate data) {
        this.data = data;
        this.next = null;
    }

    public calculate getData() {
        return data;
    }
    public void setData(calculate data) {
        this.data = data;
    }
    public node getNext() {
        return next;
    }
    public void setNext(node next) {
        this.next = next;
    }
    
    
}


//thsi class stores an emssion record with a node pointing to the next node so it can be used in linked strcutures like sll