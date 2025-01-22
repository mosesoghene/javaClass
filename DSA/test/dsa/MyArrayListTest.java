package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    MyArrayList strings;

    @BeforeEach
    public void setUp() {
        strings = new MyArrayList();
    }

    @Test
    public void listIsEmptyOnCreation_MyArrayTest(){
        boolean listIsEmpty = strings.isEmpty();
        assertTrue(listIsEmpty);
    }

    @Test
    public void listSizeIsZeroOnCreation_MyArrayTest(){
        assertEquals(0, strings.size());
    }

    @Test
    public void addX_sizeIncreasesByOne_MyArrayTest(){
        strings.add("One");
        assertEquals(1, strings.size());
    }

    @Test
    public void addX_getXinIndexZero_MyArrayTest() throws Exception {
        strings.add("One");
        assertEquals("One", strings.get(0));
    }

    @Test
    public void addXY_getXinIndexOne_MyArrayTest() throws Exception {
        strings.add("One");
        strings.add("Two");
        assertEquals("Two", strings.get(1));
    }

    @Test
    public void addXY_getElementIndex2_throwsException_MyArrayTest() throws Exception {
        strings.add("One");
        strings.add("Two");

        boolean thrown = false;
        try {
            String data = strings.get(4);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void addXY_capaictyUnchanged_Y_capacityDoubles_ZAB_capacityDoublesAgain_MyArrayTest() {
        strings.add("One");
        strings.add("Two");
        assertEquals(3, strings.capacity());
        strings.add("Three");
        assertEquals(6, strings.capacity());
        strings.add("Four");
        strings.add("Five");
        strings.add("Six");
        assertEquals(12, strings.capacity());
    }

    @Test
    public void addXYZ_insertAinY_getIndex2ReceiveY_MyArrayTest() throws Exception {
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        assertEquals("Three", strings.get(2));
        strings.insert(1 ,"Four");
        assertEquals("Two", strings.get(2));
    }

    @Test
    public void addXYZ_removeY_getIndex1ReceiveZ_MyArrayTest() throws Exception {
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        strings.remove("Two");
        assertEquals("Three", strings.get(1));
    }

    @Test
    public void addXYZ_removeA_throwsError_ElementNotFound_MyArrayTest() throws Exception {
        strings.add("One");
        strings.add("Two");
        strings.add("Three");

        boolean thrown = false;
        try {
            strings.remove("four");
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void addXYZ_containsYReturnsTrue_MyArrayTest() {
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        assertTrue(strings.contains("Two"));
        assertFalse(strings.contains("A"));
    }

    @Test
    public void addXYZ_returnsXYZ_MyArrayTest() {
        strings.add("One");
        strings.add("Two");
        strings.add("Three");
        assertEquals("[One, Two, Three]", strings.toString());
    }
}
