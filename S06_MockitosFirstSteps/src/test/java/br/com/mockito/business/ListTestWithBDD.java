package br.com.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTestWithBDD {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        // Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        // When & Then
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnUser() {

        // Given
        var list = mock(List.class);
        given(list.get(0)).willReturn("User");

        // When & Then
        assertThat(list.get(0), is("User"));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnUser() {

        // Given
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("User");

        // When & Then
        assertThat(list.get(anyInt()), is("User"));
        assertThat(list.get(anyInt()), is("User"));
    }

    @Test
    void testMockingList_When_ThrowsException() {

        // Given
        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

        // When & Then
        assertThrows(RuntimeException.class, () -> {list.get(anyInt());}, () -> "Should have throw an RuntimeException");
    }
}
