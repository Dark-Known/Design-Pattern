package org.example1.FactoryDesignPattern;

class ShipFactory extends VehicleFactory {


    @Override
    public Vehicle transport() {
        return new Ship();

    }
}

