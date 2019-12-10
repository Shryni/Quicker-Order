package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.VendorStore;
import com.nci.cad.quickerorder.repository.VendorStore_Repository;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VendorStore_ServiceTest {

    private VendorStore_Service vendorStore_serviceUnderTest;

    @Before
    public void setUp() {
        vendorStore_serviceUnderTest = new VendorStore_Service();
        vendorStore_serviceUnderTest.vendorStore_repository = mock(VendorStore_Repository.class);
    }

    @Test
    public void testGetAllVendorStores() {
        final List<VendorStore> expectedResult = Arrays.asList();
        when(vendorStore_serviceUnderTest.vendorStore_repository.findAll()).thenReturn(Arrays.asList());
        final List<VendorStore> result = vendorStore_serviceUnderTest.getAllVendorStores();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindByID() {
        final VendorStore expectedResult = new VendorStore(1L, "Cargill", "pranav", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");
        when(vendorStore_serviceUnderTest.vendorStore_repository.findById(1L)).thenReturn(Optional.empty());
        final VendorStore result = vendorStore_serviceUnderTest.findByID(1L);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testAddVendorStore() {
        final VendorStore vendorStore = new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");
        final VendorStore expectedResult = new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");

        final VendorStore vendorStoreNew = new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");
        when(vendorStore_serviceUnderTest.vendorStore_repository.save(new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact"))).thenReturn(vendorStore);
        final VendorStore result = vendorStore_serviceUnderTest.addVendorStore(vendorStoreNew);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdateVendorStore() {
        final VendorStore vendorStore = new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");
        final VendorStore expectedResult = new VendorStore(1L, "name", "username", "password", "email", "storeAddress_line1", "storeAddress_line2", "storeAddress_line3", "store_city", "store_postal_code", "store_contact");
        when(vendorStore_serviceUnderTest.vendorStore_repository.findById(1L)).thenReturn(Optional.empty());
        final VendorStore result = vendorStore_serviceUnderTest.updateVendorStore(vendorStore);
        assertEquals(expectedResult, result);
    }
}
