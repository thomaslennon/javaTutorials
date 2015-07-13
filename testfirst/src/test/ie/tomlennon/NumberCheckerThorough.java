package ie.tomlennon;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberCheckerThorough {
    NumberChecker checker = new NumberChecker();

    @Test
    public void ensureNumberIsIn5To9Range_Checking_immediately_below_5_ReturnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(4));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_immediately_above_5_ReturnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(6));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_immediately_below_9_ReturnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(8));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_immediately_above_9_ReturnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(10));
    }
}
