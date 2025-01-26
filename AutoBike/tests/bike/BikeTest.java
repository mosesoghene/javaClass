package bike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
