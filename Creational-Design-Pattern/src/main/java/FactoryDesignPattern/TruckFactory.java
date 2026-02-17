package FactoryDesignPattern;

class TruckFactory extends VehicleFactory {


    @Override
    public Vehicle transport() {
        return new Truck();
    }
}

