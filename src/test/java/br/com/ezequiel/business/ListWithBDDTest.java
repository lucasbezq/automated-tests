package br.com.ezequiel.business;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

public class ListWithBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        //Given
        var list = mock(List.class);
        given(list.size()).willReturn(10);

        //Then
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        //Given
        var list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        //Then
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnLucas() {
        var list = mock(List.class);
        given(list.get(0)).willReturn("Lucas");

        assertThat(list.get(0), is("Lucas"));
        assertNull(list.get(1));
    }


    @Test
    void testMockingList_When_ThrowsAnException() {
        var list = mock(List.class);

        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should have throw an RuntimeException");
    }



}
