package com.nci.cad.quickerorder.service;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Weeks;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateComparator {
    public static void main(String[] args) {
        Date date1 = java.sql.Date.valueOf("2010-06-15");
        Date date2 = java.sql.Date.valueOf("2010-12-15");
        Date date3 = java.sql.Date.valueOf("2010-06-15");

        DateTime date11 = new DateTime(date1);
        DateTime date12 = new DateTime(date2);

        int weeks = Weeks.weeksBetween(date11, date12).getWeeks();
        //System.out.println(weeks);

        LocalDate start = LocalDate.parse(String.valueOf(date1));
        LocalDate end = LocalDate.parse(String.valueOf(date2));
        int days = Days.daysBetween(date11, date12).getDays();
        System.out.println(days);
//        ArrayList<java.sql.Date> allDeliveryDates = new ArrayList<>();
//        allDeliveryDates.add((java.sql.Date) date1);
//        allDeliveryDates.add((java.sql.Date) date2);
//        allDeliveryDates.add((java.sql.Date) date3);
//
//        Map<Integer, java.sql.Date> deliveryDateMap = new HashMap<>();
//
//        java.sql.Date currentEarliest = allDeliveryDates.get(0);
//        int counter = 0;
//        int currentEarliestindex = 0;
//        for (Date thisDate: allDeliveryDates) {
//            System.out.println("For "+thisDate);
//            if(thisDate.compareTo(currentEarliest)>0){
//                System.out.println("You have the earliest date "+currentEarliest);
//            }
//            else if(thisDate.compareTo(currentEarliest)<0){
//
//                currentEarliest = (java.sql.Date) thisDate;
//                currentEarliestindex = counter;
//            }
//            else if(thisDate.compareTo(currentEarliest)== 0){
//                if(counter != 0){
//                    deliveryDateMap.put(counter , (java.sql.Date) thisDate);
//                    System.out.println("Updated "+deliveryDateMap);
//                }
//            }
//            else{
//                System.out.println("Invalid");
//            }
//            counter++;
//        }
//        deliveryDateMap.put(currentEarliestindex,currentEarliest);
//        System.out.println(deliveryDateMap);



    }
}
