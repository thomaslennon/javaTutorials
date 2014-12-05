package com.ericsson.bash;

import org.junit.Before;

import java.util.Collection;

import static org.junit.Assert.*;

public class BashScriptParserTest {
    BashScriptParser parser = null;

    String functionsNames[] = {
        "enm.spinner()", "enm.checkplan()"
    };

    String libraries[] = {
        "${ENMINST_HOME}/lib/logger.lib"
    };

    @Before
    public void parseAScript(){
        parser = new BashScriptParser();
    }

    @org.junit.Test
    public void readScript_fileExists_fileRead() throws Exception {
        parser.readScript("C:\\repos\\github\\javaTutorials\\scriptParser\\target\\test-classes\\enm.sh");
        Collection<String> functions = parser.getFunctions();
        assertEquals(functions.size(), functionsNames.length);
        Collection<String> includes = parser.getImportedFiles();
        assertEquals(includes.size(), libraries.length);
    }

}