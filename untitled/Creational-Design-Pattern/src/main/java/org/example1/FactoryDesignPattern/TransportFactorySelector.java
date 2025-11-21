package org.example1.FactoryDesignPattern;

public class TransportFactorySelector {

    private enum TransportTypeEnum  {
        ROAD(new TruckFactory()),
        WATER(new ShipFactory()),
        AIR(new AirCraftFactory());


        private final VehicleFactory index;

        TransportTypeEnum(VehicleFactory index) {
            this.index = index;
        }
        private VehicleFactory getIndex()
        {
            return this.index;
        }

        private static TransportTypeEnum getTransportObj(String type)
        {
            return TransportTypeEnum.valueOf(type.toUpperCase());

        }
    }
    public static VehicleFactory getTransportFactory(String transportType) throws Exception {
        return TransportTypeEnum.getTransportObj(transportType).getIndex();

    }
}

