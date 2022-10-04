package ru.urfu.research;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import ru.urfu.research.example.fnl.FinalClass;
import ru.urfu.research.example.fnl.FinalMethod;
import ru.urfu.research.junit.extensions.BytecodeIntrospectionExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;


/**
 * Before enabling this test, check mockito mock maker mode.
 * See src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker.
 */
@Disabled
@ExtendWith(BytecodeIntrospectionExtension.class)
public class FinalTest {

    @Test
    void mockFinalClass() {
        var mock = mock(FinalClass.class);
        when(mock.getN()).thenReturn(12);
    }

    @Test
    void mockFinalMethod() {
        var mock = mock(FinalMethod.class);
        when(mock.getValue()).thenReturn(12);
    }
}
