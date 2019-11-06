package com.nci.cad.quickerorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateComparator {
    public static void main(String[] args) {
//        Date date1 = java.sql.Date.valueOf("2010-10-20");
//        Date date2 = java.sql.Date.valueOf("2010-06-15");
//        Date date3 = java.sql.Date.valueOf("2010-06-15");
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
        Map<Integer , Float> bestPrices = new HashMap<>();
        ArrayList<Float> allPrices = new ArrayList<>();
        allPrices.add((float) 345.6);
        allPrices.add((float) 345.6);
        allPrices.add((float) 785.6);
        allPrices.add((float) 345.6);
        Float currentBestPrice = allPrices.get(0);
        int counter =0;
        int currentIndex = 0;
        for (Float thisPrice: allPrices) {
            System.out.println();
            System.out.println("For "+thisPrice);
            System.out.println("************* "+counter);
            System.out.println("CURRENT BEST "+currentBestPrice);
            if(thisPrice < currentBestPrice){
                currentBestPrice = thisPrice;
                currentIndex = counter;
                System.out.println("Updated "+currentBestPrice +" and index "+currentIndex);
            }
            else if(Float.compare(thisPrice,currentBestPrice) == 0){

                if(counter != 0){
                    bestPrices.put(counter,thisPrice);
                    System.out.println(bestPrices+"!!!!");
                }
                else{
                    System.out.println("Counter is 0 for "+thisPrice);

                }
            }
            else{
                System.out.println("Invalid");
            }
            counter++;
        }
        bestPrices.put(currentIndex,currentBestPrice);
        System.out.println(bestPrices);
    }
}
