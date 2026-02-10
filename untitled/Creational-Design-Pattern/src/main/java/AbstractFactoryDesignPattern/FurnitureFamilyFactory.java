package AbstractFactoryDesignPattern;

import Utils.FurnitureInfo;

public abstract class FurnitureFamilyFactory {


    public abstract IChair createChair();

    public abstract ISofa createSofa();



    public abstract FurnitureInfo getFamilyInfo();

}
