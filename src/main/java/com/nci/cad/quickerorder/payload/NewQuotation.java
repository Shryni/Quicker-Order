package com.nci.cad.quickerorder.payload;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewQuotation {
    private Long vendorId;
    private Long vednorPRId;
    private Long requestorID;
}
