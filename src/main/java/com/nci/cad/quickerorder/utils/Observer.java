package com.nci.cad.quickerorder.utils;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorStore;

public interface Observer {

    public void update();
//    public void update(PurchaseRequisition pr, VendorStore vendorStore);
    public void setSubject(Subject sub);
}
