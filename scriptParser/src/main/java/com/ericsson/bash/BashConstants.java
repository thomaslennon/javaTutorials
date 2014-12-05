package com.ericsson.bash;

import java.util.StringTokenizer;

public final class BashConstants {
    public static final String INCLUDES = ". ";
    public static final String FUNCION_NAME = "function ";

    public static boolean isLineAFunction(String lineOfCode){
        return lineOfCode.regionMatches(true, 0, FUNCION_NAME, 0, FUNCION_NAME.length());
    }

    public static boolean isLineAnIncludes(String lineOfCode){
        return lineOfCode.regionMatches(true, 0, INCLUDES, 0, INCLUDES.length());
    }

    public static boolean isLineAGlobalVariable(String lineOfCode){
        return false;
    }

    public static String trimFunctionName(String functionLine){
        StringTokenizer tokenizer = new StringTokenizer(functionLine, " ");
        tokenizer.nextToken();
        return tokenizer.nextToken();
    }

    public static String trimIncludesFileName(String importLine){
        StringTokenizer tokenizer = new StringTokenizer(importLine, " ");
        tokenizer.nextToken();
        return tokenizer.nextToken();
    }

    public static String trimGlobalVariable(String globalVariableLine){
        StringTokenizer tokenizer = new StringTokenizer(globalVariableLine, "=");
        return tokenizer.nextToken();
    }
}
