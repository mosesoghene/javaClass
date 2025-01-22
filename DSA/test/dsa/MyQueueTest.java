package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue(3);
    }


}
