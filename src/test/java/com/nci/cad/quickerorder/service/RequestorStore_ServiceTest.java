package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.RequestorStore;
import com.nci.cad.quickerorder.payload.StoreUpdateObject;
import com.nci.cad.quickerorder.repository.RequestorStore_Repository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RequestorStore_ServiceTest {

    private RequestorStore_Service requestorStore_serviceUnderTest;

    @Before
    public void setUp() {
        requestorStore_serviceUnderTest = new RequestorStore_Service();
        requestorStore_serviceUnderTest.requestorStore_repository = mock(RequestorStore_Repository.class);
    }

    @Test
    public void testGetAllRequestorStores() {
        final List<RequestorStore> expectedResult = Arrays.asList();
        when(requestorStore_serviceUnderTest.requestorStore_repository.findAll()).thenReturn(Arrays.asList());
        final List<RequestorStore> result = requestorStore_serviceUnderTest.getAllRequestorStores();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetRequestorStore() {
        final RequestorStore expectedResult = new RequestorStore("name", "username", "email", "password");
        when(requestorStore_serviceUnderTest.requestorStore_repository.findById(1L)).thenReturn(Optional.empty());
        final RequestorStore result = requestorStore_serviceUnderTest.getRequestorStore(1L);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testAddRequestorStore() throws Exception {
        final RequestorStore requestorStore = new RequestorStore("name", "username", "email", "password");
        final RequestorStore expectedResult = new RequestorStore("name", "username", "email", "password");
        final RequestorStore requestorStore1 = new RequestorStore("name", "username", "email", "password");
        when(requestorStore_serviceUnderTest.requestorStore_repository.save(new RequestorStore("name", "username", "email", "password"))).thenReturn(requestorStore);
        final RequestorStore result = requestorStore_serviceUnderTest.addRequestorStore(requestorStore1);
        assertEquals(expectedResult, result);
    }

    @Test(expected = URISyntaxException.class)
    public void testAddRequestorStore_ThrowsURISyntaxException() throws Exception {
        final RequestorStore requestorStore = new RequestorStore("name", "username", "email", "password");
        final RequestorStore requestorStore1 = new RequestorStore("name", "username", "email", "password");
        when(requestorStore_serviceUnderTest.requestorStore_repository.save(new RequestorStore("name", "username", "email", "password"))).thenReturn(requestorStore);
        requestorStore_serviceUnderTest.addRequestorStore(requestorStore1);
    }




}
