package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;
import com.sun.jdi.connect.Transport;

public class TransportNotificationBuilder implements Builder<TransportInfoNotification> {

//    @Override
//    public Builder<TransportInfoNotification> reset() {
//        this.notification= new TransportInfoNotification();
//        return this;
//    }
    private String transportType;
    private int distanceInfo;
    private String userName;
    private String userAddress;
    private String sourceAddress;
    private String destAddress;
    private String timeStamp;



    @Override
    public Builder<TransportInfoNotification> setTransportType(String transportType) {
        this.transportType=transportType;
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setDistanceInfo(int distanceInfo) {
        this.distanceInfo=distanceInfo;
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setCargoInfo(FurnitureInfo furnitureInfo, String cargoName) {
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setUserName(String userName) {
        this.userName=userName;
        return this;

    }

    @Override
    public Builder<TransportInfoNotification> setUserAddress(String userAddress) {
        this.userAddress=userAddress;
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setSourceAddress(String sourceAddress) {
        this.sourceAddress=sourceAddress;
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setDestAddress(String destAddress) {
        this.destAddress=destAddress;
        return this;
    }

    @Override
    public Builder<TransportInfoNotification> setTimeStamp(String timeStamp) {
        this.timeStamp=timeStamp;
        return this;
    }

    private void validateTransportType()
    {
        if(transportType.isEmpty())
        {
            throw new IllegalStateException("Transport Type cannot be null");
        }

    }
    private void validateDistanceInfo()
    {
        if(distanceInfo<10)
        {
            throw new IllegalStateException("Invalid distance Info");
        }

    }
    private void validateUserName()
    {
        if(userName.isEmpty())
        {
            throw new IllegalStateException("Invalid User Name");
        }

    }
    private void validateUserAddress()
    {
        if(userAddress.isEmpty())
        {
            throw new IllegalStateException("Invalid User Address");
        }

    }
    private void validateSourceAddress(){
        if(sourceAddress.isEmpty())
        {
            throw new IllegalStateException("Invalid source Address");
        }

    }
    private void validateDestAddress(){
        if(destAddress.isEmpty())
        {
            throw new IllegalStateException("Invalid destination Address");
        }
    }
    public TransportInfoNotification build(){
        validateTransportType();
        validateDistanceInfo();
        validateUserName();
        validateUserAddress();
        validateSourceAddress();
        validateDestAddress();
        TransportInfoNotification notification=new TransportInfoNotification();
        notification.setTransportType(this.transportType);
        notification.setDistanceInfo(this.distanceInfo);
        notification.setUserName(this.userName);
        notification.setUserAddress(this.userAddress);
        notification.setSourceAddress(this.sourceAddress);
        notification.setDestAddress(this.destAddress);
        notification.setTimeStamp(this.timeStamp);
        return notification;

    }
}
