package InformationObject;

import Service.SalesCounterService;

public class InMemoryModernFamilyUnits implements InMemoryUnits {
    private  SalesCounterService chairCounterService;
    private  SalesCounterService sofaCounterService;

    @Override
    public int totalChairSold(){
        return chairCounterService.getCount();
    }
    @Override
    public int totalSofaSold(){
        return sofaCounterService.getCount();
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
