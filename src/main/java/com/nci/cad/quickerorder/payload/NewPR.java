package com.nci.cad.quickerorder.payload;

import com.nci.cad.quickerorder.model.VendorStore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewPR {
    @NotBlank
    private String title;

    private Date created_date;
    private Date expected_date_of_delivery;
    private String status;
    private String additional_comments;
    private Boolean save_template;
    private Long requestorID;
    private VendorStore[] vendorStoreList;
    private List<String> checkedVendors;
    private Boolean indeterminate;
    private Boolean checkAll;
}
