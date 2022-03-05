/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.*;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 100;
    public static final int MIN_PRODUCTS = 0;

    // customer will spend random amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 60*60; //1 hr
    public static final int MIN_SHOP_TIME = 1*60; //1 min

    SuperMarket shop;
    String name;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int queueTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;
    int longestCheckoutQueue;
    int chosenCheckoutQueue;


    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        beginShoppingTime = EventSim.nextInt(0, 16*60*60); // 16 hrs, 7:00-23:00
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        queueTime = beginShoppingTime + shoppingDuration;
    }
}
