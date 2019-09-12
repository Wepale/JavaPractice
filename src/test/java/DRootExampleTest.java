import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DRootExampleTest {
    @Test
    public void Tests() {
        assertEquals(Integer.valueOf(7), Kata.digitalRoot(16));
        assertEquals(Integer.valueOf(6), Kata.digitalRoot(456));
        assertEquals(Integer.valueOf(6), Kata.digitalRoot(942));
        assertEquals(Integer.valueOf(6), Kata.digitalRoot(942));
        assertEquals(Integer.valueOf(6), Kata.digitalRoot(132189));
        assertEquals(Integer.valueOf(2), Kata.digitalRoot(493193));
    }
}
