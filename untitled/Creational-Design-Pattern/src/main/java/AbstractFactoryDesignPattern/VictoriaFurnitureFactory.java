package AbstractFactoryDesignPattern;

public class VictoriaFurnitureFactory extends FurnitureFamilyFactory{
    @Override
    public IChair createChair() {
        return new VictoriaChair();
    }

    @Override
    public ISofa createSofa() {
        return new VictoriaSofa();
    }
}