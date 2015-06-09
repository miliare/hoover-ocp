package fr.xebia.xke.solid.ocp;

import static junit.framework.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

public class HooverTest {

//    @Ignore
    @Test public void
    should_mow() {
        Hoover hoover = new Hoover("ADAAAGADA");

        hoover.clean();

        assertEquals(4, hoover.getPosition().x);
        assertEquals(2, hoover.getPosition().y);
    }

    @Ignore
    @Test public void
    should_go_backward() {
        Hoover hoover = new Hoover("ADAAAGADR");

        hoover.clean();

        assertEquals(2, hoover.getPosition().x);
        assertEquals(2, hoover.getPosition().y);
    }

    @Ignore
    @Test public void
    should_go_use_semi_orientation() {
        Hoover hoover = new Hoover("ADAAAGADR");

        hoover.clean();

        assertEquals(2, hoover.getPosition().x);
        assertEquals(4, hoover.getPosition().y);
    }
}
