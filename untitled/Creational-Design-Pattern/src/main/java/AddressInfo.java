public class AddressInfo {
    private final String sourceAddress;
    private final String destAddress;


    public AddressInfo(String sourceAddress, String destAddress) {
        this.sourceAddress = sourceAddress;
        this.destAddress = destAddress;
    }

    public String getSourceAddress(){
        return this.sourceAddress;
    }
    public String getDestAddress(){
        return this.destAddress;
    }
}

