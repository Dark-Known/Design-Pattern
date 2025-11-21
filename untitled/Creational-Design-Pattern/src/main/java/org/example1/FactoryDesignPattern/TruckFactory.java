package org.example1.FactoryDesignPattern;

class TruckFactory extends VehicleFactory {


    @Override
    public Vehicle transport() {
        return new Truck();
    }
}

