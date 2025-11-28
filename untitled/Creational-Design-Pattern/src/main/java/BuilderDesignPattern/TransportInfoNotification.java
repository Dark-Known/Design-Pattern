package BuilderDesignPattern;



public class TransportInfoNotification {
    private String timeStamp;
    private String userName;
    private String transportType;
    private String transportAddress;
    private String userAddress;
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
    public void setDistanceInfo(int distanceInfo)
    {
        this.distanceInfo=distanceInfo;
    }
    public void setTransportAddress(String transportAddress)
    {
        this.transportAddress=transportAddress;
    }


}
