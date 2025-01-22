package dsa;

import dsa.MyArrayList.MyArrayList;
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

}
