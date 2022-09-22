package ie.lennon.tom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticOverRidingTests {
    @Test
    public void givenSuperClassAndSubClassAndIOverrideStaticMethodsWhenIReferenceObjectBySuperClassThenReturnsSuper(){
        SuperClass object = new SubClass();
        assertEquals(object.method1(), SuperClass.class.getName());
    }

    @Test
    public void givenSuperClassAndSubClassAndIOverrideStaticMethodsWhenIReferenceObjectBySubClassThenReturnsSub(){
        SubClass object = new SubClass();
        assertEquals(object.method1(), SubClass.class.getName());
    }
}
