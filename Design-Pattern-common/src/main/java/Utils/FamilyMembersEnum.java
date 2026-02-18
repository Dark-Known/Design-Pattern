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

    public static FurnitureInfo Info(String familyName) {
        return FamilyMembersEnum.valueOf(familyName.toUpperCase()).getFamilyInfo();
    }

    abstract FurnitureInfo getFamilyInfo();
}
