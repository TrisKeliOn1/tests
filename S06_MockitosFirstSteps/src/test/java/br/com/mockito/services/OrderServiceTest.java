package br.com.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

    @DisplayName("Should include random OrderId when no OrderId exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderExists() {
        //Given
        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            //When
            Order result = service.createOrder("MacBook", 2L, null);

            //Then
            assertEquals(defaultUuid.toString(), result.getId());

        }

    }
}