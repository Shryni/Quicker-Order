package com.nci.cad.quickerorder.config;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.Spendings_Service;
import com.nci.cad.quickerorder.service.VendorPRService;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public Quotation_Comparator quotation_comparator(){
        return new Quotation_Comparator();
    }
    @Bean
    public Spendings_Service spendings_service(){
        return new Spendings_Service();
    }
    @Bean
    public JavaMailSenderImpl javaMailSenderImpl()
    {
        JavaMailSenderImpl javaMailSend=  new JavaMailSenderImpl();
        javaMailSend.setProtocol("SMTP");
        javaMailSend.setHost("127.0.0.1");
        javaMailSend.setPort(25);
        return javaMailSend;
    }
}
