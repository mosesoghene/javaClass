package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue(3);
    }

    @Test
    public void queueHasCapacity_MyQueueTest() {
        assertEquals(3, queue.capacity());
    }

    @Test
    public void queueIsEmpty_MyQueueTest() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void addX_QueueNotEmpty_MyQueueTest() {
        queue.enqueue("One");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void addX_dequeue_returnX_QueueIsEmpty_MyQueueTest() {
        queue.enqueue("One");
        assertEquals("One", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void addX_dequeue_returnX_QueueIsNotEmpty_MyQueueTest() {}

}
