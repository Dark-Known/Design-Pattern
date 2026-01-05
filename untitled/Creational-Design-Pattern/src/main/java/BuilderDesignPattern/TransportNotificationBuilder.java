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
        if( transportType==null ||transportType.trim().isEmpty())
        {
            throw new IllegalStateException("Invalid Transport Type");
        }

    }
    private void validateDistanceInfo()
    {
        if(distanceInfo<10)
        {
            throw new IllegalStateException("Invalid Distance Information");
        }

    }
    private void validateUserName()
    {
        if( userName==null || userName.trim().isEmpty() )
        {
            throw new IllegalStateException("Invalid User Name");
        }

    }
    private void validateUserAddress()
    {
        if(userAddress==null || userAddress.trim().isEmpty() )
        {
            throw new IllegalStateException("Invalid User Address");
        }

    }
    private void validateSourceAddress(){
        if(sourceAddress==null || sourceAddress.trim().isEmpty() )
        {
            throw new IllegalStateException("Invalid Source Address");
        }

    }
    private void validateDestAddress(){
        if(destAddress==null || destAddress.trim().isEmpty())
        {
            throw new IllegalStateException("Invalid Destination Address");
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
