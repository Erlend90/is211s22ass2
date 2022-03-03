/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.*;


/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;


    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.queueTime = customer.beginShoppingTime + customer.shoppingDuration;
        return new QueueEvent(customer);
    }

    @Override
    public String toString() {
        return "BeginShoppingEvent {Started shopping = " + getTime() + ", customer = " + customer.name
                + ", shopping duration = " + customer.shoppingDuration + '}';
    }
}
