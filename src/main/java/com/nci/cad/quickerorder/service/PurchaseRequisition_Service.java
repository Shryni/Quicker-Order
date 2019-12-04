package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.payload.NewPR;
import com.nci.cad.quickerorder.repository.*;
import com.nci.cad.quickerorder.utils.Observer;
import com.nci.cad.quickerorder.utils.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseRequisition_Service implements Subject {

    @Autowired
    PurchaseRequisition_Repository purchaseRequisition_repository;

    @Autowired
    VendorPR_Repository vendorPR_repository;

    @Autowired
    VendorStore_Repository vendorStore_repository;

    @Autowired
    Requestor_Repository requestor_repository;

    private List<Observer> observers;
    private boolean changed;
    private final Object MUTEX= new Object();

    public PurchaseRequisition_Service(){
        this.observers = new ArrayList<>();
    }

   // @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

   // @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers(PurchaseRequisition pr, VendorStore vendorStore) {
        List<Observer> observersLocal = null;
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            System.out.println("PR: "+pr);
            obj.update(pr,vendorStore);
        }
    }



    public List<PurchaseRequisition> getPRByRequestorID(Long requestorID) {
        return purchaseRequisition_repository.findByRequestorId(requestorID);
    }
    public List<PurchaseRequisition> getAllPR(){
        return purchaseRequisition_repository.findAll();
    }
    public PurchaseRequisition getPRByID(Long prID) {
        return purchaseRequisition_repository.findById(prID).get();
    }

   public PurchaseRequisition addPurchaseRequisition(NewPR newPR) throws URISyntaxException {
       System.out.println("HI :"+newPR);
       Requestor requestor = requestor_repository.findById(newPR.getRequestorID()).get();


       PurchaseRequisition pr = new PurchaseRequisition();
       pr.setTitle(newPR.getTitle());
       pr.setCreated_date(newPR.getCreated_date());
       pr.setExpected_date_of_delivery(newPR.getExpected_date_of_delivery());
       pr.setStatus(newPR.getStatus());
       pr.setAdditional_comments(newPR.getAdditional_comments());
       pr.setSave_template(newPR.getSave_template());
       pr.setRequestor(requestor);
       System.out.println("PR:::: "+pr);
       PurchaseRequisition purchaseRequisition = purchaseRequisition_repository.save(pr);
       System.out.println("DONEEEE");

       System.out.println("CAlling notif: "+purchaseRequisition);
       System.out.println("UIUI"+ newPR.getCheckedVendors());

       if(purchaseRequisition != null){
           for (String vendorstorename:
                   newPR.getCheckedVendors()) {
               VendorStore vendorStore = vendorStore_repository.findByName(vendorstorename).get();
               System.out.println("CAlling notif");
               this.changed = true;
               notifyObservers(pr,vendorStore);
//                VendorPR vpr = new VendorPR();
//               vpr.setId(purchaseRequisition.getId());
//               vpr.setTitle(purchaseRequisition.getTitle());
//               vpr.setCreated_date(purchaseRequisition.getCreated_date());
//               vpr.setExpected_date_of_delivery(purchaseRequisition.getExpected_date_of_delivery());
//               vpr.setStatus(purchaseRequisition.getStatus());
//               vpr.setAdditional_comments(purchaseRequisition.getAdditional_comments());
//               vpr.setVendorStore(vendorStore);
//               vendorPR_repository.save(vpr);
           }
       }

       return purchaseRequisition;
    }

    public ResponseEntity<PurchaseRequisition> updatePUrchaseRequisition(PurchaseRequisition purchaseRequisition) {
        PurchaseRequisition purchaseRequisition1 = purchaseRequisition_repository.save(purchaseRequisition);
        return ResponseEntity.ok().body(purchaseRequisition1);
    }

    public ResponseEntity<?> deletePurchaseRequisition(Long id) {
        purchaseRequisition_repository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
