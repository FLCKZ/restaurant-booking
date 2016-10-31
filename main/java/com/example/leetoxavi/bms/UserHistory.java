package com.example.leetoxavi.bms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leetoxavi on 10/30/2016.
 */
public class UserHistory {

    public List<UserOrder> userOrders = new LinkedList<>();
    public List<UserBooking> userBookings = new LinkedList<>();

    public UserHistory(List<UserOrder> userOrders, List<UserBooking> userBookings){

        this.userOrders = userOrders;
        this.userBookings = userBookings;
    }
    public UserHistory(){

    }
}
