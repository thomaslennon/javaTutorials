package com.ericsson.bash.scriptAnalyser;

import com.ericsson.bash.BashConstants;
import com.ericsson.srcfiles.file.TextFileLineReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public final class BashScriptParser {

    private Collection<String> functions;
    private Collection<String> importedFiles;

    public BashScriptParser() {
        functions = new HashSet<>();
        importedFiles = new HashSet<>();
    }


    public void readScript(String file) {
        TextFileLineReader fileLineReader = new TextFileLineReader(file);
        Collection<String> filec = fileLineReader.fileLines();
        for (String fileLine : filec) {
            processLine(fileLine);
        }
    }

    public Collection<String> getFunctions() {
        return Collections.unmodifiableCollection(functions);
    }

    public Collection<String> getIncludedFiles() {
        return Collections.unmodifiableCollection(importedFiles);
    }

    private void processLine(String lineOfCode) {
        if (BashConstants.isLineAFunction(lineOfCode)) {
            String name = BashConstants.trimFunctionName(lineOfCode);
            functions.add(name);
        }
        if (BashConstants.isLineAnIncludes(lineOfCode)) {
            String importFile = BashConstants.trimIncludesFileName(lineOfCode);
            importedFiles.add(importFile);
        }
    }

}
