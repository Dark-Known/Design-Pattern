package BuilderDesignPattern;

import AbstractFactoryDesignPattern.CargoInfo;

public interface Builder {
    public Builder reset();
    public Builder setTransportType(String transportType);
    public Builder setDistanceInfo(int distanceInfo);
    public Builder setCargoInfo(CargoInfo cargoInfo);
    public Builder setUserName(String userName);
    public Builder setUserAddress(String userAddress);
    public Builder setSourceAddress(String sourceAddress);
    public Builder setDestAddress(String destAddress);
    public Builder setTimeStamp(String timeStamp);


}
