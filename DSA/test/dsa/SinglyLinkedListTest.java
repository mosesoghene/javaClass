package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> sll;

    @BeforeEach
    void setUp() {
        sll = new SinglyLinkedList<>();
    }

    @Test
    public void sizeIsZeroByDefault_SinglyLinkedListTest() {
        assertEquals(0, sll.size());
    }

    @Test
    public void addX_sizeIncreasesByOne_SinglyLinkedListTest() {
        sll.add(1);
        assertEquals(1, sll.size());
    }

}
