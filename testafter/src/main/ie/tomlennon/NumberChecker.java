package ie.tomlennon;

public class NumberChecker{
    public boolean ensureNumberIsIn5To9Range(final int numberToTest){
        if(numberToTest >= 5 && numberToTest <= 10){
            return true;
        }
        return false;
    }
}
