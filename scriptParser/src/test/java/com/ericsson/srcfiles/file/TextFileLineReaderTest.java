package com.ericsson.srcfiles.file;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextFileLineReaderTest {
    TextFileLineReader reader;

    @Before
    public void createFile(){
        reader = new TextFileLineReader("C:\\repos\\\\github\\\\javaTutorials\\\\scriptParser\\\\target\\\\test-classes\\\\enm.sh");
    }

    @After
    public void tearDown(){
        reader = null;
    }


    @Test
    public void testCountLines() throws Exception {
        assertEquals(reader.countLines(), 54);
    }

    @Test
    public void testFileLines() throws Exception {
        assertNotNull(reader.fileLines());
    }
}