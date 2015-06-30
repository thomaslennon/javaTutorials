package ie.tomlennon;


import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberCheckerTests {
    NumberChecker checker = new NumberChecker();

    @Test
    public void ensureNumberIsIn5To9Range_Checking_below_lower_boundary_ReturnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(2));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_lower_boundary_ReturnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(5));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_between_bounds_returnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(7));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_upperboundary_returnTrue(){
        assertTrue(checker.ensureNumberIsIn5To9Range(9));
    }

    @Test
    public void ensureNumberIsIn5To9Range_Checking_above_upper_boundary_returnFalse(){
        assertFalse(checker.ensureNumberIsIn5To9Range(15));
    }


//    A test of a number less than 5. 2. returns false
//    A test of the left bound. 5. returns true
//    A test of a number in the middle of the range. 7 returns true.
//    A test of the right bound. 9. Returns true
//    A test of a number greater than 9. 11. returns false

}
