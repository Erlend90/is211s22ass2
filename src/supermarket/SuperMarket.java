/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static void main(String[] args) {
        SuperMarket superm = new SuperMarket();
        superm.startSim();
    }

    public static int NUM_CHECKOUTS = 3;
    public static int NUM_CUSTOMERS = 1000;

    static Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i);
        customers = new ArrayList<>();
        init = new ArrayList<Event>();
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer c = new Customer(this, i);
            init.add(new BeginShoppingEvent(c));
            customers.add(c);
        }
    }

    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
        int totalQueueTime = 0;
        int avgTimeQueuing = 0;
        int maxQueueDuration = 0;
        int totalQueueSize = 0;
        int avgQueueSize = 0;
        int longestQueueSize = 0;
        int totalNumProd = 0;
        int avgNumProd = 0;
        Customer longestQueueCustomer = null;
        Customer maxQueueDurationCustomer = null;

        for(Customer c:customers){
                    totalQueueTime += c.queueWaitDuration;
                    totalQueueSize += c.chosenCheckoutQueue;
                    totalNumProd += c.numProducts;
                }
        avgTimeQueuing = totalQueueTime/customers.size();
        avgQueueSize = totalQueueSize/customers.size();
        avgNumProd = totalNumProd/customers.size();

        for(Customer c:customers){
            if(c.queueWaitDuration>maxQueueDuration){
                maxQueueDurationCustomer = c;
                maxQueueDuration = c.queueWaitDuration;
            }
            if(c.longestCheckoutQueue>longestQueueSize){
                longestQueueCustomer = c;
                longestQueueSize = c.longestCheckoutQueue;
            }
        }

        System.out.println("Avg queue time = " + avgTimeQueuing + " (about " + avgTimeQueuing/60 + " minutes)");
        //System.out.println("Avg queue size = " + avgQueueSize);

        if(maxQueueDurationCustomer == null){
            System.out.println("No max queue time, as there were no queues.");
        }
        else {
            System.out.println("Max time queuing = " + maxQueueDuration + " (about " + maxQueueDuration / 60 + " minutes), customer = " + maxQueueDurationCustomer.name);
            }

      /*  if(longestQueueCustomer == null){
            System.out.println("No max queue length, as there were no queues.");
        }
        else {
            System.out.println("Longest queue encountered = " + longestQueueSize + ", encountered by " + longestQueueCustomer);
        }*/

        System.out.println("Total number of products sold = " + totalNumProd + ", average number per customer = " + avgNumProd);
    }

    public static Checkout[] getCheckouts(){
        return checkouts;
    }
}
