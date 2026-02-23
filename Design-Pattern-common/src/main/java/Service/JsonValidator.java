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
        fieldValidator("Transport Mode", jsonobj.getTransportMode());
        fieldValidator("Cargo Name", jsonobj.getCargo());
        fieldValidator("User Name", jsonobj.getUserName());
        fieldValidator("User Address", jsonobj.getUserAddress());
        fieldValidator("Source Address", jsonobj.getSourceAddress());
        fieldValidator("Destination Address", jsonobj.getDestAddress());
        fieldValidator("Distance Information", jsonobj.getDistance());
    }

    private void fieldValidator(String fieldName, String fieldValue)
    {
        if(fieldValue== null || fieldValue.trim().isEmpty())
        {
            throw new IllegalArgumentException("Invalid "+fieldName);
        }
    }

    private void fieldValidator(String fieldName , int fieldValue)
    {
        if(fieldValue<0)
        {
            throw new IllegalArgumentException("Invalid "+fieldName);
        }

    }
}
