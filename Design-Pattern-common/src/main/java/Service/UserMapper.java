package Service;

import Utils.IMapper;
import Utils.JsonObj;
import Utils.UserInfo;

public class UserMapper implements IMapper<UserInfo> {
    @Override
    public UserInfo map(JsonObj jsonObj) {
        return new UserInfo(
                jsonObj.getUserName(),
                jsonObj.getUserAddress()
        );
    }
}
