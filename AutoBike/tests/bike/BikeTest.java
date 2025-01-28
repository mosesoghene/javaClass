package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    private Bike bike;

    @BeforeEach
    public void intialize(){
        bike = new Bike();
    }

    @Test
    public void newBikeIsOff_bikeTest(){
        assertFalse(bike.isOn());
    }

    @Test
    public void newBikeTurnedOn_bikeIsOn_bikeTest(){
        bike.turnOn();
        assertTrue(bike.isOn());
    }

    @Test
    public void newBikeTurnedOn_bikeIsOn_newBikeTurnedOff_bikeIsOff_bikeTest(){
        bike.turnOn();
        assertTrue(bike.isOn());
        bike.turnOff();
        assertFalse(bike.isOn());
    }

    @Test
    public void newBikeGetSpeed_speedNull_bikeTest(){
        assertNull(bike.speed());
    }

    @Test
    public void newBikeTurnedOn_getSpeed_speedZero_bikeTest(){
        bike.turnOn();
        assertEquals(0, bike.speed());
    }

    @Test
    public void newBikeTurnedOn_accelerate_getSpeed_speedOne_bikeTest(){
        bike.turnOn();
        bike.accelerate();
        assertEquals(1, bike.speed());
    }

    @Test
    public void newBikeTurnedOn_accelerate21Times_getSpeed_speed24_gear2_bikeTest(){
        bike.turnOn();
        assertEquals(0, bike.speed());
        for (int i = 0; i < 22; i++) bike.accelerate();
        assertEquals(24, bike.speed());
        assertEquals(2, bike.gear());
    }

    @Test
    public void newBikeTurnedOn_accelerate25Times_getSpeed_speed21_gear3_bikeTest(){
        bike.turnOn();
        assertEquals(0, bike.speed());
        for (int i = 0; i < 25; i++) bike.accelerate();
        assertEquals(30, bike.speed());
        assertEquals(3, bike.gear());
    }

    @Test
    public void newBikeTurnedOn_accelerate29Times_getSpeed_speed42_gear4_bikeTest(){
        bike.turnOn();
        assertEquals(0, bike.speed());
        for (int i = 0; i < 29; i++) bike.accelerate();
        assertEquals(42, bike.speed());
        assertEquals(4, bike.gear());
    }
}
