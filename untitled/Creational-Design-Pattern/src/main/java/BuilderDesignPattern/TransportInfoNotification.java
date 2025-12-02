package BuilderDesignPattern;


import java.sql.Time;

public class TransportInfoNotification {
    private String timeStamp;
    private String userName;
    private String userAddress;
    private String transportType;
    private String sourceAddress;
    private String destAddress;

    private int distanceInfo;

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp=timeStamp;
    }

    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public void setUserAddress(String userAddress)
    {
        this.userAddress=userAddress;
    }
    public void setTransportType(String transportType)
    {
        this.transportType=transportType;
    }

    public void setSourceAddress(String sourceAddress)
    {
        this.sourceAddress=sourceAddress;
    }
    public void setDestAddress(String destAddress)
    {
        this.destAddress=destAddress;
    }
    public void setDistanceInfo(int distanceInfo)
    {
        this.distanceInfo=distanceInfo;
    }

    @Override
    public String toString(){
        return " "+'\n'+"{"+'\n'+ "Time Stamp :" + timeStamp+'\n'+
                "User Name :"+userName+'\n'+
                "User Address :"+userAddress +'\n'+
                "transportType :"+ transportType+'\n'+
                "distanceInfo :"+ distanceInfo + '\n' +
                "Source Address :"+sourceAddress+'\n'+
                "Destination Address :"+destAddress+'\n'+
                "}" +'\n';

    }
}



