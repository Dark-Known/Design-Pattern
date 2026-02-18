package Utils;

public class AddressInfo {
    private final String sourceAddress;
    private final String destAddress;


    public AddressInfo(String sourceAddress, String destAddress) {
        validateSourceAddress(sourceAddress);
        validateDestAddress(destAddress);

        this.sourceAddress = sourceAddress;
        this.destAddress = destAddress;
    }
    private void validateSourceAddress(String sourceAddress){
        if(sourceAddress==null || sourceAddress.trim().isEmpty())
        {
            throw new IllegalArgumentException("Source Address is invalid");
        }
    }
    private void validateDestAddress(String destAddress)
    {
        if(destAddress==null || destAddress.trim().isEmpty())
        {
            throw new IllegalArgumentException("Destination Address is invalid");
        }
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public String getDestAddress() {
        return this.destAddress;
    }
}

