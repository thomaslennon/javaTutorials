package ie.tomlennon;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberCheckerTests {
    NumberChecker checker = new NumberChecker();

    @Test
    public void ensureNumberIsIn5To9Range_Checking_below_5_ReturnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(2));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_5_ReturnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(5));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_between_5_and_9_returnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(7));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_checking_9_returnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(9));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_above_9_returnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(15));
    }
}
