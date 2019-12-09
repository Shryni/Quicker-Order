package com.nci.cad.quickerorder.payload;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewQuotation {
    private String title;
    private Date quote_date;
    private Date deliveryDate;
    private Boolean status;
    private Date quoteValidity;
    private String additional_comments;
    private Long vendorPRID;
    private ArrayList<String> optionList;
    private ArrayList<String> checkedFeatures;
    private  Boolean indeterminate;
    private double initialPrice;
    private double price;
}
