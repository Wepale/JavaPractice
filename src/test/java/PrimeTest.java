import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeTest {
    @Test
    public void testBasic() {
        assertFalse(Kata.isPrime(0), "0  is not prime");
        assertFalse(Kata.isPrime(1), "1  is not prime");
        assertTrue(Kata.isPrime(2), "2  is prime");
        assertTrue(Kata.isPrime(73), "73 is prime");
        assertFalse(Kata.isPrime(75), "75 is not prime");
        assertFalse(Kata.isPrime(-1), "-1 is not prime");
    }

    @Test
    public void testPrime() {
        assertTrue(Kata.isPrime(3), "3 is prime");
        assertTrue(Kata.isPrime(5), "5 is prime");
        assertTrue(Kata.isPrime(7), "7 is prime");
        assertTrue(Kata.isPrime(41), "41 is prime");
        assertTrue(Kata.isPrime(5099), "5099 is prime");
    }

    @Test
    public void testNotPrime() {
        assertFalse(Kata.isPrime(4), "4 is not prime");
        assertFalse(Kata.isPrime(6), "6 is not prime");
        assertFalse(Kata.isPrime(8), "8 is not prime");
        assertFalse(Kata.isPrime(9), "9 is not prime");
        assertFalse(Kata.isPrime(45), "45 is not prime");
        assertFalse(Kata.isPrime(-1), "-5 is not prime");
        assertFalse(Kata.isPrime(-1), "-8 is not prime");
        assertFalse(Kata.isPrime(-1), "-41 is not prime");
    }
}
