package com.ericsson.bash.scriptAnalyser;

import java.io.File;
import java.io.FileFilter;

public final class BashFileFilter implements FileFilter {
    String bashScript = ".sh";
    String bashLibrary = ".lib";

    public boolean accept(File pathname){
        String pathString = pathname.getAbsolutePath();
        boolean bash = checkForBash(pathString);
        return bash;
    }

    private boolean checkForBash(String pathString){
        boolean bash = false;
        int indexOfExtension = pathString.lastIndexOf('.');
        if(((pathString.regionMatches(true, indexOfExtension, bashScript, 0, bashScript.length())||
            pathString.regionMatches(true, indexOfExtension, bashLibrary, 0, bashLibrary.length())))){
            bash = true;
        }
        return bash;
    }
}
