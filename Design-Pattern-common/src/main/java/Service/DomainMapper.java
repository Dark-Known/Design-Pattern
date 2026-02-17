package Service;


import Utils.*;

public class DomainMapper {
    private final UserMapper userMapper;
    private final  AddressMapper addressMapper;
    private final CargoInfoMapper cargoInfoMapper;


    public DomainMapper(UserMapper userMapper, AddressMapper addressMapper,
                        CargoInfoMapper cargoInfoMapper)
    {
        this.userMapper=userMapper;
        this.addressMapper=addressMapper;
        this.cargoInfoMapper=cargoInfoMapper;

    }
    private CargoInfo mapCargoInfoObj(JsonObj jsonObj)
    {
        return cargoInfoMapper.map(jsonObj);
    }

    private UserInfo mapUserInfoObj(JsonObj jsonObj)
    {
        return userMapper.map(jsonObj);
    }

    private AddressInfo mapAddressInfoObj(JsonObj jsonObj)
    {
        return addressMapper.map(jsonObj);
    }


    public DomainObj map(JsonObj jsonObj)
    {
        return new DomainObj(
                mapUserInfoObj(jsonObj),
                mapAddressInfoObj(jsonObj),
                mapCargoInfoObj(jsonObj),
                mapCargoInfoObj(jsonObj).getFurnitureInfoObj()
        );
    }




}
