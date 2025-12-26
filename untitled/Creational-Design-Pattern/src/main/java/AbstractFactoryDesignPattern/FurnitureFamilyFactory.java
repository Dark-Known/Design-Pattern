package AbstractFactoryDesignPattern;

import InformationObject.InMemoryModernFamilyUnits;
import InformationObject.InMemoryUnits;
import InformationObject.InMemoryVictoriaFamilyUnits;

public abstract class FurnitureFamilyFactory {


    public abstract IChair createChair();

    public abstract ISofa createSofa();



    public abstract FurnitureInfo getFamilyInfo();

}
