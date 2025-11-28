package BuilderDesignPattern;

public interface Builder {
    public Builder reset();
    public Builder setTransportType();
    public Builder setDistanceInfo();
    public Builder setCargoInfo();
    public Builder setUserName();
    public Builder setUserAddress();
    public Builder setSourceAddress();
    public Builder setDestAddress();
    public Builder setTimeStamp();

}
