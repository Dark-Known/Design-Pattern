package BuilderDesignPattern;

import AbstractFactoryDesignPattern.FurnitureInfo;

public class CargoInfoNotification {
    private String timeStamp;
    private String transportType;
    private int distanceInfo;
    private FurnitureInfo furnitureInfo;
    private String cargoName;
    private String userName;
    private String userAddress;

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp=timeStamp;
    }
    public void setTransportType(String transportType)
    {
        this.transportType=transportType;
    }
    public void setCargoInfo(FurnitureInfo furnitureInfo,String cargoName)
    {
        this.furnitureInfo = furnitureInfo;
        this.cargoName=cargoName;
    }
    public void setDistanceInfo(int distanceInfo)
    {
        this.distanceInfo=distanceInfo;
    }
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public void setUserAddress(String userAddress)
    {
        this.userAddress=userAddress;
    }

    @Override
    public String toString(){
        return " "+'\n'+"{"+'\n'+ "Time Stamp :"+ timeStamp+'\n'+
                "User Name :"+userName+'\n'+
                "User Address :"+userAddress +'\n'+
                "transportType :"+ transportType+'\n'+
                "distanceInfo :"+ distanceInfo + '\n' +
                "Cargo Name :"+cargoName+'\n'+
                "Manufacturer Name :"+furnitureInfo.getManfName()+'\n'+
                "Manufacturer Address :"+furnitureInfo.getManfAddress()+'\n'+
                "Manufacture Date :"+furnitureInfo.getManfDate()+'\n'+
                "Material Used :"+furnitureInfo.getMaterialUsed()+'\n'+
                "}" +'\n';

    }
}
