package InformationObject;

public class UserInfo {
    private final String userName;
    private final String userAddress;


    public UserInfo(String userName, String userAddress) {
        this.userName = userName;
        this.userAddress = userAddress;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public String getUserAddress(){
        return this.userAddress;
    }
}
