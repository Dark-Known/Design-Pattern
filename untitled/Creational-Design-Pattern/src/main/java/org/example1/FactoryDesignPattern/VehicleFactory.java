package org.example1.FactoryDesignPattern;

public abstract class VehicleFactory {


    public abstract Vehicle transport();


    public void notifyUser() {
        Vehicle responseTransport = this.transport();
        responseTransport.deliver();
    }

}
