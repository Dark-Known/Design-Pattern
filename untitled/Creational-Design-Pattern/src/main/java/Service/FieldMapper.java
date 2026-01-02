package Service;

import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureInfo;
import InformationObject.AddressInfo;
import InformationObject.CargoInfo;
import InformationObject.JsonObj;
import InformationObject.UserInfo;

public class FieldMapper {
    private CargoInfo cargoInfoObj;
    private AddressInfo addressInfoObj;
    private  FurnitureInfo furnitureInfoObj;
    private UserInfo userInfoObj;
    private boolean isSet=false;

    private final JsonObj jsonObj;


    public FieldMapper(JsonObj jsonObj)
    {
       this.jsonObj= jsonObj;
    }
    private void mapFurnitureInfoObj(String familyName)
    {
        FamilySelector familySelector = new FamilySelector(familyName);
        this.furnitureInfoObj = familySelector.getFamilyInfo();
    }

    private void mapCargoInfoObj()
    {
        String cargoName = jsonObj.getCargo();
        String[] splitArr = cargoName.split(" ");
        String familyName = splitArr[0];
        mapFurnitureInfoObj(familyName);
        this.cargoInfoObj= new CargoInfo(jsonObj.getTransportMode(),jsonObj.getCargo(),
                jsonObj.getDistance(), furnitureInfoObj);
    }

    private void mapUserInfoObj()
    {
        userInfoObj= new UserInfo(jsonObj.getUserName(), jsonObj.getUserAddress());
    }

    private void mapAddressInfoObj()
    {
        addressInfoObj = new AddressInfo(jsonObj.getSourceAddress(), jsonObj.getDestAddress());
    }


    public void map() throws Exception
    {
        if(!this.IsSet()){
        mapCargoInfoObj();
        mapAddressInfoObj();
        mapUserInfoObj();
        isSet=true;
        }
        else
        {
            throw new Exception("Fields have already been mapped");
        }

    }

    private void checkSetStatus() throws IllegalAccessException
    {
        if(!isSet)
        {
            throw new IllegalAccessException("Use map() to map fields before accessing fields");
        }
    }

    public UserInfo getUserInfoObj() throws IllegalAccessException {
        checkSetStatus();
        return this.userInfoObj;
    }
    public AddressInfo getAddressInfoObj() throws IllegalAccessException {
        checkSetStatus();

        return this.addressInfoObj;
    }
    public CargoInfo getCargoInfoObj() throws IllegalAccessException {
        checkSetStatus();

        return this.cargoInfoObj;
    }
    public FurnitureInfo getFurnitureInfoObj() throws IllegalAccessException {
        checkSetStatus();

        return this.furnitureInfoObj;
    }


    public boolean IsSet(){
        return this.isSet;
    }



}
