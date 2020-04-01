package com.gds.async.invocation;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author zhanglifeng
 * @since 2020-03-31 18:34
 */
public class MockitoTest {

    @Test
    public void testMockConcreteClass() {
        LinkedList mockedList = mock(LinkedList.class);

//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
//
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));// RuntimeException

//        System.out.println(mockedList.get(999));
//        System.out.println(verify(mockedList).get(0));


        when(mockedList.get(anyInt())).thenReturn("element");


        System.out.println(mockedList.get(anyInt()));

    }

}
