package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.model.VendorPR;
import com.nci.cad.quickerorder.payload.*;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import com.nci.cad.quickerorder.service.Quotation_Comparator;
import com.nci.cad.quickerorder.service.Quotation_Service;
import com.nci.cad.quickerorder.service.VendorPRService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuotationControllerTest {

    private QuotationController quotationControllerUnderTest;

    @Before
    public void setUp() {
        quotationControllerUnderTest = new QuotationController();
        quotationControllerUnderTest.quotation_service = mock(Quotation_Service.class);
        quotationControllerUnderTest.quotation_repository = mock(Quotation_Repository.class);
        quotationControllerUnderTest.vendorPRService = mock(VendorPRService.class);
        quotationControllerUnderTest.quotation_comparator = mock(Quotation_Comparator.class);
    }

    @Test
    public void testGetAll() {
        final ResponseEntity<List<Quotation>> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.quotation_service.getAll()).thenReturn(Arrays.asList());
        final ResponseEntity<List<Quotation>> result = quotationControllerUnderTest.getAll();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAllForPR() {
        final Id id = new Id(1L);
        final ResponseEntity<List<QuotationResponse>> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.quotation_service.getAllForPR(1L)).thenReturn(Arrays.asList());
        final ResponseEntity<List<QuotationResponse>> result = quotationControllerUnderTest.getAllForPR(id);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareQuotations() throws Exception {
        final CompareRequest compareRequest = new CompareRequest(new ArrayList<>(Arrays.asList()), "criteria");
        final ResponseEntity<List<QuotationResponse>> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.quotation_repository.findById(1L)).thenReturn(Optional.empty());
        when(quotationControllerUnderTest.quotation_comparator.compareQuotations(Arrays.asList(), "criteria")).thenReturn(Arrays.asList());
        final ResponseEntity<List<QuotationResponse>> result = quotationControllerUnderTest.compareQuotations(compareRequest);
        assertEquals(expectedResult, result);
    }

    @Test(expected = ParseException.class)
    public void testCompareQuotations_Quotation_ComparatorThrowsParseException() throws Exception {
        final CompareRequest compareRequest = new CompareRequest(new ArrayList<>(Arrays.asList()), "criteria");
        when(quotationControllerUnderTest.quotation_repository.findById(1L)).thenReturn(Optional.empty());
        when(quotationControllerUnderTest.quotation_comparator.compareQuotations(Arrays.asList(), "criteria")).thenThrow(ParseException.class);
        quotationControllerUnderTest.compareQuotations(compareRequest);
    }

    @Test
    public void testGetQuotationById() {
        final ResponseEntity<Quotation> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotationControllerUnderTest.quotation_service.getQuotationByID(1L)).thenReturn(quotation);
        final ResponseEntity<Quotation> result = quotationControllerUnderTest.getQuotationById(1L);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testApproveQuotation() {
        final Id id = new Id(1L);
        final ResponseEntity<Quotation> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotationControllerUnderTest.quotation_service.approveQuotation(1L)).thenReturn(quotation);
        final ResponseEntity<Quotation> result = quotationControllerUnderTest.approveQuotation(id);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetApproved() {
        final Id id = new Id(1L);
        final ResponseEntity<List<VendorPR>> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.vendorPRService.findApprovedPR(1L)).thenReturn(Arrays.asList());
        final ResponseEntity<List<VendorPR>> result = quotationControllerUnderTest.getApproved(id);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetOptions() {
        final ResponseEntity<List<String>> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        final ResponseEntity<List<String>> result = quotationControllerUnderTest.getOptions();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testAddQuotation() throws Exception {
        final NewQuotation newQuotation = new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0);
        final ResponseEntity<Quotation> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        final Quotation quotation = new Quotation(1L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null);
        when(quotationControllerUnderTest.quotation_service.addQuotation(new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0))).thenReturn(quotation);
        final ResponseEntity<Quotation> result = quotationControllerUnderTest.addQuotation(newQuotation);
        assertEquals(expectedResult, result);
    }

    @Test(expected = URISyntaxException.class)
    public void testAddQuotation_Quotation_ServiceThrowsURISyntaxException() throws Exception {
        final NewQuotation newQuotation = new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0);
        when(quotationControllerUnderTest.quotation_service.addQuotation(new NewQuotation("title", null, null, false, null, "additional_comments", 1L, new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList()), false, 0.0, 0.0))).thenThrow(URISyntaxException.class);

        quotationControllerUnderTest.addQuotation(newQuotation);
    }

    @Test
    public void testGenerateQuotationPrice() throws Exception {
        final GeneratePrice generatePrice = new GeneratePrice(new ArrayList<>(Arrays.asList()), 0.0);
        final ResponseEntity<Double> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.quotation_service.generateQuotationPrice(new GeneratePrice(new ArrayList<>(Arrays.asList()), 0.0))).thenReturn(0.0);
        final ResponseEntity<Double> result = quotationControllerUnderTest.generateQuotationPrice(generatePrice);
        assertEquals(expectedResult, result);
    }

    @Test(expected = URISyntaxException.class)
    public void testGenerateQuotationPrice_ThrowsURISyntaxException() throws Exception {
        final GeneratePrice generatePrice = new GeneratePrice(new ArrayList<>(Arrays.asList()), 0.0);
        when(quotationControllerUnderTest.quotation_service.generateQuotationPrice(new GeneratePrice(new ArrayList<>(Arrays.asList()), 0.0))).thenReturn(0.0);
        quotationControllerUnderTest.generateQuotationPrice(generatePrice);
    }

    @Test
    public void testDeleteQuotation() {
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(quotationControllerUnderTest.quotation_service.deleteQuotation(1L)).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        final ResponseEntity<?> result = quotationControllerUnderTest.deleteQuotation(1L);
        assertEquals(expectedResult, result);
    }
}
