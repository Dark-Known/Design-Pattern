package InformationObject;

import Service.ICounter;
import Service.SalesCounterService;

public class InMemoryVictoriaFamilyUnits implements InMemoryUnits {
    private final SalesCounterService chairCounterService=new SalesCounterService();
    private final SalesCounterService sofaCounterService=new SalesCounterService();

    @Override
    public int totalChairSold(){
        return chairCounterService.getCount();
    }
    @Override
    public int totalSofaSold(){
        return sofaCounterService.getCount();
    }

    @Override
    public ICounter getChairCounter() {
        return this.chairCounterService;
    }

    @Override
    public ICounter getSofaCounter() {
        return this.sofaCounterService;
    }

    @Override
    public void incrementChairCount(){
        chairCounterService.increment();
    }
    @Override
    public void incrementSofaCount(){
        sofaCounterService.increment();
    }
}
