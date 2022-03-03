
package supermarket;

import eventsim.*;

import java.util.LinkedList;
import java.util.Queue;

public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 1;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    Queue<Customer> checkoutQueue = new LinkedList<>();
    int localTime = 0;


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
    }

    public void addToQueue(Customer c){
        checkoutQueue.add(c);
    }

    public void setLocalTime(int localTime) {
        this.localTime = localTime;
    }

    public int getLocalTime() {
        return localTime;
    }

    public Queue<Customer> getCheckoutQueue() {
        return checkoutQueue;
    }
}
