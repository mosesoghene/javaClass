package dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMapTest {
    private MyMap map;

    @BeforeEach
    void setUp() {
        map = new MyMap();
    }

    @Test
    public void putXY_sizeIncreases_MapTest(){
        map.put("1", "Hello");
        map.put("2", "Hello world");
        assertEquals(2, map.size());
    }

}
