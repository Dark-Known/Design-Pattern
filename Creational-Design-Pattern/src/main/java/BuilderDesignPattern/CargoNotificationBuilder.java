package BuilderDesignPattern;

import Utils.Builder;
import Utils.CargoInfoNotification;
import Utils.FurnitureInfo;

public class CargoNotificationBuilder implements Builder<CargoInfoNotification> {
    private String transportType;
    private int distanceInfo;
    private FurnitureInfo furnitureInfo;
    private String cargoName;
    private String userName;
    private String userAddress;
    private String timeStamp;

//    @Override
//    public Builder<CargoInfoNotification> reset() {
//        new CargoInfoNotification();
//        return this;
//    }

    @Override
    public Builder<CargoInfoNotification> setTransportType(String transportType) {
        this.transportType = transportType;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setDistanceInfo(int distanceInfo) {
        this.distanceInfo = distanceInfo;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setCargoInfo(FurnitureInfo furnitureInfo, String cargoName) {
        this.furnitureInfo = furnitureInfo;
        this.cargoName = cargoName;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setUserAddress(String userAddress) {
        this.userAddress = userAddress;
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setSourceAddress(String sourceAddress) {
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setDestAddress(String destAddress) {
        return this;
    }

    @Override
    public Builder<CargoInfoNotification> setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    private void validateTransportType() {
        if (transportType == null || transportType.trim().isEmpty()) {
            throw new IllegalStateException("Invalid Transport Type");
        }

    }

    private void validateDistanceInfo() {
        if (distanceInfo < 10) {
            throw new IllegalStateException("Invalid Distance Information");
        }

    }

    private void validateCargoName() {
        if (cargoName == null || cargoName.trim().isEmpty()) {
            throw new IllegalStateException("Invalid Cargo Name");
        }
    }

    private void validateFurnitureInfo() {
        if (furnitureInfo == null) {
            throw new IllegalStateException("Invalid Furniture Information");
        }
    }

    private void validateUserName() {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalStateException("Invalid User Name");
        }

    }

    private void validateUserAddress() {
        if (userAddress == null || userAddress.trim().isEmpty()) {
            throw new IllegalStateException("Invalid User Address");
        }

    }

    private void validateTimeStamp() {
        if (timeStamp == null || timeStamp.trim().isEmpty()) {
            throw new IllegalStateException("Invalid Time Stamp");
        }
    }


    public CargoInfoNotification build() {
        validateTransportType();
        validateDistanceInfo();
        validateCargoName();
        validateFurnitureInfo();
        validateUserName();
        validateUserAddress();
        validateTimeStamp();
        CargoInfoNotification notification = new CargoInfoNotification();
        notification.setTransportType(this.transportType);
        notification.setDistanceInfo(this.distanceInfo);
        notification.setCargoInfo(this.furnitureInfo, this.cargoName);
        notification.setUserName(this.userName);
        notification.setUserAddress(this.userAddress);
        notification.setTimeStamp(this.timeStamp);
        return notification;
    }
}
