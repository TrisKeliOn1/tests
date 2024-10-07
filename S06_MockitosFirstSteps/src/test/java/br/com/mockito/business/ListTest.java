package br.com.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        // Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        // When & Then
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnUser() {

        // Given
        var list = mock(List.class);
        when(list.get(0)).thenReturn("User");

        // When & Then
        assertEquals("User", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnUser() {

        // Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("User");

        // When & Then
        assertEquals("User", list.get(anyInt()));
        assertEquals("User", list.get(anyInt()));
    }

    @Test
    void testMockingList_When_ThrowsException() {

        // Given
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));

        // When & Then
        assertThrows(RuntimeException.class, () -> {list.get(anyInt());}, () -> "Should have throw an RuntimeException");
    }
}
