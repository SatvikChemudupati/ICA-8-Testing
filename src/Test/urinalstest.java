import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void goodString() {
        assertFalse(urinals.goodString("satv"));
    }


    @org.junit.jupiter.api.Test
    void countUrinalsTest() {
        assertEquals( 1 , urinals.count_method("10001"));
        assertEquals( 0 , urinals.count_method("1001"));
        assertEquals( 3 , urinals.count_method("00000"));
        assertEquals( 2 , urinals.count_method("0000"));
        assertEquals( 1 , urinals.count_method("01000"));
        assertEquals( 0 , urinals.count_method("01010"));
        assertEquals( 1 , urinals.count_method("01000"));
        assertEquals( -1 , urinals.count_method("01011"));
        assertEquals( 0 , urinals.count_method("01010"));

    }

    @org.junit.jupiter.api.Test
    void checkFileCreation() {
        //Checking if output file is created in case of -1/EOF/null input
        String path = "rule.txt";
        File f = new File("rule.txt");
        int count_value = 1;
        if (f.exists()) {
            System.out.println("File rule.txt exists. Checking next file");
            while (true) {
                File f1 = new File("rule" + count_value + ".txt");
                if (f1.exists() && !f1.isDirectory()) {
                    count_value += 1;
                } else {
                    path = "rule"+count_value + ".txt";
                    break;
                }
            }
        }

        File f1 = new File(path);
        assertFalse(f1.exists());
    }

}