package Service;

import Utils.AddressInfo;
import Utils.IMapper;
import Utils.JsonObj;

public class AddressMapper implements IMapper<AddressInfo> {
    @Override
    public AddressInfo map(JsonObj jsonObj) {
        return new AddressInfo(
                jsonObj.getSourceAddress(),
                jsonObj.getDestAddress()
        );
    }
}
