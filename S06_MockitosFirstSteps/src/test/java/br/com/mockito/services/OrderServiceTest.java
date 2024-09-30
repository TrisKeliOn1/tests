package br.com.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023, 7, 4, 15, 50);

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

    @DisplayName("Should include current time when create a new Order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder() {
        //Given
        try (MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            //When
            Order result = service.createOrder("MacBook", 2L, null);

            //Then
            assertEquals(defaultLocalDateTime, result.getCreationDate());

        }

    }
}