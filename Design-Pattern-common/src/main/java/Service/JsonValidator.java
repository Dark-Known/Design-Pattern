package Service;

import Utils.JsonObj;
import Utils.ValidationResult;

public class JsonValidator {
    private final TextFieldValidator textFieldValidator;
    private final AddressValidator addressValidator;

    JsonValidator(TextFieldValidator textFieldValidator, AddressValidator addressValidator)
    {
        this.addressValidator=addressValidator;
        this.textFieldValidator =textFieldValidator;
    }
    private static final JsonValidator VALIDATOR_INSTANCE=new JsonValidator(
            TextFieldValidator.getInstance(),
            AddressValidator.getInstance()
    );

    public JsonValidator getInstant()
    {
        return VALIDATOR_INSTANCE;
    }



    public void validate(JsonObj jsonObj)
    {

    }
    private final String transportMode;
    private final int distance;
    private final String cargo;
    private final String userName;
    private final String userAddress;
    private final String sourceAddress;
    private final String destAddress;



    private void validateTextFields(JsonObj jsonObj)
    {
        textFieldValidator.isValid("Transport Mode",)
    }
    private void validateAddressFields()
    {

    }
    private void validateDistanceFields()
    {

    }
    private void validateCrossLinkedFields()
    {

    }
}
