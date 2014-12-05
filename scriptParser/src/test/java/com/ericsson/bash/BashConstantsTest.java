package com.ericsson.bash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BashConstantsTest {

    String sampleFunction = "function backup_xml_template() {";
    String sampleComment = "### Function: backup_xml_template ###";
    String sampleExportVariable = "export -f  get_time";
    String sampleGlobalVariable = "ENMINST_HOME=\"/opt/ericsson/enminst/\"\n";
    String sampleIncludesLine = ". ${ENMINST_HOME}/lib/logger.lib auto";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void isLineAFunction_passingInAFunctionLine_true() throws Exception {
        assertTrue(BashConstants.isLineAFunction(sampleFunction));
    }

    @Test
    public void isLineAFunction_passingInAGlobalVariable_false() throws Exception {
        assertFalse(BashConstants.isLineAFunction(sampleComment));
        assertFalse(BashConstants.isLineAFunction(sampleGlobalVariable));
    }


    @Test
    public void isLineAnIncludes_passingIncludesLineOfCode_true() throws Exception {
        assertTrue(BashConstants.isLineAnIncludes(sampleIncludesLine));
    }

    @Test
    public void isLineAGlobalVariable_passingACommentAndGlobalVariable_false() throws Exception {
        assertFalse(BashConstants.isLineAnIncludes(sampleComment));
        assertFalse(BashConstants.isLineAnIncludes(sampleGlobalVariable));
    }

    @Test
    public void trimFunctionName_functionLineOfCode_trimmed() throws Exception {
        String functionName = BashConstants.trimFunctionName(sampleFunction);
        assertEquals(functionName, "backup_xml_template()");
    }

    @Test
    public void trimImports_IncludesLineOfCode_trimmed() throws Exception {
        String includedFile = BashConstants.trimIncludesFileName(sampleIncludesLine);
        assertEquals(includedFile, "${ENMINST_HOME}/lib/logger.lib");
    }


    @Test
    public void trimGlobalVariable_passGlobalVariableLineOfCode_success(){
        String globalVariable = BashConstants.trimGlobalVariable(sampleGlobalVariable);
        assertEquals(globalVariable, "ENMINST_HOME" );
    }

    @Test
    public void isLineAGlobalVariable_passGlobalVariableLineOfCode_success(){
        assertTrue(BashConstants.isLineAGlobalVariable(sampleGlobalVariable));
    }
    @Test
    public void isLineAGlobalVariable_passOtherlines_fail(){
        assertFalse(BashConstants.isLineAGlobalVariable(sampleIncludesLine));
        assertFalse(BashConstants.isLineAGlobalVariable(sampleComment));
    }
}