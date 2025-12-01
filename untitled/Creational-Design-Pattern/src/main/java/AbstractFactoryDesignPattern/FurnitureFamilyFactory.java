package AbstractFactoryDesignPattern;

public abstract class FurnitureFamilyFactory {

    public abstract IChair createChair();

    public abstract ISofa createSofa();

    public abstract FurnitureInfo getFamilyInfo();


}
