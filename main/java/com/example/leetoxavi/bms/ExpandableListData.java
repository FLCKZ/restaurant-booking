package com.example.leetoxavi.bms;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leetoxavi on 8/11/2016.
 */
public class ExpandableListData {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> Family = new ArrayList<String>();
        Family.add("Table for 3");
        Family.add("Table for 4");
        Family.add("Table for 5");
        Family.add("Table for 6");
        Family.add("Table for 7");
        Family.add("Table for 8");

        List<String> Date = new ArrayList<String>();
        Date.add("Couple");
        Date.add("Double date");
        Date.add("Hexad Date");
        Date.add("Octet Date");

        List<String> Cellebrating = new ArrayList<String>();
        Cellebrating.add("10 Guests");
        Cellebrating.add("11 Guests");
        Cellebrating.add("12 Guests");
        Cellebrating.add("13 Guests");
        Cellebrating.add("14 Guests");

        expandableListDetail.put("Family", Family);
        expandableListDetail.put("Date", Date);
        expandableListDetail.put("Cellebrating", Cellebrating);
        return expandableListDetail;
    }


}
