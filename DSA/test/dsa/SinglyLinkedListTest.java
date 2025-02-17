package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    public void sizeIsZeroByDefault_SinglyLinkedListTest() {
        assertEquals(0, list.size());
    }

    @Test
    public void addX_sizeIncreasesByOne_SinglyLinkedListTest() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
    }

    @Test
    public void addXY_sizeIncreasesByTwo_SinglyLinkedListTest() {
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void addX_getIndexZero_returnX_SinglyLinkedListTest() {
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void addXYZ_getIndexOne_returnY_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
    }

    @Test
    public void addXY_getIndexZero_returnX_prependZ_getIndexZero_returnZ_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));

        list.prepend(3);
        assertEquals(3, list.get(0));
    }

    @Test
    public void addXYZ_getIndexOne_returnY_insertAInIndexOne_getIndexOne_returnA_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));

        list.insert(4, 0);
        assertEquals(4, list.get(0));


        list.insert(5, 2);
        assertEquals(5, list.get(2));
    }

    @Test
    public void addXYZ_getIndexThree_throwsException_insertAInIndexThree_throwsException_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 3));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void addXYZ_removeFirstReturnsX_sizeDecreasesByOne_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.size());

        assertEquals(2, list.removeFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void removeFirstOnEmptyListThrowsException_SinglyLinkedListTest() {
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    public void addXYZ_removeLastReturnsZ_sizeDecreasesByOne_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());

        assertEquals(3, list.removeLast());
        assertEquals(2, list.size());

        assertEquals(2, list.removeLast());
        assertEquals(1, list.size());
    }

    @Test
    public void removeLastOnEmptyListThrowsException_SinglyLinkedListTest() {
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
    }

    @Test
    public void addXYZ_clearRemovesAllElements_sizeSetToZero_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void addXYZ_listContainsY_returnsTrue_listContainsA_returnsFalse_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    public void addXYZ_indexOfY_returnsOne_SinglyLinkedListTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
        assertEquals(0, list.indexOf(1));
    }

    @Test
    public void indexOf_ThrowsErrorOnEmptyList_SinglyLinkedListTest() {
        assertEquals(0, list.size());
        assertThrows(NoSuchElementException.class, () -> list.indexOf(1));
    }
}
