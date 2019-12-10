package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.payload.GeneratePrice;
import com.nci.cad.quickerorder.payload.NewQuotation;
import com.nci.cad.quickerorder.payload.QuotationResponse;
import com.nci.cad.quickerorder.payload.Spending;
import com.nci.cad.quickerorder.repository.PurchaseRequisition_Repository;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.repository.VendorPR_Repository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class Quotation_ServiceTest {

    private Quotation_Service quotation_serviceUnderTest;

    @Before
    public void setUp() {
        quotation_serviceUnderTest = new Quotation_Service();
        quotation_serviceUnderTest.quotation_repository = mock(Quotation_Repository.class);
        quotation_serviceUnderTest.vendorPR_repository = mock(VendorPR_Repository.class);
        quotation_serviceUnderTest.purchaseRequisition_repository = mock(PurchaseRequisition_Repository.class);
        quotation_serviceUnderTest.purchaseRequisition_Repository = mock(PurchaseRequisition_Repository.class);
        quotation_serviceUnderTest.applyDiscount = mock(ApplyDiscount.class);
    }

    @Test
    public void testGetAll() {
        final List<Quotation> expectedResult = Arrays.asList();
        when(quotation_serviceUnderTest.quotation_repository.findAll()).thenReturn(Arrays.asList());
        final List<Quotation> result = quotation_serviceUnderTest.getAll();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetQuotationByID() {
        final Quotation expectedResult = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.quotation_repository.findById(1L)).thenReturn(Optional.empty());
        final Quotation result = quotation_serviceUnderTest.getQuotationByID(1L);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testAddQuotation() throws Exception {
        final NewQuotation newQuotation = new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0);
        final Quotation expectedResult = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.vendorPR_repository.findById(1L)).thenReturn(Optional.empty());
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.applyDiscount.addDiscountToQuotation(1L, 1L, new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null))).thenReturn(quotation);
        final Quotation quotation1 = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.quotation_repository.save(new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null))).thenReturn(quotation);

        final Quotation result = quotation_serviceUnderTest.addQuotation(newQuotation);
        assertEquals(expectedResult, result);
    }

    @Test(expected = URISyntaxException.class)
    public void testAddQuotation_ThrowsURISyntaxException() throws Exception {
        final NewQuotation newQuotation = new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0);
        when(quotation_serviceUnderTest.vendorPR_repository.findById(1L)).thenReturn(Optional.empty());
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.applyDiscount.addDiscountToQuotation(1L, 1L, new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null))).thenReturn(quotation);

        final Quotation quotation1 = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.quotation_repository.save(new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null))).thenReturn(quotation);

        quotation_serviceUnderTest.addQuotation(newQuotation);
    }




    @Test
    public void testGetAllForPR() {
        final List<QuotationResponse> expectedResult = Arrays.asList();
        when(quotation_serviceUnderTest.vendorPR_repository.findBypurchaseRequisition_id(1L)).thenReturn(Arrays.asList());
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotation_serviceUnderTest.quotation_repository.findByVendorPRId(1L)).thenReturn(quotation);
        final List<QuotationResponse> result = quotation_serviceUnderTest.getAllForPR(1L);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGenerateQuotationPrice() {
        final GeneratePrice generatePrice = new GeneratePrice(new ArrayList<>(Arrays.asList()), 0.0);
        final Double expectedResult = 0.0;
        final Double result = quotation_serviceUnderTest.generateQuotationPrice(generatePrice);
        assertEquals(expectedResult, result, 0.0001);
    }

    @Test
    public void testGetSpendingsByRequestors() {
        final List<Spending> expectedResult = Arrays.asList();
        when(quotation_serviceUnderTest.quotation_repository.findUsingRequestorIdAndStatus(1L, "status")).thenReturn(Arrays.asList());

        final List<Spending> result = quotation_serviceUnderTest.getSpendingsByRequestors(1L, "status");
        assertEquals(expectedResult, result);
    }




}
