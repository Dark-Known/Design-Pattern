package Service;

import AbstractFactoryDesignPattern.IChair;

import java.util.concurrent.atomic.AtomicInteger;

public class SalesCounterService implements ICounter {
    private final AtomicInteger counter=new AtomicInteger(0);

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public int getCount() {
       return counter.intValue();

    }

}
