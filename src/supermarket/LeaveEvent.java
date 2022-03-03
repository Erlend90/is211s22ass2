/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class LeaveEvent extends Event {
    Customer customer;


    public LeaveEvent(Customer customer) {
        super(customer.leaveTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        return null;
    }


    @Override
    public String toString() {
        return "EndShoppingEvent {Time = " + getTime() + ", customer = " + customer.name + '}';
    }
}
