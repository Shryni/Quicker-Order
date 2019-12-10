package com.nci.cad.quickerorder.payload;

import com.nci.cad.quickerorder.model.Quotation;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class QuotationResponse {
   private Quotation quotation;
   private String vendorStoreName;
}
