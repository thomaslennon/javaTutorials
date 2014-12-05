package com.ericsson.bash;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class BashScriptParser {

    private Collection<String> functions;
    private Collection<String> importedFiles;

    public BashScriptParser(){
        functions = new HashSet<>();
        importedFiles = new HashSet<>();
    }

    public void readScript(String file){
        Path bashScipt = FileSystems.getDefault().getPath(file);
        readScript(bashScipt);
    }

    public void readScript(Path bashScriptFile){
        try {
            BufferedReader reader = Files.newBufferedReader(bashScriptFile, Charset.defaultCharset());
            while(reader.ready()){
                String line = reader.readLine();
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<String> getFunctions(){
        return Collections.unmodifiableCollection(functions);
    }

    public Collection<String> getImportedFiles(){
        return Collections.unmodifiableCollection(importedFiles);
    }

    private void processLine(String lineOfCode){
        if(BashConstants.isLineAFunction(lineOfCode)){
            String name = BashConstants.trimFunctionName(lineOfCode);
            functions.add(name);
        }
        if(BashConstants.isLineAnIncludes(lineOfCode)){
            String importFile = BashConstants.trimIncludesFileName(lineOfCode);
            importedFiles.add(importFile);
        }
    }

}
