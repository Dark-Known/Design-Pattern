package Service;

import Utils.ErrorList;
import Utils.JsonObj;

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

    private ErrorList validateTextFields(JsonObj jsonObj)
    {

        //TODO: We need to implement ways to collect all errors from various text fields
        ErrorList errorList=ErrorList.of(textFieldValidator.
                isValid("Transport Mode",jsonObj.getTransportMode()).
                getResultList());

        return errorList.mergeList(textFieldValidator.
                isValid("Cargo Name",jsonObj.getCargo()).
                getResultList());

    }

    private
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
