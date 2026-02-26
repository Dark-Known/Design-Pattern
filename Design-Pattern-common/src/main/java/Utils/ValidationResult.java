package Utils;

public class ValidationResult {
    private final String resultMessage;
    private final ErrorType errorType;

    private ValidationResult(ErrorType errorType,String resultMessage) {
        this.resultMessage = resultMessage;
        this.errorType = errorType;
    }


    // static factory method
    public static ValidationResult setSuccessMessage(String message)
    {
        return new ValidationResult(ErrorType.SUCCESS , message);
    }

    public static ValidationResult setFailureMessage(String message)
    {
        return new ValidationResult(ErrorType.FAILURE,message);
    }

    public static ValidationResult setWarningMessage(String message)
    {
        return new ValidationResult(ErrorType.WARNING, message);
    }

    public String getMessage()
    {
        return this.resultMessage;
    }
    public ErrorType getType()
    {
        return this.errorType;
    }
    public boolean isFailure()
    {
        return this.errorType==ErrorType.FAILURE;
    }
    public boolean isSuccess()
    {
        return this.errorType==ErrorType.SUCCESS;
    }

    public String toString()
    {
        return "["+errorType+"] "+resultMessage;
    }

}

