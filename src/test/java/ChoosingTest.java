import org.junit.Test;

import static org.junit.Assert.*;

public class ChoosingTest {

    @Test
    public void cin() {
        Choosing choes = new Choosing();
        String actual = choes.cin(3);
        String expected = "This function isn't existing yet :(";
        assertEquals(expected, actual);
    }
}