package org.example1.AbstractFactoryDesignPattern;

public class ModernFurnitureFactory extends FurnitureFamilyFactory {

    @Override
    public IChair createChair() {
        return new ModernChair();
    }

    @Override
    public ISofa createSofa() {
        return new ModernSofa();
    }
}
