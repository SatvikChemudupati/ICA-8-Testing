import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void goodString() {
        assertEquals(false, urinals.goodString("satv"));
    }


    @org.junit.jupiter.api.Test
    void countUrinalsTest() {
        assertEquals( 1 , urinals.count_method("10001"));
        assertEquals( 0 , urinals.count_method("1001"));
        assertEquals( 3 , urinals.count_method("00000"));
        assertEquals( 2 , urinals.count_method("0000"));
        assertEquals( 1 , urinals.count_method("01000"));
    }

}