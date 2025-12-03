public class JsonObj {
    private final String transportMode;
    private final int distance;
    private final String cargo;
    private final String userName;
    private final String userAddress;
    private final String sourceAddress;
    private final String destAddress;

    JsonObj(String transportMode, int distance, String cargo,
            String userName, String userAddress,
            String sourceAddress, String destAddress) {
        this.transportMode = transportMode;
        this.distance = distance;
        this.cargo = cargo;
        this.userName = userName;
        this.userAddress = userAddress;
        this.sourceAddress = sourceAddress;
        this.destAddress = destAddress;
    }

    public String getTransportMode() {
        return this.transportMode;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCargo() {
        return this.cargo;
    }
    public String getUserName(){
        return userName;
    }
    public String getUserAddress()
    {
        return userAddress;

    }
    public String getSourceAddress()
    {
        return sourceAddress;
    }
    public String getDestAddress()
    {
        return destAddress;
    }

}

