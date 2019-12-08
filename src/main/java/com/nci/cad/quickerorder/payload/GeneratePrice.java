package com.nci.cad.quickerorder.payload;

import lombok.*;

import java.util.ArrayList;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class GeneratePrice {
    private ArrayList<String> features;
    private Double quotedPrice;
}
