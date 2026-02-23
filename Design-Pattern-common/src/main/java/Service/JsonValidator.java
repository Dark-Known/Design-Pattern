package Service;

import Utils.JsonObj;


// TODO: Implement centralized validation for JsonObj fields
//  (null checks, mandatory fields, format constraints).
//  This will replace duplicated validation logic across processors/validators.


public class JsonValidator {

    public void validate(JsonObj jsonobj)
    {
        if(jsonobj==null)
        {
            throw new IllegalArgumentException("Invalid Json Object");
        }
    }
}
