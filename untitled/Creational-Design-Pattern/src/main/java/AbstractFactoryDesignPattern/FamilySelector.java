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

    public FurnitureInfo getFamilyInfo()
    {
        FurnitureFamilyFactory familyFactory= this.getFamilyFactory();
        return familyFactory.getFamilyInfo();
    }

    public  FurnitureFamilyFactory getFamilyFactory()
    {
        try {
            return FamilyEnum.getFamilyType(familyName.toUpperCase()).getFamilyFactory();
        }
        catch(IllegalStateException e)
        {
            throw new IllegalStateException("Family Name invalid");
        }
    }

}
