package AbstractFactoryDesignPattern;

public class FamilySelector {
    final String familyName;

    private enum FamilyEnum{
        MODERN(new ModernFurnitureFactory()),
        VICTORIA(new VictoriaFurnitureFactory());

        private FurnitureFamilyFactory furnitureFamilyFactory;

        FamilyEnum(FurnitureFamilyFactory furnitureFamilyFactory)
        {
            this.furnitureFamilyFactory=furnitureFamilyFactory;
        }
        static FamilyEnum getFamilyType(String familyName)
        {
            return FamilyEnum.valueOf(familyName);
        }
        FurnitureFamilyFactory getFamilyFactory()
        {
            return this.furnitureFamilyFactory;
        }
    }
    public FamilySelector(String familyName)
    {
        this.familyName= familyName;
    }

    public  FurnitureFamilyFactory getFamilyFactory()
    {
        return FamilyEnum.getFamilyType(familyName.toUpperCase()).getFamilyFactory();
    }
}
