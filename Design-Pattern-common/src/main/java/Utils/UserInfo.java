package Utils;

public class UserInfo {
    private final String userName;
    private final String userAddress;


    public UserInfo(String userName, String userAddress) {
        validateUserName(userName);
        validateUserAddress(userAddress);

        this.userName = userName;
        this.userAddress = userAddress;
    }

    private void validateUserName(String userName)
    {
        if(userName==null || userName.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid User Name");
        }
    }

    private void validateUserAddress(String userAddress)
    {
        if(userAddress==null || userAddress.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid User Address");
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserAddress() {
        return this.userAddress;
    }
}
