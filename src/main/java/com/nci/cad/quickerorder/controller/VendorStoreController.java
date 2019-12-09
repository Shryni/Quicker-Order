package com.nci.cad.quickerorder.controller;
import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.service.VendorStore_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/vendorstore")
public class VendorStoreController {
    @Autowired
    VendorStore_Service vendorStore_service;

    ResponseEntity responseEntity = null;

    @GetMapping("/view/{id}")
    public String viewVendorstore(Model model, @PathVariable("id") String id) {
        model.addAttribute("vendorStore", vendorStore_service.findByID(Long.parseLong(id)));
        return "VendorStore/view.html";
    }

    @GetMapping("/add")
    public String addVendorstore() {

        return "VendorStore/add.html";
    }

    @GetMapping("/edit")
    public String editVendorstore() {
        return "VendorStore/edit.html";
    }
    //-------------------------------------------------------------------------

    @GetMapping("/all")
    public ResponseEntity<List<VendorStore>> getAllVendorStores(){
        List<VendorStore> vendorStores = vendorStore_service.getAllVendorStores();
        if(vendorStores != null){
            return responseEntity.status(HttpStatus.OK).body(vendorStores);
        }
        else{
            return (ResponseEntity<List<VendorStore>>) responseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public String getVendorStorebyID(@Valid @PathVariable long id){
        VendorStore vendorStore = vendorStore_service.findByID(id);
        if(vendorStore != null){
            return "VendorStore/view.html";
        }
        else{
            return "";
        }
    }

    @PostMapping("/new")
    public String  addVendorStore(@Valid /*@RequestBody*/ VendorStore vendorStore) throws URISyntaxException{
        VendorStore vendorStore1 = vendorStore_service.addVendorStore(vendorStore);
        if(vendorStore != null){
            //return responseEntity.status(HttpStatus.OK).body(vendorStore);
            return "redirect:view/" + vendorStore.getId();
        }
        else{
            //return (ResponseEntity<VendorStore>) responseEntity.status(HttpStatus.BAD_REQUEST);
            return "";
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroup( @Valid @PathVariable Long id) {
        //return vendorStore_service.deleteVendorStore(id);
        return null;
    }
}
