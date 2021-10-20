import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChoosingTest {

    @Test
    public void cin() throws IOException {
        Choosing choes = new Choosing();
        String actual = choes.cin(3);
        String expected = "This function isn't existing yet :(";
        assertEquals(expected, actual);
    }
}