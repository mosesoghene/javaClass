package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList cars;

    @BeforeEach
    public void initializer(){
        cars = new MyArrayList();
    }

    @Test
    public void carsListIsEmpty_MyArrayListTest(){
        assertTrue(cars.isEmpty());
    }

    @Test
    public void addX_carsListIsNotEmpty_MyArrayListTest(){
        cars.add("Benz");
        assertFalse(cars.isEmpty());
    }

    @Test
    public void addXY_getSizeReturnsTwo_MyArrayListTest(){
        cars.add("Benz");
        cars.add("Toyota");
        assertEquals(2, cars.size());
    }

    @Test
    public void addX_getX_ReturnCorrectResult_MyArrayListTest(){
        cars.add("Benz");
        assertEquals("Benz", cars.get(0));
    }

    @Test
    public void addXY_getY_ReturnCorrectResult_MyArrayListTest(){
        cars.add("Benz");
        cars.add("Toyota");
        assertEquals("Toyota", cars.get(1));
    }

    @Test void addXYZA_sizeIsFour_MyArrayListTest(){
        cars.add("Benz");
        cars.add("Toyota");
        cars.add("Nord");
        cars.add("IVM");
        assertEquals(4, cars.size());
    }

    @Test void addXYZA_getA_ReturnCorrectResultA_MyArrayListTest(){
        cars.add("Benz");
        cars.add("Toyota");
        cars.add("Nord");
        cars.add("IVM");
        assertEquals("IVM", cars.get(3));
    }
}
