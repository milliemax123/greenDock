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
 * this class stores nodes that each contain an emission record and reference pointing to the next node so it can be used in linked strcutures like sll
 */

public class node {
    public calculate data;//record
    public node next;//next node aka reference

    public node(calculate data) {
        this.data = data;
        this.next = null;
    }

    //SETTERS AND GETTERS
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


