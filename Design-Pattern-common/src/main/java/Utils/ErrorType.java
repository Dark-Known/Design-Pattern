package Utils;

public enum ErrorType {
    SUCCESS(0),
    FAILURE(1),
    WARNING(2);

    final int index;

    ErrorType(int index) {
        this.index=index;
    }

    public int getIndex() {
        return index;
    }
}
