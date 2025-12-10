package Service;

import AbstractFactoryDesignPattern.IChair;

public class SalesCounterService implements ICounter {
    private int counter;

    @Override
    public void increment() {
        counter++;
    }

    @Override
    public int getCount() {
        return counter;

    }
}
