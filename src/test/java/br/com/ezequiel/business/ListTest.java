package br.com.ezequiel.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        //Given
        var list = mock(List.class);
        when(list.size()).thenReturn(10);

        //Then
        assertEquals(10, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        //Given
        var list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        //Then
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnLucas() {
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Lucas");

        assertEquals("Lucas", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnLucas() {
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Lucas");

        assertEquals("Lucas", list.get(0));
        assertEquals("Lucas", list.get(10));
    }

}
