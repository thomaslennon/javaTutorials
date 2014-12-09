package com.ericsson.bash;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BashFileFilterTest {

    BashFileFilter bashFileFilter = new BashFileFilter();

    @Test
    public void accept_passingInBashFiles_expectTrue(){
        File bashScript = new File("c:\\some\\enm.sh");
        File bashLib = new File("c:\\some\\enm.lib");
        assertTrue(bashFileFilter.accept(bashScript));
        assertTrue(bashFileFilter.accept(bashLib));
    }

    @Test
    public void accept_passingInTextFiles_ExpectFalse(){
        File textFile = new File("c:\\someDir\\myTextFile.txt");
        assertFalse(bashFileFilter.accept(textFile));
        File logFile = new File("c:\\someDir\\myTextFile.log");
        assertFalse(bashFileFilter.accept(logFile));

    }
}