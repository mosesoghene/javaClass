package ac;

import org.junit.Test;

import static org.junit.Assert.*;

public class AC_Test {
    @Test
    public void acIsOn_ACtest() {
        AC ac = new AC();
        ac.turnOn();
        assertTrue(ac.isOn());
    }

    @Test
    public void acIsNotOn_ACtest() {
        AC ac = new AC();
        ac.turnOn();
        assertTrue(ac.isOn());
        ac.turnOff();
        assertFalse(ac.isOn());
    }

    @Test
    public void increaseTemperature_TemperatureIncreases_ACtest() {
        AC ac = new AC();
        ac.turnOn();
        ac.increaseTemperature();
        assertEquals(17, ac.temperature());
    }
}
