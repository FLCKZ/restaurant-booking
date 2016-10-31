package com.example.leetoxavi.bms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leetoxavi on 10/30/2016.
 */
public class UserBooking {

    public String bookedTable;
    public DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public Date date = new Date();
    public String bookingDateTime;

    public UserBooking(String bookedTable){

        this.bookedTable = bookedTable;
        this.bookingDateTime = dateFormat.format(date); //2014/08/06 15:59:48
    }
}
