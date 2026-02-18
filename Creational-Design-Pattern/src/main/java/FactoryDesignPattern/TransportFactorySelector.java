package FactoryDesignPattern;

public class TransportFactorySelector {

    public static VehicleFactory getTransportFactory(String transportType) throws Exception {
        return TransportTypeEnum.getTransportObj(transportType).getIndex();

    }

    private enum TransportTypeEnum {
        ROAD(new TruckFactory()),
        WATER(new ShipFactory()),
        AIR(new AirCraftFactory());


        private final VehicleFactory index;

        TransportTypeEnum(VehicleFactory index) {
            this.index = index;
        }

        private static TransportTypeEnum getTransportObj(String type) {
            return TransportTypeEnum.valueOf(type.toUpperCase());

        }

        private VehicleFactory getIndex() {
            return this.index;
        }
    }
}

