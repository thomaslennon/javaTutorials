package com.ericsson.srcfiles.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public final class TextFileLineReader {
    //Hold the file in memory as a collection of strings
    Collection<String> file = new ArrayList<>();

    public TextFileLineReader(final String textfileName) {
        Path fileName = FileSystems.getDefault().getPath(textfileName);
        try {
            BufferedReader reader = Files.newBufferedReader(fileName, Charset.defaultCharset());
            while (reader.ready()) {
                String line = reader.readLine();
                file.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countLines() {
        return file.size();
    }

    public Collection<String> fileLines(){
        return Collections.unmodifiableCollection(file);
    }

}
