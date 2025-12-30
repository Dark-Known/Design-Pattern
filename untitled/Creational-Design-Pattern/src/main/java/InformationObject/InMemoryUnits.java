package InformationObject;

import Service.ICounter;

public interface InMemoryUnits {
    public void incrementChairCount();
    public void incrementSofaCount();
    public int totalChairSold();
    public int totalSofaSold();
    public ICounter getChairCounter();
    public ICounter getSofaCounter();
}
