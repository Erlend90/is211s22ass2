package supermarket;

import eventsim.*;

public class CheckoutEvent extends Event {
    Customer customer;


    public CheckoutEvent(Customer customer, Checkout checkout) {
        super(EventSim.getClock());
        this.customer = customer;
    }

    @Override
    public Event happen() {
        customer.leaveTime = customer.queueTime + customer.checkoutDuration;
        return new LeaveEvent(customer);
    }

    @Override
    public String toString() {
        return "CheckoutEvent {Time = " + getTime() + ", customer = " + customer.name
                + ", checkout duration = " + customer.checkoutDuration + '}';
    }
}
