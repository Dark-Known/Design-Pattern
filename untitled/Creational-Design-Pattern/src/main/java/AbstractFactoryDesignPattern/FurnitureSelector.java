package AbstractFactoryDesignPattern;

public class FurnitureSelector {
    private final String furnitureName;

    private final FurnitureFamilyFactory familyFactory;


    private enum MethodSelectorEnum{
        CHAIR{
            @Override
            Object getMethod(FurnitureFamilyFactory familyFactory) {
                return familyFactory.createChair();
            }
        },
        SOFA{
            @Override
            Object getMethod(FurnitureFamilyFactory familyFactory) {
                return familyFactory.createSofa();
            }
        };

        abstract Object getMethod(FurnitureFamilyFactory familyFactory);
    }

    public FurnitureSelector(String furnitureName, FurnitureFamilyFactory familyFactory)
    {
        this.familyFactory=familyFactory;
        this.furnitureName=furnitureName;
    }




    public Object getFurniture(){
        try {
            MethodSelectorEnum selector = MethodSelectorEnum.valueOf(furnitureName.toUpperCase());
            return selector.getMethod(familyFactory);
        }
        catch (IllegalStateException e)
        {
            throw new IllegalStateException("Invalid furniture name");
        }

    }
    public void setFurnitureInfoObj(){


    }
}
