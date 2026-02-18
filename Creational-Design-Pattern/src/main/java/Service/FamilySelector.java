package Service;

import AbstractFactoryDesignPattern.FurnitureFamilyFactory;
import AbstractFactoryDesignPattern.ModernFurnitureFactory;
import AbstractFactoryDesignPattern.VictoriaFurnitureFactory;

public class FamilySelector {
    final String familyName;

    public FamilySelector(String familyName) {
        this.familyName = familyName;
    }

    public FurnitureFamilyFactory getFamilyFactory() {

        return FamilyEnum.getFamilyType(familyName.toUpperCase()).getFamilyFactory();
    }

//    public FurnitureInfo getFamilyInfo()
//    {
//        FurnitureFamilyFactory familyFactory= this.getFamilyFactory();
//        return familyFactory.getFamilyInfo();
//    }

    private enum FamilyEnum {
        MODERN(new ModernFurnitureFactory()),
        VICTORIA(new VictoriaFurnitureFactory());

        private FurnitureFamilyFactory furnitureFamilyFactory;

        FamilyEnum(FurnitureFamilyFactory furnitureFamilyFactory) {
            this.furnitureFamilyFactory = furnitureFamilyFactory;
        }

        static FamilyEnum getFamilyType(String familyName) {
            try {
                return FamilyEnum.valueOf(familyName);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Family Name invalid");
            }
        }

        FurnitureFamilyFactory getFamilyFactory() {
            return this.furnitureFamilyFactory;

        }

    }

}
