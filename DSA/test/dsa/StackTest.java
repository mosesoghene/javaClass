package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
