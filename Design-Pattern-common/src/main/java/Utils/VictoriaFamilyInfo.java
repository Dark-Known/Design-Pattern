package Utils;

import Service.CurrentTimeService;

public enum VictoriaFamilyInfo {
    MANF_NAME("Victorian COMPANY"),
    MANF_ADD("Victorian ADDRESS"),
    MATERIAL("cotton"),
    CHAIR_LEGS(4),
    SOFA_LEGS(5);
    private String name;
    private int count;

    VictoriaFamilyInfo(String name) {
        this.name = name;
    }

    VictoriaFamilyInfo(int count) {
        this.count = count;
    }

    public static FurnitureInfo buildInfo() {
        CurrentTimeService timeService = new CurrentTimeService();
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                timeService.getDate());
    }
    public static FurnitureInfo buildInfo(String manfDate)
    {
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                manfDate);

    }
    public static FurnitureInfo buildInfo(CurrentTimeService timeService)
    {
        return new FurnitureInfo(
                ModernFamilyInfo.MANF_NAME.getName(),
                ModernFamilyInfo.MANF_ADD.getName(),
                ModernFamilyInfo.MATERIAL.getName(),
                timeService.getTimeStamp());

    }

    public String getName() {
        return this.name;

    }

    public int getValue() {
        return this.count;
    }
}
