package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySetTest {
    private MySet set;

    @BeforeEach
    public void setUp(){
        set = new MySet();
    }

    @Test
    public void addXY_sizeIncreases_MySetTest(){
        set.add("One");
        set.add("Two");
        assertEquals(2, set.size());
    }


    @Test
    void add() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }

    @Test
    void get() {
    }
}
