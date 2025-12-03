package org.example;

import java.time.Instant;

public class CurrentTimeService {
    public static String getNow(){
        String timeStamp= Instant.now().toString();
        String[] tempSplitArr=timeStamp.split("T");
        String tempTimeStamp= tempSplitArr[1];
        String[] tempSplitArr1= tempTimeStamp.split("\\.");
        return getDate()+" "+tempSplitArr1[0];
    }
    public static String getDate(){
        String timeStamp= Instant.now().toString();
        String[] tempSplitArr=timeStamp.split("T");
        return tempSplitArr[0];
    }

}
