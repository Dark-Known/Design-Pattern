package Service;

import Utils.ErrorList;

public class AddressValidator implements IFieldValidator {

    private static final AddressValidator VALIDATOR_INSTANCE= new AddressValidator();

    public static AddressValidator getInstance()
    {
        return AddressValidator.VALIDATOR_INSTANCE;
    }

    @Override
    public <T> ErrorList validateFormat(String fieldName, T fieldValue) {
        //TODO: Replace String Address with Address Object in Json
        // Then Implement Validation Logic here
        return null;
    }

    @Override
    public <T> ErrorList validateValue(String fieldName, T fieldValue) {
        // We can use value validator logic from Text Field Validator
      TextFieldValidator textFieldValidator = TextFieldValidator.getInstance();
      return textFieldValidator.validateValue(fieldName, fieldValue);
    }

    @Override
    public <T> ErrorList isValid(String fieldName, T fieldValue) {

        ErrorList errorListForValue=validateValue(fieldName, fieldValue);

        // Ternary Operator to counter null from validateFormat
        ErrorList errorListForFormat=validateFormat(fieldName,fieldValue)==null?
                ErrorList.empty(): validateFormat(fieldName,fieldValue);

        return errorListForFormat.mergeList(errorListForValue.getResultList());
    }
}
