package com.example.service;

import com.example.api.ExternalApi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the method to return predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject the mock into the service and test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assertion
        assertEquals("Mock Data", result);
    }
}
