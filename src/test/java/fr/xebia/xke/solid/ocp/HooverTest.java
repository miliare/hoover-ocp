package fr.xebia.xke.solid.ocp;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HooverTest {

    @Test
    public void
    should_mow() {
        Hoover hoover = new Hoover("ADAAAGADA");
        hoover.clean();

        assertEquals(4, hoover.getPosition().x);
        assertEquals(2, hoover.getPosition().y);
    }
}
