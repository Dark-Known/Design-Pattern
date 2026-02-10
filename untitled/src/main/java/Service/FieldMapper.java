package Service;


import Utils.*;

public class FieldMapper {
    private final String transportMode;
    private final int distance;
    private final String cargo;
    private final String userName;
    private final String userAddress;
    private final String sourceAddress;
    private final String destAddress;
    private final JsonObj jsonObj;


    public FieldMapper(JsonObj jsonObj)
    {

        this.jsonObj= jsonObj;
        this.transportMode = jsonObj.getTransportMode();
        this.distance = jsonObj.getDistance();
        this.cargo = jsonObj.getCargo();
        this.userName = jsonObj.getUserName();
        this.userAddress = jsonObj.getUserAddress();
        this.sourceAddress = jsonObj.getSourceAddress();
        this.destAddress = jsonObj.getDestAddress();
    }
    private FurnitureInfo mapFunritureInfoObj(String familyName)
    {
        ExtractFamilyInfo extractFamilyInfo = new ExtractFamilyInfo();
        return extractFamilyInfo.getInfo(familyName);
    }

    private CargoInfo mapCargoInfoObj()
    {
        CargoParser cargoParser= new CargoParser(cargo);
        return new CargoInfo(
                transportMode,
                cargo,
                distance,
                mapFunritureInfoObj(cargoParser.getFamilyName())
        );
    }

    private UserInfo mapUserInfoObj()
    {
        return new UserInfo(userName, userAddress);
    }

    private AddressInfo mapAddressInfoObj()
    {
        return new AddressInfo(sourceAddress, destAddress);
    }


    public DomainObj map()
    {
        return new DomainObj(
                mapUserInfoObj(),
                mapAddressInfoObj(),
                mapCargoInfoObj(),
                mapCargoInfoObj().getFurnitureInfoObj()
        );
    }




}
