package com.nci.cad.quickerorder.service;


import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.payload.QuotationResponse;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;

public class Quotation_Comparator {


    public List<QuotationResponse> compareQuotations(List<Quotation> quotations,String criteria) throws ParseException {
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
                allDiscounts.add(quotation.getDiscount());
            }
            Map<Integer, Date> bestDeliveryDates = new HashMap<>();
            bestDeliveryDates = compareDeliveryDate(allDeliveryDates);
            List<QuotationResponse> bestDeliveryDateQuotations = new ArrayList<>();
            Iterator itr1= bestDeliveryDates.entrySet().iterator();
            while ( itr1.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr1.next();
                Quotation q = quotations.get((Integer) thisEntry.getKey());
                String vendorName = q.getVendorPR().getVendorStore().getName();
                bestDeliveryDateQuotations.add(new QuotationResponse(q,vendorName));
            }

            Map<Integer , Boolean> bestTransport = new HashMap<>();
            bestTransport = compareTransport(allTransport);
            List<QuotationResponse> bestTransportQuotations = new ArrayList();
            Iterator itr2 = bestTransport.entrySet().iterator();
            while (itr2.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr2.next();
                Quotation q = quotations.get((Integer) thisEntry.getKey());
                String vendorName = q.getVendorPR().getVendorStore().getName();
                bestTransportQuotations.add(new QuotationResponse(q,vendorName));
            }

            Map<Integer, Float> bestPrices = new HashMap<>();
            bestPrices = comparePrices(allPrices);
            List<QuotationResponse> bestPriceQuotation = new ArrayList<>();
            Iterator itr3 = bestPrices.entrySet().iterator();
            while (itr3.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr3.next();
                Quotation q = quotations.get((Integer) thisEntry.getKey());
                String vendorName = q.getVendorPR().getVendorStore().getName();
                bestPriceQuotation.add(new QuotationResponse(q,vendorName));
            }

            Map<Integer, Float> bestDiscount = new HashMap<>();
            bestDiscount = compareDiscount(allDiscounts);
            List<QuotationResponse> bestDiscountQuotations = new ArrayList<>();
            Iterator itr4 = bestDiscount.entrySet().iterator();
            while (itr4.hasNext()){
                Map.Entry thisEntry = (Map.Entry) itr4.next();
                Quotation q = quotations.get((Integer) thisEntry.getKey());
                String vendorName = q.getVendorPR().getVendorStore().getName();
                bestDiscountQuotations.add(new QuotationResponse(q,vendorName));
            }
            //TODO
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
            if(!thisTransport){
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
    private Map<Integer, Float> compareDiscount(ArrayList<Float> allDiscounts) {
        Map<Integer , Float> bestDiscount = new HashMap<>();
        Float currentBestDiscount = allDiscounts.get(0);
        int counter =0;
        int currentIndex = 0;
        for (Float thisDiscount: allDiscounts) {
            if(thisDiscount > currentBestDiscount){
                currentBestDiscount = thisDiscount;
                currentIndex = counter;
            }
            else if(Float.compare(thisDiscount,currentBestDiscount) == 0){
                if(counter != 0){
                    bestDiscount.put(counter,thisDiscount);
                }
            }
            else{
                System.out.println("Invalid");
            }
            counter++;
        }
        bestDiscount.put(currentIndex,currentBestDiscount);
        return bestDiscount;
    }
}
