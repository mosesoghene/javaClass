package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(0, sll.size());
        sll.add(1);
        assertEquals(1, sll.size());
    }

    @Test
    public void addXY_sizeIncreasesByTwo_SinglyLinkedListTest() {
        assertEquals(0, sll.size());
        sll.add(1);
        sll.add(2);
        assertEquals(2, sll.size());
    }

    @Test
    public void addX_getIndexZero_returnX_SinglyLinkedListTest() {
        sll.add(1);
        assertEquals(1, sll.get(0));
    }

    @Test
    public void addXYZ_getIndexOne_returnY_SinglyLinkedListTest() {
        sll.add(1);
        sll.add(2);
        sll.add(3);
        assertEquals(2, sll.get(1));
    }

    @Test
    public void addXY_getIndexZero_returnX_prependZ_getIndexZero_returnZ_SinglyLinkedListTest() {
        sll.add(1);
        sll.add(2);
        assertEquals(1, sll.get(0));

        sll.prepend(3);
        assertEquals(3, sll.get(0));
    }

    @Test
    public void addXYZ_getIndexOne_returnY_insertAInIndexOne_getIndexOne_returnA_SinglyLinkedListTest() {
        sll.add(1);
        sll.add(2);
        sll.add(3);
        assertEquals(2, sll.get(1));

        sll.insert(4, 0);
        assertEquals(4, sll.get(0));


        sll.insert(5, 2);
        assertEquals(5, sll.get(2));
    }

    @Test
    public void addXYZ_getIndexThree_throwsException_insertAInIndexThree_throwsException_SinglyLinkedListTest() {
        sll.add(1);
        sll.add(2);
        sll.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> sll.insert(4, 3));

        assertThrows(IndexOutOfBoundsException.class, () -> sll.get(3));
    }

}
