package BuilderDesignPattern;

public interface Builder {
    public Builder reset();
    public Builder setTransportInfo();
    public Builder setDistanceInfo();
    public Builder setCargoInfo();
}
