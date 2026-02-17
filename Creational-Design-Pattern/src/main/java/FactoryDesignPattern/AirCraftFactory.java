package FactoryDesignPattern;

class AirCraftFactory extends VehicleFactory {


    @Override
    public Vehicle transport() {
        return new AirCraft();
    }
}
