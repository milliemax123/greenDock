/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.structures;

import greendock.data.emissionRecords;

/**
 * veiwedStack.java
 * @author Amelia Maxwell
 *x23471092
 */

public class veiwedStack {
    private node top;//top of stsack

    
    //adds record to top of stacl 
    public void push(emissionRecords record) {
        node newNode = new node(record);
        newNode.next = top;
        top = newNode;
    }

    
    //removes
    public emissionRecords pop() {
        if (top == null) {
            return null;
        }

        emissionRecords removed = top.data; //stores top record in removed
        top = top.next;//makes the top the next record viewed
        return removed; //returns the removed record
    }

    
    
    //returns the first lelment but doesnt delete
    public emissionRecords peek() { 
        if (top == null) {
            return null;
        }
        return top.data;
    }
    
    
//checks if empty
    public boolean isEmpty() {
        return top == null;
    }

    
    //shows all elements in stack 
    public String displayStack() {
        if (top == null) {
            return "Viewed stack is empty.";
        }

        StringBuilder sb = new StringBuilder();
        node current = top;

        while (current != null) {//traverses through stack until null akak the last one adding eahc to the stringbuilder
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }

        return sb.toString();
    }
}

//this is a lifo stack implementation for records a users viewed