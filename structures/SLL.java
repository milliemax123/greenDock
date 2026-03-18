/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//STORES ALL RECORDS


package greendock.structures;
import greendock.interfaces.calculate;
/**
 * SLL.java
 * @author Amelia Maxwell
 *x23471092
 */

//this singly linke dlist will hold emission record objects, each node holds a record and a refernce to the next node
public class SLL {
    private node head;//first node in the lists 
    
    public node getHead() {
         return head;
    }
    public void setHead(node head) {
        this.head = head;
    }
 

    public void add(calculate record) { //adds record to end of the list
        node newNode = new node(record);
        if (head == null) {
            head = newNode;
            return;
        }
        node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    
    
    public calculate find(String areaName) { //this finds a record via the area name 
        node current = head;
        while (current != null) {
            if (current.data.getAreaName().equalsIgnoreCase(areaName)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    
    
    

    public boolean delete(String areaName) { //deletes via area name 
        if (head == null) return false;
        if (head.data.getAreaName().equalsIgnoreCase(areaName)) { //incase we are deleting head 
            head = head.next;
            return true;
        }
         //if the next node matches the one we want to dleet then its removed
        node current = head;
        while (current.next != null) {
            if (current.next.data.getAreaName().equalsIgnoreCase(areaName)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
    
    
    public String displayAll() {//displays all the records as a string
        if (head == null) return "no records";//if its empty 
        StringBuilder sb = new StringBuilder();
        node current = head;
        while (current != null) {//traverses and appends each record
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
    
    
    public ReviewQueue getFlaggedAreas() {
        ReviewQueue queue = new ReviewQueue();
        node current = head;
        while (current != null) {
            if (current.data.flaggedArea()) {
                queue.enqueue(current.data);
            }
            current = current.next;
        }
        return queue;
}
}