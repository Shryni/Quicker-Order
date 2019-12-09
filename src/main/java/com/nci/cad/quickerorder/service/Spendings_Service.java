package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Invoice;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Spendings_Service {

    public ResponseEntity<?> getMonthlyExpense(List<Invoice> invoiceList, @Valid String startDate, String endDate) {


        List<Date> invoice_Dates = new ArrayList<>();
        String range;
        int slots;
        for (Invoice invoice: invoiceList) {
            invoice_Dates.add((Date) invoice.getDate());
        }
        Collections.sort(invoice_Dates);
        LocalDate start = LocalDate.fromDateFields(invoice_Dates.get(0));
        LocalDate end = LocalDate.fromDateFields(invoice_Dates.get(invoice_Dates.size()-1));
        int days = Days.daysBetween(start, end).getDays();



        System.out.println(days);
        if(days >0 && days<=42){
            range = "weeks";
            slots = days/7;
        }
        else if( days>42 && days<=365){
            range = "months";
            slots = days/30;
        }
        else {
            range = "years";
            slots = days/365;
        }


        return null;
    }
    private Map<Date , Float> expenditure(List<Invoice> invoiceList){
        return null;
    }
}
