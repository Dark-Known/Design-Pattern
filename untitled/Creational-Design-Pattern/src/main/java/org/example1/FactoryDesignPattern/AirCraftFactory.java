package org.example1.FactoryDesignPattern;

class AirCraftFactory extends VehicleFactory {


    @Override
    public Vehicle transport() {
        return new AirCraft();
    }
}
