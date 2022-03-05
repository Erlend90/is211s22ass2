package supermarket;

import eventsim.*;

public class CheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public CheckoutEvent(Checkout checkout, Customer customer) {
        super(customer.checkoutTime);
        this.checkout = checkout;
        this.customer = customer;
        checkout.checkoutQueue.poll();
    }

    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return new LeaveEvent(customer);
    }

    @Override
    public String toString() {
        return "CheckoutEvent {Time = " + getTime() + ", customer = " + customer.name
                + ", queue wait = " + customer.queueWaitDuration + ", checkout duration = " + customer.checkoutDuration + '}';
    }
}
