package supermarket;

import eventsim.*;

import java.util.Arrays;

public class QueueEvent extends Event {
    Customer customer;
    Checkout[] checkouts = SuperMarket.getCheckouts();
    Checkout checkout;

    public QueueEvent(Customer customer) {
        super(customer.queueTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        checkout = checkouts[0];
        int longestQueue = 0;
        for (Checkout c:checkouts) {
            if(c.nextAvailTime<checkout.nextAvailTime){
                checkout = c;
            }
            if(c.checkoutQueue.size()>longestQueue){
                longestQueue = c.checkoutQueue.size();
            }

        }
        customer.chosenCheckoutQueue = checkout.checkoutQueue.size();
        customer.longestCheckoutQueue = longestQueue;
        //System.out.println(longestQueue);

        System.out.println("Checkout: " + checkout.name + ", next available time: " + checkout.getNextAvailTime());
        customer.checkoutDuration = customer.numProducts * Checkout.PROD_DURATION + Checkout.PAY_DURATION;
        checkout.addToQueue(customer);
        if (checkout.getNextAvailTime()>getTime()){
            customer.checkoutTime = checkout.getNextAvailTime();
        }
        else customer.checkoutTime = getTime();

        customer.queueWaitDuration = customer.checkoutTime - customer.queueTime;
        System.out.println("Customer " + customer.name + ", queued at " + customer.queueTime + ", checkout time: " + customer.checkoutTime + ", queue wait duration: " + customer.queueWaitDuration);
        checkout.setNextAvailTime(customer.checkoutTime + customer.checkoutDuration);
        System.out.println("Checkout duration: " + customer.checkoutDuration + ", leave time: " + checkout.getNextAvailTime() +"\n");
        //System.out.println("Checkouts: " + Arrays.toString(checkouts));

        return new CheckoutEvent(checkout, customer);
    }

    @Override
    public String toString() {
        return "QueueEvent {Joined queue = " + getTime() + ", customer = " + customer.name
                  + '}';
    }
}
