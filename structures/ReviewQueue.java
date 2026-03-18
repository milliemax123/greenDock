/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greendock.structures;

import greendock.data.emissionCalc;

/**
 *reviewQueue .java
 * @author Amelia Maxwell
 *x23471092
 */


// a fifo queue for records that need investiagting 
public class ReviewQueue {
    private node front;
    private node rear;

    
    public void enqueue(emissionCalc record) {//adds record to the end
        node newNode = new node(record);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    
    
    public emissionCalc dequeue() { //removes the first element
        if (front == null) {
            return null;
        }

        emissionCalc removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    
    
    public emissionCalc peek() {//shows us the first record in the queue but doesnt delete it
        if (front == null) {
            return null;
        }
        return front.data;
    }

    
    
    public boolean isEmpty() {//checks if the queue is empty 
        return front == null;
    }
    
    

    public String displayQueue() { //
        if (front == null) {
            return "Review queue is empty.";
        }

        StringBuilder sb = new StringBuilder();
        node current = front;

        while (current != null) {//traverse through each  node till the end
            sb.append(current.data.toString()).append("\n");//adding the current node data to the string 
            current = current.next;//move to next node
        }

        return sb.toString(); //returns the entire queues records ass a string 
    }
}
