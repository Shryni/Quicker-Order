package com.nci.cad.quickerorder.service;


import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;

@Service
public class Quotation_Comparator {
    @Autowired
    Quotation_Repository quotation_repository;

    public List<Quotation> compareQuotations(List<Quotation> quotations, String criteria) throws ParseException {
        if(quotations.size()<2){
            System.out.println("Cannot Compare less than 2 quotations!");
            return null;
        }
        else {
            ArrayList<Date> allDeliveryDates = new ArrayList<>();
            ArrayList<Boolean> allTransport = new ArrayList<>();
            ArrayList<Float> allPrices = new ArrayList<>();
            ArrayList<Float> allDiscounts = new ArrayList<>();

            for(Quotation quotation : quotations){
                allDeliveryDates.add(quotation.getDeliveryDate());
                allTransport.add(quotation.getTransport());
                allPrices.add(quotation.getTotalPrice());
                System.out.println(quotation.getTotalPrice());
                //allDiscounts.add(quotation.getDiscount());
            }
            Map<Integer, Date> bestDeliveryDates = new HashMap<>();
            bestDeliveryDates = compareDeliveryDate(allDeliveryDates);
            List<Quotation> bestDeliveryDateQuotations = new ArrayList<>();
            Iterator itr1= bestDeliveryDates.entrySet().iterator();
            while ( itr1.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr1.next();
                bestDeliveryDateQuotations.add(quotations.get((Integer) thisEntry.getKey()));
            }

            Map<Integer , Boolean> bestTransport = new HashMap<>();
            bestTransport = compareTransport(allTransport);
            List<Quotation> bestTransportQuotations = new ArrayList();
            Iterator itr2 = bestTransport.entrySet().iterator();
            while (itr2.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr2.next();
                bestTransportQuotations.add(quotations.get((Integer) thisEntry.getKey()));
            }

            Map<Integer, Float> bestPrices = new HashMap<>();
            bestPrices = comparePrices(allPrices);
            List<Quotation> bestPriceQuotation = new ArrayList<>();
            Iterator itr3 = bestPrices.entrySet().iterator();
            while (itr3.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr3.next();
                bestPriceQuotation.add(quotations.get((Integer) thisEntry.getKey()));
            }

            Map<Integer, Float> bestDiscount = new HashMap<>();
            bestDiscount = comparePrices(allDiscounts);
            List<Quotation> bestDiscountQuotations = new ArrayList<>();
            Iterator itr4 = bestDiscount.entrySet().iterator();
            while (itr4.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr4.next();
                bestDiscountQuotations.add(quotations.get((Integer) thisEntry.getKey()));
            }

            switch (criteria){
                case "deliveryDate": return bestDeliveryDateQuotations;
                case "transport": return  bestTransportQuotations;
                case "prices": return  bestPriceQuotation;
                case "discount": return bestDiscountQuotations;
                default: return null;
            }
        }
    }

    private Map<Integer, Date> compareDeliveryDate(ArrayList<Date> allDeliveryDates) {
        Map<Integer, Date> deliveryDateMap = new HashMap<>();
        java.sql.Date currentEarliest = allDeliveryDates.get(0);
        int counter = 0;
        int currentEarliestindex = 0;
        for (java.util.Date thisDate: allDeliveryDates) {
            if(thisDate.compareTo(currentEarliest)>0){
            }
            else if(thisDate.compareTo(currentEarliest)<0){
                currentEarliest = (java.sql.Date) thisDate;
                currentEarliestindex = counter;
            }
            else if(thisDate.compareTo(currentEarliest)== 0){
                if(counter != 0){
                    deliveryDateMap.put(counter , (java.sql.Date) thisDate);
                }
            }
            else{
                System.out.println("Invalid");
            }
            counter++;
        }
        deliveryDateMap.put(currentEarliestindex,currentEarliest);
        return deliveryDateMap;
    }
    private Map<Integer, Boolean> compareTransport(ArrayList<Boolean> allTransport) {
        Map<Integer , Boolean> bestTransport = new HashMap<>();
        int counter = 0;
        for(Boolean thisTransport : allTransport){
            if(thisTransport){
                bestTransport.put(counter, thisTransport);
            }
            counter++;
        }
        return bestTransport;
    }
    private Map<Integer, Float> comparePrices(ArrayList<Float> allPrices) {
        Map<Integer , Float> bestPrices = new HashMap<>();
        Float currentBestPrice = allPrices.get(0);
        int counter =0;
        int currentIndex = 0;
        for (Float thisPrice: allPrices) {
            if(thisPrice < currentBestPrice){
                currentBestPrice = thisPrice;
                currentIndex = counter;
            }
            else if(Float.compare(thisPrice,currentBestPrice) == 0){
                if(counter != 0){
                    bestPrices.put(counter,thisPrice);
                }
            }
            else{
                System.out.println("Invalid");
            }
            counter++;
        }
        bestPrices.put(currentIndex,currentBestPrice);
        return bestPrices;
    }
}
