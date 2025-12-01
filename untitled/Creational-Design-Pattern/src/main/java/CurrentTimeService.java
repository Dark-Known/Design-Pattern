import java.time.Instant;

public class CurrentTimeService {
    public static String getNow(){
        String timeStamp= Instant.now().toString();
        String[] tempSplitArr=timeStamp.split("T");
        String tempTimeStamp= tempSplitArr[1];
        String[] tempSplitArr1= tempTimeStamp.split("\\.");
        return tempSplitArr1[1];
    }

}
