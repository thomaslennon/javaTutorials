package com.ericsson.bash.loc;


public final class LocCounter {

    public static int countLocInFile(String fileName){
        return 0;
    }

    public static void main(String filenames[]){
        int runningTotal = 0;
        for(String filename : filenames){
            int localTotal = countLocInFile(filename);
            System.out.println("Size: " + localTotal + " File: " + filename);
            runningTotal += localTotal;
        }
        System.out.println("Total Size: " + runningTotal );
    }

}
