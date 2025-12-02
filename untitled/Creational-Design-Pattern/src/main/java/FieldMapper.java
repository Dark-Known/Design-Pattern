import AbstractFactoryDesignPattern.FamilySelector;
import AbstractFactoryDesignPattern.FurnitureInfo;

public class FieldMapper {
    private  CargoInfo cargoInfoObj;
    private  AddressInfo addressInfoObj;
    private  FurnitureInfo furnitureInfoObj;
    private UserInfo userInfoObj;
    private boolean isSet=false;

    private final JsonObj jsonObj;


    FieldMapper(JsonObj jsonObj)
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
        this.cargoInfoObj= new CargoInfo(jsonObj.getCargo(), furnitureInfoObj);
    }

    private void mapUserInfoObj()
    {
        userInfoObj= new UserInfo(jsonObj.getUserName(), jsonObj.getUserAddress());
    }

    private void mapAddressInfoObj()
    {
        addressInfoObj = new AddressInfo(jsonObj.getSourceAddress(), jsonObj.getDestAddress());
    }


    public void map()
    {
        mapCargoInfoObj();
        mapAddressInfoObj();
        mapUserInfoObj();
        isSet=true;
    }

    public UserInfo getUserInfoObj(){
        return this.userInfoObj;
    }
    public AddressInfo getAddressInfoObj()
    {
        return this.addressInfoObj;
    }
    public CargoInfo getCargoInfoObj()
    {
        return this.cargoInfoObj;
    }
    public FurnitureInfo getFurnitureInfoObj()
    {
        return this.furnitureInfoObj;
    }


    public boolean IsSet(){
        return this.isSet;
    }



}
