package com.nci.cad.quickerorder.controller;

import com.nci.cad.quickerorder.model.PurchaseRequisition;
import com.nci.cad.quickerorder.model.Requestor;
import com.nci.cad.quickerorder.payload.Id;
import com.nci.cad.quickerorder.payload.NewRequestor;
import com.nci.cad.quickerorder.service.PurchaseRequisition_Service;
import com.nci.cad.quickerorder.service.Quotation_Service;
import com.nci.cad.quickerorder.service.Requestor_Service;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestorControllerTest {

    private RequestorController requestorControllerUnderTest;

    @Before
    public void setUp() {
        requestorControllerUnderTest = new RequestorController();
        requestorControllerUnderTest.requestor_service = mock(Requestor_Service.class);
        requestorControllerUnderTest.purchaseRequisition_service = mock(PurchaseRequisition_Service.class);
        requestorControllerUnderTest.quotation_service = mock(Quotation_Service.class);
    }

    @Test
    public void testAddRequestor1() throws Exception {
        final NewRequestor newRequestor = new NewRequestor(1L, "first_name", "last_name", "role", 0L, "email");
        final ResponseEntity<Requestor> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        final Requestor requestor = new Requestor(1L, "first_name", "last_name", "role", "requestor_email", null);
        when(requestorControllerUnderTest.requestor_service.addRequestor(new NewRequestor(1L, "first_name", "last_name", "role", 0L, "email"))).thenReturn(requestor);

        final ResponseEntity<Requestor> result = requestorControllerUnderTest.addRequestor(newRequestor);
        assertEquals(expectedResult, result);
    }

    @Test(expected = URISyntaxException.class)
    public void testAddRequestor_Requestor_ServiceThrowsURISyntaxException1() throws Exception {
        final NewRequestor newRequestor = new NewRequestor(1L, "first_name", "last_name", "role", 0L, "email");
        when(requestorControllerUnderTest.requestor_service.addRequestor(new NewRequestor(1L, "first_name", "last_name", "role", 0L, "email"))).thenThrow(URISyntaxException.class);
        requestorControllerUnderTest.addRequestor(newRequestor);
    }

    @Test
    public void testDeleteRequestor() {
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(requestorControllerUnderTest.requestor_service.deleteRequestor(1L)).thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        final ResponseEntity<?> result = requestorControllerUnderTest.deleteRequestor(1L);
        assertEquals(expectedResult, result);
    }
}
