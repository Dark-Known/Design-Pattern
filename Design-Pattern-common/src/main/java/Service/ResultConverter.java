package Service;

import Utils.ErrorList;
import Utils.ErrorType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultConverter {

    public List<String> getFailureMessage(ErrorList errorList)
    {
        return extractMessages(errorList,ErrorType.FAILURE);
    }


    public List<String> extractMessages(ErrorList errorList, ErrorType resultType)
    {

        List<String> MessageList = new ArrayList<>();
        errorList.getResultList().forEach(
                (validationResult)->{
                    if(validationResult.getType()==resultType)
                    {
                        MessageList.add(validationResult.getMessage());
                    }
                }
        );
        return Collections.unmodifiableList(MessageList);

    }

    public List<String> getLoggableMessages(ErrorList errorList)
    {
        List<String> MessageList = new ArrayList<>();
        errorList.getResultList().forEach(
                (validationResult)->{
                        MessageList.add(validationResult.toString());

                }
        );
        return Collections.unmodifiableList(MessageList);

    }
    public List<String> getLoggableMessageByType(ErrorList errorList, ErrorType resultType)
    {
        List<String> MessageList = new ArrayList<>();
        errorList.getResultList().forEach(
                (validationResult)->{
                    if(validationResult.getType()==resultType)
                    {
                        MessageList.add(validationResult.toString());
                    }
                }
        );
        return Collections.unmodifiableList(MessageList);

    }
}

