package com.nci.cad.quickerorder.payload;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompareRequest {
    private ArrayList<Long> quotationIDs;
    private String criteria;
}
