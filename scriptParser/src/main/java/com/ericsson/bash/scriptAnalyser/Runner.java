package com.ericsson.bash.scriptAnalyser;


import java.util.Collection;


/**
 * arg is a list of files
 */
public final class Runner {

    public static void main(String parameters[]){
        for(String parameter : parameters){
            System.out.println(parameter);
            BashScriptParser parser = new BashScriptParser();
            parser.readScript(parameter);
            printCollection("Functions", parser.getFunctions());
            printCollection("Included Files", parser.getIncludedFiles());
        }

    }


    static void printCollection(String whatToPrint, Collection<String> collection){
        System.out.println(whatToPrint);
        for(String string : collection){
            System.out.println(string);
        }
    }


}

