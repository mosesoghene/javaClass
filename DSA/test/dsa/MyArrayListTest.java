package dsa;

import dsa.MyArrayList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
