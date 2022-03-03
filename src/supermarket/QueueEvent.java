package supermarket;

import eventsim.*;

public class QueueEvent extends Event {
    Customer customer;
    Checkout[] checkouts = SuperMarket.getCheckouts();
    Checkout checkout = checkouts[0];

    public QueueEvent(Customer customer) {
        super(customer.queueTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        customer.checkoutDuration = customer.numProducts * Checkout.PROD_DURATION + Checkout.PAY_DURATION;
        checkout.addToQueue(customer);
        return new CheckoutEvent(customer, checkout);
    }

    @Override
    public String toString() {
        return "QueueEvent {Joined queue = " + getTime() + ", customer = " + customer.name
                 + '}';
    }
}
