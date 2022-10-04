package ru.urfu.research;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.urfu.research.example.hierarchy.Child;
import ru.urfu.research.example.hierarchy.Parent;
import ru.urfu.research.junit.extensions.BytecodeIntrospectionExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(BytecodeIntrospectionExtension.class)
public class HierarchyTest {

    @Test
    void mockInheritedMember() {
        var mock = mock(Child.class);
        when(mock.getS()).thenReturn("some test string");
    }

    /**
     * SubclassByteBuddyMockMaker does not support the creation of static mocks
     * <br>
     * Mockito's inline mock maker supports static mocks based on the Instrumentation API.
     * You can simply enable this mock mode, by placing the 'mockito-inline' artifact where you are currently using
     * 'mockito-core'.
     */
    @Test
    @Disabled
    void mockParentThenMockChild() {
        var mock = mockStatic(Parent.class);
        when(Parent.getGreetingString()).thenReturn("some test string from parent class");
    }
}
