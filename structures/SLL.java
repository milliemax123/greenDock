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
 * This is a singly linked list to store emission records
 * each node a record and a reference to the next node
 * 
 * resources that helped:
 * https://www.baeldung.com/java-custom-linked-list-implementation
 */

//this singly linke dlist will hold emission record objects, each node holds a record and a refernce to the next node
public class SLL {
    private node head;//first node in the list
    
    
    //setters and getters 
    public node getHead() {
         return head;
    }
    public void setHead(node head) {
        this.head = head;
    }
 

    public void add(calculate record) { //adds record to end of the list
        node newNode = new node(record);
        if (head == null) {//if lists empty ne node becomes the head
            head = newNode;
            return;
        }
        node current = head;//otherwise it goes through the list until the last node is found
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;//attach new node at the end 
    }

    
    
    public calculate find(String areaName) { //this finds a record via the area name 
        node current = head;
        while (current != null) { //goes through all nodes until we are at the end of the list  if it finds record returns it
            if (current.data.getAreaName().equalsIgnoreCase(areaName)) {
                return current.data;
            }
            current = current.next;
        }
        return null;//else nothing was foudn
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
    
    
    
    //collected all flagged record sin reveiw queue
    public ReviewQueue getFlaggedAreas() {
        ReviewQueue queue = new ReviewQueue();//new queue
        node current = head;//starts at first node
        while (current != null) { //traversing through until end adding any recording theat meets the flagged criteria (>15) to reveiwqueue
            if (current.data.flaggedArea()) {
                queue.enqueue(current.data);
            }
            current = current.next;
        }
        return queue;
}
}