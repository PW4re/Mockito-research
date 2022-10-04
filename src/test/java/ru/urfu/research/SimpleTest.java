package ru.urfu.research;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.urfu.research.example.Simple;
import ru.urfu.research.junit.extensions.BytecodeIntrospectionExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(BytecodeIntrospectionExtension.class)
public class SimpleTest {

    @Test
    void mockMethod() {
        var mock = mock(Simple.class);
        when(mock.getN()).thenReturn(12);
    }

    @Test
    void mockMock() {
        var mock = mock(Simple.class);
        when(mock.getS()).thenReturn("some test string");
        var mockMock = spy(mock);
        when(mockMock.getN()).thenReturn(12);
    }
}
