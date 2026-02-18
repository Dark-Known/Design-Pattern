package Utils;

public class DomainObj implements IGetObj {


    private final UserInfo userInfoObj;
    private final AddressInfo addressInfoObj;
    private final CargoInfo cargoInfoObj;
    private final FurnitureInfo furnitureInfoObj;

    public DomainObj(UserInfo userInfoObj, AddressInfo addressInfoObj,
                     CargoInfo cargoInfoObj, FurnitureInfo furnitureInfoObj) {
        this.userInfoObj = userInfoObj;
        this.addressInfoObj = addressInfoObj;
        this.cargoInfoObj = cargoInfoObj;
        this.furnitureInfoObj = furnitureInfoObj;
    }

    @Override
    public UserInfo getUserInfo() {
        return this.userInfoObj;

    }

    @Override
    public AddressInfo getAddressInfoObj() {
        return this.addressInfoObj;
    }

    @Override
    public CargoInfo getCargoInfoObj() {
        return this.cargoInfoObj;
    }

    @Override
    public FurnitureInfo getFurnitureInfoObj() {
        return this.furnitureInfoObj;
    }
}
