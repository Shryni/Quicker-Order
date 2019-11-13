package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.service.Invoice_Service;
import com.nci.cad.quickerorder.service.RequestorStore_Service;
import com.nci.cad.quickerorder.service.Spendings_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class ViewController {
    @Autowired
    RequestorStore_Service requestorStore_service;

    @GetMapping("/displayBarGraph")
    public String barGraph(Model model) {
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        surveyMap.put("Java", 40);
        surveyMap.put("Dev oops", 25);
        surveyMap.put("Python", 20);
        surveyMap.put(".Net", 15);
        model.addAttribute("surveyMap", surveyMap);
        return "barGraph";
    }

    @GetMapping("/displayPieChart")
    public String pieChart(Model model) {
        model.addAttribute("pass", 50);
        model.addAttribute("fail", 50);
        return "pieChart";
    }

//    @GetMapping("/spendings/{id}")
//    public String invoiceChart(@Valid @PathVariable long id, Model model){
//        Map<Date , Float> invoiceMap = requestorStore_service.getInvoiceDetails(id);
//        model.addAttribute("invoiceMap", invoiceMap);
////        Map<Date , Float> invoiceMap = new LinkedHashMap<>();
////        invoiceMap.put(Date.valueOf("2019-12-12"),(float) 450.0);
////        invoiceMap.put(Date.valueOf("2018-01-12"),(float) 3560.70);
////        invoiceMap.put(Date.valueOf("2019-02-23"),(float) 1480.4);
////        invoiceMap.put(Date.valueOf("2019-05-19"),(float) 4689.120);
////        model.addAttribute("invoiceMap",invoiceMap);
//        return "invoiceGraph";
//    }

}
