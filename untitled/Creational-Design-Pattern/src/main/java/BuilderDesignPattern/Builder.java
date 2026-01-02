package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;

public interface Builder<T> {
//    public Builder<T> reset();
    public Builder<T> setTransportType(String transportType);
    public Builder<T> setDistanceInfo(int distanceInfo);
    public Builder<T> setCargoInfo(FurnitureInfo furnitureInfo,String cargoName);
    public Builder<T> setUserName(String userName);
    public Builder<T> setUserAddress(String userAddress);
    public Builder<T> setSourceAddress(String sourceAddress);
    public Builder<T> setDestAddress(String destAddress);
    public Builder<T> setTimeStamp(String timeStamp);
    public T build();


}
