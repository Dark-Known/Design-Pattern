package TestForService;

import Service.SalesCounterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestForSalesCounterService {
    SalesCounterService salesCounterService;



    @BeforeEach
    void setUp()
    {
        salesCounterService= new SalesCounterService();
    }



    @Test
    void ShouldStartWithZeroCount()
    {
        Assertions.assertEquals(0,salesCounterService.getCount());
    }


    @Test
    void IncrementShouldBeByOne()
    {
        salesCounterService.increment();
        Assertions.assertEquals(1,salesCounterService.getCount());
    }


    @Test
    void IncrementCanBeDoneMultipleTimes()
    {
        salesCounterService.increment();
        salesCounterService.increment();
        salesCounterService.increment();

        Assertions.assertEquals(3,salesCounterService.getCount());
    }



    @Test
    void testingUnderMultipleThreadsShouldNotCorruptCounter() throws InterruptedException {
        int totalThreads=10;
        int totalIncrements=1000;
        Thread[] workerThreads= new Thread[totalThreads];
        for(int ind=0 ; ind<totalThreads; ind++)
        {
            workerThreads[ind]=new Thread(()->{
                for(int i=0;i<totalIncrements;i++)
                {
                    salesCounterService.increment();
                }

            });
        }

        for(Thread t : workerThreads)
        {
            t.start();
        }
        for(Thread t :workerThreads)
        {
            t.join();
        }


        int expectedCount = totalThreads * totalIncrements;

        Assertions.assertEquals(expectedCount,salesCounterService.getCount());
    }

}
