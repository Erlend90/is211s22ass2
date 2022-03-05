
package supermarket;

import java.util.LinkedList;
import java.util.Queue;

public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 30;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;
    Queue<Customer> checkoutQueue = new LinkedList<>();
    int nextAvailTime = 0;


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
    }

    public void addToQueue(Customer c){
        checkoutQueue.add(c);
    }

    public void setNextAvailTime(int nextAvailTime) {
        this.nextAvailTime = nextAvailTime;
    }

    public int getNextAvailTime() {
        return nextAvailTime;
    }

    public Queue<Customer> getCheckoutQueue() {
        return checkoutQueue;
    }
}
