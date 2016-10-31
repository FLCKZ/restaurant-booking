package com.example.leetoxavi.bms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by leetoxavi on 10/30/2016.
 */
public class UserOrder {

    public Map<String, String> orderedItems = new HashMap<>();
    public double orderTotalPrice;

    public UserOrder(Map<String, String> orderedItems, double orderTotalPrice){
        this.orderedItems = orderedItems;
        this.orderTotalPrice = orderTotalPrice;
    }

    public UserOrder(){

    }
}
