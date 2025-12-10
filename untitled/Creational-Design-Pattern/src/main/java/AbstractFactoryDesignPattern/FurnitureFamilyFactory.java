package AbstractFactoryDesignPattern;

public abstract class FurnitureFamilyFactory {

    public abstract IChair createChair();

    public abstract int totalChairSold();
    public abstract ISofa createSofa();
    public abstract int totalSofaSold();


    public abstract FurnitureInfo getFamilyInfo();



}
