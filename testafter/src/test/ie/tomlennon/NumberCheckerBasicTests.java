package ie.tomlennon;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberCheckerBasicTests {
    NumberChecker checker = new NumberChecker();

    /**
     * So I took a look at the code, I need to execute the if statement
     */
    @Test
    public void NumberChecker_check_if_6_in_range() {
        assertTrue(checker.ensureNumberIsIn5To9Range(6));
    }

    @Test
    public void NumberChecker_check_if_15_outside_range_expect_False() {
        assertFalse(checker.ensureNumberIsIn5To9Range(15));
    }
}
