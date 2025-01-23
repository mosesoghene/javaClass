package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {
    private MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack();
    }

    @Test
    public void pushXY_sizeIncreases_testPush() {
        stack.push("One");
        stack.push("Two");
        assertEquals(2, stack.size());
    }

    @Test
    public void popXY_sizeDecreases_testPop() throws Exception {
        stack.push("One");
        stack.push("Two");
        assertEquals(2, stack.size());
        assertEquals("Two",stack.pop());
    }

    @Test
    public void pushXY_peekReturnY_peekTest() throws Exception {
        stack.push("One");
        stack.push("Two");
        assertEquals("Two",stack.peek());
    }

    @Test
    public void pushXY_popYX_isEmptyReturnsTrue_isEmptyTest() throws Exception {
        stack.push("One");
        stack.push("Two");
        assertEquals(2, stack.size());
        assertEquals("Two",stack.pop());
        assertEquals("One", stack.pop());
        assertTrue(stack.isEmpty());
    }
}
