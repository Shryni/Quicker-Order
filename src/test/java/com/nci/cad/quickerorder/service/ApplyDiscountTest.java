package com.nci.cad.quickerorder.service;

import com.nci.cad.quickerorder.model.Quotation;
import com.nci.cad.quickerorder.repository.Quotation_Repository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApplyDiscountTest {

    private ApplyDiscount applyDiscountUnderTest;

    @Before
    public void setUp() {
        applyDiscountUnderTest = new ApplyDiscount();
        applyDiscountUnderTest.quotation_repository = mock(Quotation_Repository.class);
    }

    @Test
    public void testAddDiscountToQuotation() {
        // Setup
        final Quotation quotation = new Quotation(0L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null, null);
        final Quotation expectedResult = new Quotation(0L, null, "status", null, null, false, 0.0f, 0.0f, 0.0f, "go_down_address", null, null);
        when(applyDiscountUnderTest.quotation_repository.findQuotationByPurchaserequitionId(0L, 0L, "status")).thenReturn(0);

        // Run the test
        final Quotation result = applyDiscountUnderTest.addDiscountToQuotation(0L, 0L, quotation);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
