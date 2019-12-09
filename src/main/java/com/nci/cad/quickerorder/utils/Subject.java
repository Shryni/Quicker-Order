package com.nci.cad.quickerorder.utils;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.VendorStore;

public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);

   public void notifyObservers(PurchaseRequisition pr, VendorStore vendorStore);

}
