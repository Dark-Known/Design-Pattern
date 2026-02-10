package Utils;

public enum FamilyMembersEnum {
   MODERN {
       @Override
       FurnitureInfo getFamilyInfo() {
           return ModernFamilyInfo.buildInfo();
       }
   },
    VICTORIA {
        @Override
        FurnitureInfo getFamilyInfo() {
            return VictoriaFamilyInfo.buildInfo();
        }
    };

    abstract FurnitureInfo getFamilyInfo();


    public FurnitureInfo Info(String familyName)
    {
        return FamilyMembersEnum.valueOf(familyName).getFamilyInfo();
    }
}
