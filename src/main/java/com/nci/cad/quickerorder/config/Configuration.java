package com.nci.cad.quickerorder.config;

import com.nci.cad.quickerorder.service.Quotation_Comparator;
import com.nci.cad.quickerorder.service.Spendings_Service;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Quotation_Comparator quotation_comparator(){
        return new Quotation_Comparator();
    }
}
